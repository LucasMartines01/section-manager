package com.ezliv.infrastructure.controllers.products;

import com.ezliv.domain.product.Product;
import com.ezliv.domain.product.Variation;
import com.ezliv.infrastructure.controllers.products.dtos.ProductRequestDTO;
import com.ezliv.infrastructure.controllers.products.dtos.ProductResponseDTO;
import com.ezliv.infrastructure.controllers.products.dtos.SpreadSheetDto;
import com.ezliv.infrastructure.controllers.products.dtos.VariationRequestDTO;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;

import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProductUtils {
    @Value("${product.chunk-size}")
    private static int CHUNK_SIZE = 100;


    public static Product toDomain(ProductRequestDTO dto) {
        return new Product(
                dto.name(),
                dto.imageUrl(),
                dto.description(),
                dto.price(),
                dto.promotionalPrice(),
                dto.quantity(),
                dto.measure(),
                dto.variations().stream().map(ProductUtils::toVariationDomain).toList()
        );
    }

    public static Variation toVariationDomain(VariationRequestDTO dto) {
        return new Variation(
                dto.name(),
                dto.imageUrl(),
                dto.description(),
                dto.price(),
                dto.quantity()
        );
    }

    public static ProductResponseDTO toDto(Product product) {
        return new ProductResponseDTO(
                product
        );
    }

    public static List<Product> getProductsFromSpreadSheet(SpreadSheetDto dto) {
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            byte[] decodedBytes = Base64.getDecoder().decode(dto.fileContentBase64());

            try (ByteArrayInputStream inputStream = new ByteArrayInputStream(decodedBytes);
                 XSSFWorkbook workbook = new XSSFWorkbook(inputStream)) {

                Sheet sheet = workbook.getSheetAt(0);
                int totalRows = sheet.getPhysicalNumberOfRows();


                int totalChunks = (int) Math.ceil((double) totalRows / CHUNK_SIZE);

                List<CompletableFuture<List<Product>>> futures = new ArrayList<>();

                for (int i = 0; i < totalChunks; i++) {
                    CompletableFuture<List<Product>> futureChunk = convertSpreadSheetToProducts(sheet, CHUNK_SIZE, i * CHUNK_SIZE);
                    futures.add(futureChunk);
                }

                CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

                CompletableFuture<List<Product>> allProductsFuture = allFutures.thenApply(v ->
                        futures.stream()
                                .map(CompletableFuture::join)
                                .flatMap(List::stream)
                                .toList()
                );

                return allProductsFuture.get();

            } catch (Exception e) {
                throw new RuntimeException("Erro ao processar a planilha", e);
            }
        }
    }

    private static CompletableFuture<List<Product>> convertSpreadSheetToProducts(Sheet sheet, int chunkSize, int startRow) {
        return CompletableFuture.supplyAsync(() -> {
            List<Product> chunk = new ArrayList<>();

            int totalRows = sheet.getPhysicalNumberOfRows();

            for (int i = startRow; i < startRow + chunkSize && i < totalRows; i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue;
                Product product = new Product();
                product.setName(row.getCell(0).getStringCellValue());
                product.setImageUrl(row.getCell(1).getStringCellValue());
                product.setDescription(row.getCell(2).getStringCellValue());
                product.setPrice(BigDecimal.valueOf(row.getCell(3).getNumericCellValue()));
                product.setPromotionalPrice(BigDecimal.valueOf(row.getCell(4).getNumericCellValue()));
                product.setQuantity(BigDecimal.valueOf(row.getCell(5).getNumericCellValue()));
                product.setMeasure(row.getCell(6).getStringCellValue());
                product.setVariations(List.of());
                chunk.add(product);
            }
            return chunk;
        });
    }
}

package com.ezliv.infrastructure.controllers.products.dtos;

import jakarta.validation.constraints.NotBlank;

public record SpreadSheetDto(@NotBlank String fileName, @NotBlank String fileContentBase64) {
}

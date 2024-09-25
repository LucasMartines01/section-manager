package com.ezliv.domain.section;
import com.ezliv.domain.banner.Banner;
import com.ezliv.domain.product.Product;

import java.util.List;

public class Section {
    private String name;
    private String summary;
    private List<Banner> banners;
    private List<Product> products;
    private SectionType type;
}

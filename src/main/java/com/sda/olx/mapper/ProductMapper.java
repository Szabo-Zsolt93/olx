package com.sda.olx.mapper;

import com.sda.olx.dto.ProductDto;
import com.sda.olx.entity.Product;
import com.sda.olx.enums.ProductCategory;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product map(ProductDto productDto){
        return Product.builder()
                .name(productDto.getName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .category(ProductCategory.valueOf(productDto.getCategory()))
                .build();
    }

}

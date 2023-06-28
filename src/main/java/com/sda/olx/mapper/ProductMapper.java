package com.sda.olx.mapper;

import com.sda.olx.dto.ProductDto;
import com.sda.olx.entity.Product;
import com.sda.olx.enums.ProductCategory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.apache.tomcat.util.buf.ByteChunk.convertToBytes;

@Component
public class ProductMapper {

    public Product map(ProductDto productDto, MultipartFile productImage){
        return Product.builder()
                .name(productDto.getName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .category(ProductCategory.valueOf(productDto.getCategory()))
                .image(convertToBytes(productImage))
                .build();
    }

    private byte[] convertToBytes(MultipartFile multipartFile) {
        try {
            return multipartFile.getBytes();
        } catch (IOException e) {
            return new byte[0];
        }
    }


}

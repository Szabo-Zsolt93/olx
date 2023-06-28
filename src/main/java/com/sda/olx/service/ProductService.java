package com.sda.olx.service;

import com.sda.olx.dto.ProductDto;
import com.sda.olx.entity.Product;
import com.sda.olx.mapper.ProductMapper;
import com.sda.olx.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;
    public void addProduct(ProductDto productDto, MultipartFile productImage){
        Product product = productMapper.map(productDto,productImage);
        productRepository.save(product);

    }

}

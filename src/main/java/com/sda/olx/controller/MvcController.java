package com.sda.olx.controller;

import com.sda.olx.dto.ProductDto;
import com.sda.olx.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MvcController {
    @Autowired
    private ProductService productService;

    @GetMapping("/addProduct")
    public String addProductGet(Model model){
        ProductDto productDto = new ProductDto();
        model.addAttribute("productDto",productDto);
        return "addProduct";


    }
    @PostMapping("/addProduct")
    public String addProductPost(@ModelAttribute(name="productDto")ProductDto productDto){
        productService.addProduct(productDto);
        System.out.println(productDto);
        return "redirect:/addProduct";
    }

}

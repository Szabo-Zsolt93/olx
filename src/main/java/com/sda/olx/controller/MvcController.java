package com.sda.olx.controller;

import com.sda.olx.dto.LoginDto;
import com.sda.olx.dto.ProductDto;
import com.sda.olx.dto.UserDto;
import com.sda.olx.service.LoginService;
import com.sda.olx.service.ProductService;
import com.sda.olx.service.UserService;
import com.sda.olx.validator.UserValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class MvcController {
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private LoginService loginService;
    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @GetMapping("/addProduct")
    public String addProductGet(Model model) {
        ProductDto productDto = new ProductDto();
        model.addAttribute("productDto", productDto);
        return "addProduct";

    }

    @PostMapping("/addProduct")
    public String addProductPost(@ModelAttribute(name = "productDto") ProductDto productDto, @RequestParam("productImage") MultipartFile productImage)
            throws IOException {
        productService.addProduct(productDto, productImage);
        System.out.println(productDto);
        return "redirect:/addProduct";
    }

    @GetMapping("/home")
    public String homeGet() {
        return "home";
    }

    @GetMapping("/registration")
    public String registrationGet(Model model) {
        UserDto userDto = new UserDto();
        System.out.println("S-a apelat registration");
        model.addAttribute("userDto", userDto);
        return "registration";
    }

    @PostMapping("/registration")
    public String registrationPost(@ModelAttribute(name = "userDto")@Valid UserDto userDto, BindingResult bindingResult) {
        userValidator.validate(userDto,bindingResult);
        if(bindingResult.hasErrors()){
            return "registration";
        }
        userService.createUser(userDto);
        return "redirect:/registration";

    }

    @GetMapping("/login")
    public String loginGet(Model model) {
        LoginDto loginDto = new LoginDto();
        model.addAttribute("loginDto", loginDto);
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(@ModelAttribute (name = "loginDto")  LoginDto loginDto, Model model) {
        Boolean loginSuccessful = loginService.login(loginDto);
        System.out.println("S-a apelat login");
        if(loginSuccessful){
            model.addAttribute("loginMessage","Login was successful!");
        }else {
            model.addAttribute("loginMessage","Login failed");
        }
        return "login";

    }
}

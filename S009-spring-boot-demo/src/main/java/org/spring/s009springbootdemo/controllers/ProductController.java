package org.spring.s009springbootdemo.controllers;

import org.spring.s009springbootdemo.models.Product;
import org.spring.s009springbootdemo.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {
    private final ProductServices productServices;

    @Autowired
    public ProductController(ProductServices productServices) {
        this.productServices = productServices;
    }

    @GetMapping("/{username}/products")
    public String viewProducts(
            @PathVariable String username,
            Model model) {
        var allProducts = productServices.findAll();
        model.addAttribute("username", username);
        model.addAttribute("products", allProducts);
        return "products.html";
    }

    @PostMapping("/{username}/products")
    public String addProduct(
            @PathVariable String username,
//            @RequestParam String name, // we can use @ModelAttribute instead of @RequestParam 💡
//            @RequestParam double price,
            @ModelAttribute Product product,
            Model model) {
        productServices.addProduct(product);
        var allProducts = productServices.findAll();
        model.addAttribute("username", username);
        model.addAttribute("products", allProducts);
        return "products.html";
    }
}

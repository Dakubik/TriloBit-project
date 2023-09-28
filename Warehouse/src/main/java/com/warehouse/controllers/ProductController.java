package com.warehouse.controllers;

import com.warehouse.models.Product;
import com.warehouse.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @GetMapping("/warehouse")
    public String getWarehouse(Model model) {

        Iterable<Product> products = productRepository.findAll();
        model.addAttribute("products", products);

        return "warehouse";
    }
}

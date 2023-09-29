package com.warehouse.controllers;

import com.warehouse.models.Product;
import com.warehouse.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/add")
    public String addProduct(Model model) {
        model.addAttribute("products", new Product());

        return "addProduct";
    }

    @PostMapping("/add")
    public String submitProduct(@ModelAttribute Product product) {
        productRepository.save(product);

        return "redirect:/warehouse";
    }

    @GetMapping("/edit/{productId}")
    public String editProduct(@PathVariable Long productId, Model model) {
        Product product = productRepository.findById(productId).orElse(null);

        if (product != null) {
            model.addAttribute("product", product);
            return "editProduct";
        } else {
            return "redirect:/warehouse";
        }
    }

    @PostMapping("/edit/{productId}")
    public String submitEditedProduct(
            @PathVariable Long productId,
            @ModelAttribute Product updatedProduct) {

        Product product = productRepository.findById(productId).orElse(null);

        if (product != null) {

            product.setName(updatedProduct.getName());
            product.setDescription(updatedProduct.getDescription());
            product.setPrice(updatedProduct.getPrice());
            product.setStock(updatedProduct.getStock());
            product.setEanCode(updatedProduct.getEanCode());

            productRepository.save(product);
            return "redirect:/warehouse";
        } else {
            return "redirect:/warehouse";
        }
    }

    @GetMapping("/delete/{productId}")
    public String deleteProduct(@PathVariable Long productId) {
        Product product = productRepository.findById(productId).orElse(null);

        assert product != null;
        productRepository.delete(product);

        return "redirect:/warehouse";
    }

}

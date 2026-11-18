package com.example.dao_product_app;

import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/fetch-product")
    public String getProductName(@RequestParam String name) {
        String product = productRepository.getProductName(name);
        return product != null ? product : "Продукт не найден";
    }
}

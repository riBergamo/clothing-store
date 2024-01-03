package com.api.clothingstore.controllers;

import com.api.clothingstore.dtos.ProductDto;
import com.api.clothingstore.models.Product;
import com.api.clothingstore.repository.ProductRepository;
import com.api.clothingstore.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    private ResponseEntity<Object> create(@RequestBody ProductDto productDto) {
        Product created = productService.create(productDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    private ResponseEntity<List<Product>> getAll() {
        List<Product> products = productService.getAll();

        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping("/{name}")
    private ResponseEntity<Object> getOne(@PathVariable String name) {
        return productService.getOne(name);
    }

    @PutMapping("/{id}")
    private ResponseEntity<Object> update(@PathVariable UUID id, @RequestBody ProductDto productDto) {
        return productService.update(id, productDto);

    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Object> delete(@PathVariable UUID id) {
        return productService.delete(id);
    }
}

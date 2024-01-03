package com.api.clothingstore.service;

import com.api.clothingstore.dtos.ProductDto;
import com.api.clothingstore.models.Product;
import com.api.clothingstore.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public Product create(ProductDto productDto) {
        Product product = Product.builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .stock(productDto.getStock())
                .size(productDto.getSize())
                .build();

        productRepository.save(product);

        return productRepository.save(product);
    }

    public List<Product> getAll() {

        return productRepository.findAll();
    }

    public ResponseEntity<Object> getOne(String name) {
        List<Product> products = productRepository.findByName(name);

        if (products.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(products);
        }
    }

    @Transactional
    public ResponseEntity<Object> update(UUID id, ProductDto productDto) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();

            product.setName(productDto.getName());
            product.setPrice(productDto.getPrice());
            product.setStock(productDto.getStock());
            product.setSize(productDto.getSize());

            productRepository.save(product);

            return ResponseEntity.status(HttpStatus.OK).body(product);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
    }

    @Transactional
    public ResponseEntity<Object> delete(UUID id) {
        Optional<Product> product = productRepository.findById(id);

        if (product.isPresent()) {
            productRepository.delete(product.get());

            return ResponseEntity.status(HttpStatus.OK).body("Product deleted sucessfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
    }

}

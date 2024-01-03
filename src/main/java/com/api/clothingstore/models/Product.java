package com.api.clothingstore.models;

import com.api.clothingstore.enums.ClothingSize;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Builder
@Data
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private BigDecimal price;
    private int stock;
    private ClothingSize size;

    public Product() {
    }

    public Product(UUID id, String name, BigDecimal price, int stock, ClothingSize size) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.size = size;
    }
}

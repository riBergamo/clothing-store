package com.api.clothingstore.dtos;

import com.api.clothingstore.enums.ClothingSize;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductDto {

    @NotBlank
    private UUID id;
    @NotBlank @Size(max = 80)
    private String name;
    @NotBlank
    private BigDecimal price;
    @NotBlank
    private int stock;
    @NotBlank
    private ClothingSize size;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public ClothingSize getSize() {
        return size;
    }

    public void setSize(ClothingSize size) {
        this.size = size;
    }
}

package com.example.apiexcercise.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Item {
    @Id
    @GeneratedValue
    private Integer id;
    private String itemId;
    private String description;
    private String brand;
    private BigDecimal price;

    public Item(String itemId, String description,  String brand, BigDecimal price) {
        this.itemId = itemId;
        this.description = description;
        this.brand = brand;
        this.price = price;
    }
}

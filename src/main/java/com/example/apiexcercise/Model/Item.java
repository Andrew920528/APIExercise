package com.example.apiexcercise.Model;

import javax.persistence.*;

@Entity
@Table
public class Item {
    @Id
    @SequenceGenerator(
            name = "item_sequence",
            sequenceName = "item_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "item_sequence"
    )
    private Integer id;

    private String itemID;
    private String description;
    private String brand;
    private double price;

    public Item(Integer id, String itemID, String description, String brand, double price) {
        this.id = id;
        this.itemID = itemID;
        this.description = description;
        this.brand = brand;
        this.price = price;
    }

    public Item(String itemID, String description,  String brand, double price) {
        this.description = description;
        this.itemID = itemID;
        this.brand = brand;
        this.price = price;
    }

    public Item() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id + '\'' +
                ", item_id=" + itemID + '\'' +
                ", description='" + description + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}

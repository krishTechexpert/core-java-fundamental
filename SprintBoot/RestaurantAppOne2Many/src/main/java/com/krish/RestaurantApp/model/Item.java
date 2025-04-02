package com.krish.RestaurantApp.model;

import jakarta.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue(generator="item_gen", strategy = GenerationType.AUTO)
    @SequenceGenerator(name="item_gen",sequenceName="item_sequence",initialValue = 1,allocationSize = 1)
    private Integer itemId;

    @Column(name="itemname",length=20)
    private String itemName; //

    @Column(length=20)
    private String category; //starter,maincourse or desert or breakfast beverages

    @Column(length=20)
    private String cuisine; // southIndian,northIndian,italian
    private double price;

    public Item(){

    }

    public Item(String itemName, String category, String cuisine, double price) {
        this.itemName = itemName;
        this.category = category;
        this.cuisine = cuisine;
        this.price = price;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", category='" + category + '\'' +
                ", cuisine='" + cuisine + '\'' +
                ", price=" + price +
                '}';
    }
}

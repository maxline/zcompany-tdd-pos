package com.zcompany.pos;

public class Product {
    private int price;
    private String name;

    public Product(String name, int price) {
        this.price = price;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }
}

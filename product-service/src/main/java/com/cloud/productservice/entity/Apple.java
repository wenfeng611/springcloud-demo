package com.cloud.productservice.entity;


public class Apple extends Product {
    String color;
    int id;

    public Apple(int id,String color,String name,double price) {
        super(name,price);
        this.color = color;
        this.id=id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

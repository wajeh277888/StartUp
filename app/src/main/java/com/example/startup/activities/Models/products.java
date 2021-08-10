package com.example.startup.activities.Models;


public class products {


    public String description = " ";
    public String name = "";
    public int price = 0;
    public int quantity = 0;
    public static String userAnswer = "";

    public products(String description, String name, int price, int quantity) {
        this.description = description;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public products() {
    }

    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public int getprice() {
        return price;
    }

    public void setquantity(int quantity) {
        this.quantity = quantity;
    }

    public int getquantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Product Detail{" +
                "description='" + description + '\'' +
                ", Title=" + name + '\'' +
                ", price" + price + '\'' +
                ", Quantity'" + quantity + '\'' +
                '}';
    }
}



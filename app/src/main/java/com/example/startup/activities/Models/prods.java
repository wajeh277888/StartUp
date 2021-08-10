package com.example.startup.activities.Models;

import java.util.HashMap;
import java.util.Map;

public class prods {

    String id;
    public String title = "";
    int price;
    Map<String, com.example.startup.activities.Models.products> prod;

    public Map<String, products> products = new HashMap<String, products>();

    public prods(String id, String title,int price) {
        this.id = id;
        this.title = title;
        this.price=price;
       // this.prod= (Map<String, com.example.startup.activities.Models.products>) p;
    }

    public prods() {

    }


    public void setid(String id) {
        this.id = id;
    }

    public void settitle(String title) {
        this.title = title;
    }

    public void setprice(int price) {
        this.price = price;
    }

    public void setproducts(Map<String, products> p) {
        this.prod = p;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Map<String, products> getproducts() {
        return products;
    }
}


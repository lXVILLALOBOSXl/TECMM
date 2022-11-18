package com.dto;

import com.dao.DataAccess;
import com.dao.ProductDAO;
import com.exception.DataAccessException;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private int id;
    private String description;
    private double price;


    public Product(String description, double price) {
        int id = ProductDAO.getProducts().size();
        this.id = ++id;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}

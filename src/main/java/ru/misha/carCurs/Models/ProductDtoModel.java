package ru.misha.carCurs.Models;

import ru.misha.carCurs.Entities.Product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductDtoModel implements Serializable {
    Long id;
    Integer price;
    Integer mileage;
    Integer number_of_owners;
    String category;
    String brand;
    String model;
    Integer release_year;
    String body;
    String color;
    String engine;
    String drive;
    String wheel;
    String picture;

    public ProductDtoModel(Long id, Integer price, Integer mileage, Integer number_of_owners, String category, String brand, String model, Integer release_year, String body, String color, String engine, String drive, String wheel, String picture) {
        this.id = id;
        this.price = price;
        this.mileage = mileage;
        this.number_of_owners = number_of_owners;
        this.category = category;
        this.brand = brand;
        this.model = model;
        this.release_year = release_year;
        this.body = body;
        this.color = color;
        this.engine = engine;
        this.drive = drive;
        this.wheel = wheel;
        this.picture = picture;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNumber_of_owners() {
        return number_of_owners;
    }

    public void setNumber_of_owners(Integer number_of_owners) {
        this.number_of_owners = number_of_owners;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getRelease_year() {
        return release_year;
    }

    public void setRelease_year(Integer release_year) {
        this.release_year = release_year;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getDrive() {
        return drive;
    }

    public void setDrive(String drive) {
        this.drive = drive;
    }

    public String getWheel() {
        return wheel;
    }

    public void setWheel(String wheel) {
        this.wheel = wheel;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    static public ProductDtoModel productMapper(Product product) {
        return new ProductDtoModel(product.getId(), product.getPrice(), product.getMileage(),
                product.getNumber_of_owners(), product.getCategory(),
                product.getBrand(), product.getModel(), product.getRelease_year(),
                product.getBody(), product.getColor(), product.getEngine(), product.getDrive(), product.getWheel(),
                product.getPicture());
    }

    static public List<ProductDtoModel> listProductMapper(List<Product> products) {
        List<ProductDtoModel> productDtoModels = new ArrayList<>();
        for (Product product : products)
            productDtoModels.add(productMapper(product));
        return productDtoModels;
    }
}

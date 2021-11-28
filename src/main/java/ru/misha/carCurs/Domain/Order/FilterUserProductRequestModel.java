package ru.misha.carCurs.Domain.Order;

public class FilterUserProductRequestModel {
    String brand;
    String model;
    Integer release_year;
    String body;

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

    @Override
    public String toString() {
        return "FilterProductRequestModel{" +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", release_year=" + release_year +
                ", body='" + body + '\'' +
                '}';
    }
}
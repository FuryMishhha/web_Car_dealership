package ru.misha.carCurs.Models;

public enum ProductCategories {
    NEW_CAR("new car"),
    SUPPORT_CAR("support car");

    final String category;

    ProductCategories(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}

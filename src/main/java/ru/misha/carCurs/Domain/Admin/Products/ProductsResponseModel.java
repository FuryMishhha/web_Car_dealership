package ru.misha.carCurs.Domain.Admin.Products;

import ru.misha.carCurs.Models.ProductDtoModel;

import java.util.List;

public class ProductsResponseModel {
    List<ProductDtoModel> products;
    String[] categories;

    public ProductsResponseModel(List<ProductDtoModel> products, String[] categories) {
        this.products = products;
        this.categories = categories;
    }

    public List<ProductDtoModel> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDtoModel> products) {
        this.products = products;
    }

    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }
}

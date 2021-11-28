package ru.misha.carCurs.Domain.Admin.Products;

import ru.misha.carCurs.Entities.Product;

import java.util.List;

public interface Admin_ProductDataAccess {
    List<Product> getAll();
    List<Product> filter(Long id, String category, String brand, String model, Integer release_year,
                         String body);
    Product findById(Long id);
    void save(Product product);
    Product deleteById(Long id);
}

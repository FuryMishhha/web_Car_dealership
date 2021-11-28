package ru.misha.carCurs.Domain.Order;

import ru.misha.carCurs.Entities.Product;

import java.util.List;

public interface OrderDataAccess {
    List<Product> getAll();
    List<Product> filter(String brand, String model, Integer release_year,
                         String body);
}

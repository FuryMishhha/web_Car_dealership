package ru.misha.carCurs.Domain.Order;

import org.springframework.stereotype.Component;
import ru.misha.carCurs.Domain.Admin.Products.ProductsResponseModel;

import java.util.HashMap;

@Component
public interface OrderInputBoundary {
    OrderResponseModel getAll();
    OrderResponseModel filterProducts(FilterUserProductRequestModel filterUserProductRequestModel);
}

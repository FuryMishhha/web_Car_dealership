package ru.misha.carCurs.Domain.Order;

import ru.misha.carCurs.Models.ProductCategories;
import ru.misha.carCurs.Models.ProductDtoModel;

import java.util.List;

public interface OrderOutputBoundary {
    OrderResponseModel prepareAllProductView(List<ProductDtoModel> productDtoModelList, ProductCategories[] categories);
}

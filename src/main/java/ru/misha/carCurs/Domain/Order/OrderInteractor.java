package ru.misha.carCurs.Domain.Order;

import ru.misha.carCurs.Domain.Admin.Products.ProductsResponseModel;
import ru.misha.carCurs.Entities.Product;
import ru.misha.carCurs.Models.ProductCategories;
import ru.misha.carCurs.Models.ProductDtoModel;

import java.util.List;

public class OrderInteractor implements OrderInputBoundary{

    private final OrderOutputBoundary orderOutputBoundary;
    private final OrderDataAccess orderDataAccess;

    public OrderInteractor(OrderOutputBoundary orderOutputBoundary, OrderDataAccess orderDataAccess) {
        this.orderOutputBoundary = orderOutputBoundary;
        this.orderDataAccess = orderDataAccess;
    }

    @Override
    public OrderResponseModel getAll() {
        List<Product> products = orderDataAccess.getAll();
        return orderOutputBoundary.prepareAllProductView(ProductDtoModel.listProductMapper(products), ProductCategories.values());
    }

    @Override
    public OrderResponseModel filterProducts(FilterUserProductRequestModel filterUserProductRequestModel) {
        List<Product> products = orderDataAccess.filter(
                filterUserProductRequestModel.getBrand(), filterUserProductRequestModel.getModel(),
                filterUserProductRequestModel.getRelease_year(), filterUserProductRequestModel.getBody());
        return orderOutputBoundary
                .prepareAllProductView(ProductDtoModel.listProductMapper(products), ProductCategories.values());
    }
}

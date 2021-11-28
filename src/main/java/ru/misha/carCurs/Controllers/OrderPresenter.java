package ru.misha.carCurs.Controllers;

import ru.misha.carCurs.Domain.Order.OrderOutputBoundary;
import ru.misha.carCurs.Domain.Order.OrderResponseModel;
import ru.misha.carCurs.Models.ProductCategories;
import ru.misha.carCurs.Models.ProductDtoModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class OrderPresenter implements OrderOutputBoundary {
    @Override
    public OrderResponseModel prepareAllProductView(List<ProductDtoModel> productDtoModelList,
                                                    ProductCategories[] categories) {
        HashMap<ProductCategories,List<ProductDtoModel>> catalog = new HashMap<>();
        for (ProductCategories p : categories) catalog.put(p, new ArrayList<>());

        for (ProductDtoModel product : productDtoModelList) {
            ProductCategories p = null;
            for (ProductCategories productCategories : categories){
                if (productCategories.getCategory().equals(product.getCategory())){
                    p = productCategories;
                    break;
                }
            }
            catalog.get(p).add(product);
        }
        return new OrderResponseModel(catalog, categories);
    }
}

package ru.misha.carCurs.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.misha.carCurs.Domain.Order.FilterUserProductRequestModel;
import ru.misha.carCurs.Domain.Order.OrderInputBoundary;
import ru.misha.carCurs.Domain.Order.OrderResponseModel;
import ru.misha.carCurs.Models.ProductCategories;

@RestController
public class OrderController {

    private final OrderInputBoundary orderInputBoundary;

    public OrderController(OrderInputBoundary orderInputBoundary) {
        this.orderInputBoundary = orderInputBoundary;
    }

    @GetMapping("/getProductsCategories")
    public String[] getAllProductCategories(){
        String[] categories = new String[ProductCategories.values().length];
        for (int i = 0; i < ProductCategories.values().length; i++) {
            categories[i] = ProductCategories.values()[i].getCategory();
        }
        return categories;
    }

    @GetMapping("/get_catalog")
    public OrderResponseModel getAllProducts(){
        return orderInputBoundary.getAll();
    }

    @PostMapping("/filterProducts")
    public OrderResponseModel filterProduct(@RequestBody FilterUserProductRequestModel filterUserProductRequestModel){
        return orderInputBoundary.filterProducts(filterUserProductRequestModel);
    }
}

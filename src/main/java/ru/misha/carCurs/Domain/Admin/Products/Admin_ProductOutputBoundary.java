package ru.misha.carCurs.Domain.Admin.Products;

import ru.misha.carCurs.Models.ProductCategories;
import ru.misha.carCurs.Models.ProductDtoModel;

import java.util.List;

public interface Admin_ProductOutputBoundary {
    ProductsResponseModel prepareProducts(List<ProductDtoModel> productDtoModels, ProductCategories[] productCategories);
    boolean prepareSuccessAddProductView(ProductDtoModel productDtoModel);
    boolean prepareFailAddProductView();
    boolean prepareSuccessEditProductView(ProductDtoModel productDtoModel);
    ProductDtoModel prepareDeletedProductView(ProductDtoModel productDtoModel);
    ProductDtoModel prepareFindedProductView(ProductDtoModel productDtoModel);
}

package ru.misha.carCurs.Domain.Admin.Products;

import org.springframework.stereotype.Component;
import ru.misha.carCurs.Models.ProductDtoModel;

@Component
public interface Admin_ProductInputBoundary {
    ProductsResponseModel getAll();
    boolean createProduct(CreateProductRequestModel createProductRequestModel);
    ProductsResponseModel filterProducts(FilterProductRequestModel filterProductRequestModel);
    ProductDtoModel findConcreteProduct(Long id);
    boolean editProduct(Long id, EditProductRequestModel editProductRequestModel);
    ProductDtoModel deleteProduct(Long id);
}

package ru.misha.carCurs.Controllers;

import ru.misha.carCurs.Domain.Admin.Users.Admin_UserOutputBoundary;
import ru.misha.carCurs.Domain.Admin.Products.Admin_ProductOutputBoundary;
import ru.misha.carCurs.Domain.Admin.Products.ProductsResponseModel;
import ru.misha.carCurs.Models.ProductCategories;
import ru.misha.carCurs.Models.ProductDtoModel;
import ru.misha.carCurs.Models.UserDtoModel;

import java.util.List;

public class AdminPresenter implements Admin_UserOutputBoundary, Admin_ProductOutputBoundary {

    @Override
    public boolean prepareSuccessEditUserView(UserDtoModel userDtoModel) {
        return true;
    }

    @Override
    public boolean prepareFailEditUserView(UserDtoModel userDtoModel) {
        return false;
    }

    @Override
    public UserDtoModel prepareDeletedUserView(UserDtoModel userDtoModel) {
        return userDtoModel;
    }

    @Override
    public UserDtoModel prepareFindedUserView(UserDtoModel userDtoModel) {
        return userDtoModel;
    }

    @Override
    public List<UserDtoModel> convertUsers(List<UserDtoModel> users) {
        return users;
    }

    @Override
    public ProductsResponseModel prepareProducts(List<ProductDtoModel> productDtoModels, ProductCategories[] productCategories) {
        String[] categories = new String[productCategories.length];
        for (int i=0;i<productCategories.length;++i) {
            categories[i] = productCategories[i].getCategory();
        }
        return new ProductsResponseModel(productDtoModels,categories);
    }

    @Override
    public boolean prepareSuccessAddProductView(ProductDtoModel productDtoModel) {
        return true;
    }

    @Override
    public boolean prepareFailAddProductView() {
        return false;
    }

    @Override
    public boolean prepareSuccessEditProductView(ProductDtoModel productDtoModel) {
        return true;
    }

    @Override
    public ProductDtoModel prepareDeletedProductView(ProductDtoModel productDtoModel) {
        return productDtoModel;
    }

    @Override
    public ProductDtoModel prepareFindedProductView(ProductDtoModel productDtoModel) {
        return productDtoModel;
    }
}

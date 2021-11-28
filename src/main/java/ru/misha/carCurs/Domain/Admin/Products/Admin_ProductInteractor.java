package ru.misha.carCurs.Domain.Admin.Products;

import ru.misha.carCurs.Entities.Product;
import ru.misha.carCurs.Models.ProductCategories;
import ru.misha.carCurs.Models.ProductDtoModel;

import java.util.List;

public class Admin_ProductInteractor implements Admin_ProductInputBoundary {
    Admin_ProductDataAccess admin_productDataAccess;

    Admin_ProductOutputBoundary admin_productOutputBoundary;

    public Admin_ProductInteractor(Admin_ProductDataAccess admin_productDataAccess,
                                   Admin_ProductOutputBoundary admin_productOutputBoundary) {
        this.admin_productDataAccess = admin_productDataAccess;
        this.admin_productOutputBoundary = admin_productOutputBoundary;
    }

    @Override
    public ProductsResponseModel getAll() {
        List<Product> products = admin_productDataAccess.getAll();
        return admin_productOutputBoundary
                .prepareProducts(ProductDtoModel.listProductMapper(products), ProductCategories.values());
    }

    @Override
    public boolean createProduct(CreateProductRequestModel createProductRequestModel) {
        if (createProductRequestModel.getBrand().equals("") || createProductRequestModel.getPrice() == null
                || createProductRequestModel.getBody().equals("")
                || createProductRequestModel.getModel().equals("") || createProductRequestModel.getRelease_year() == null
                || createProductRequestModel.getColor().equals("") || createProductRequestModel.getEngine().equals("")
                || createProductRequestModel.getDrive().equals("") || createProductRequestModel.getWheel().equals("")
                || createProductRequestModel.getCategory().equals("") || createProductRequestModel.getPicture().equals("")
                || (createProductRequestModel.getCategory().equals("support car") &&
                (createProductRequestModel.getMileage() == null || createProductRequestModel.getNumber_of_owners() == null))) {
            return admin_productOutputBoundary.prepareFailAddProductView();
        }
        Product product = new Product(
                createProductRequestModel.getMileage(),
                createProductRequestModel.getNumber_of_owners(),
                createProductRequestModel.getCategory(),
                createProductRequestModel.getBrand(),
                createProductRequestModel.getModel(),
                createProductRequestModel.getRelease_year(),
                createProductRequestModel.getBody(),
                createProductRequestModel.getColor(),
                createProductRequestModel.getEngine(),
                createProductRequestModel.getDrive(),
                createProductRequestModel.getWheel(),
                createProductRequestModel.getPrice(),
                createProductRequestModel.getPicture());
        admin_productDataAccess.save(product);
        return admin_productOutputBoundary.prepareSuccessAddProductView(ProductDtoModel.productMapper(product));
    }

    @Override
    public ProductsResponseModel filterProducts(FilterProductRequestModel filterProductRequestModel) {
        List<Product> products = admin_productDataAccess.filter(
                filterProductRequestModel.getId(), filterProductRequestModel.getCategory(),
                filterProductRequestModel.getBrand(), filterProductRequestModel.getModel(),
                filterProductRequestModel.getRelease_year(), filterProductRequestModel.getBody());
        return admin_productOutputBoundary
                .prepareProducts(ProductDtoModel.listProductMapper(products), ProductCategories.values());
    }

    @Override
    public ProductDtoModel findConcreteProduct(Long id) {
        Product product = admin_productDataAccess.findById(id);
        return admin_productOutputBoundary.prepareFindedProductView(ProductDtoModel.productMapper(product));
    }

    @Override
    public boolean editProduct(Long id, EditProductRequestModel editProductRequestModel) {
        Product product = admin_productDataAccess.findById(id);
        if(!editProductRequestModel.getBrand().equals("")) product.setBrand(editProductRequestModel.getBrand());
        if(!editProductRequestModel.getModel().equals("")) product.setModel(editProductRequestModel.getModel());
        if(editProductRequestModel.getPrice()!=null) product.setPrice(editProductRequestModel.getPrice());
        if(editProductRequestModel.getRelease_year()!=null) product.setRelease_year(editProductRequestModel.getRelease_year());
        if(editProductRequestModel.getMileage()!=null) product.setMileage(editProductRequestModel.getMileage());
        if(editProductRequestModel.getNumber_of_owners()!=null) product.setNumber_of_owners(editProductRequestModel.getNumber_of_owners());
        if(!editProductRequestModel.getColor().equals("")) product.setColor(editProductRequestModel.getColor());
        if(!editProductRequestModel.getBody().equals("")) product.setBody(editProductRequestModel.getBody());
        if(!editProductRequestModel.getEngine().equals("")) product.setEngine(editProductRequestModel.getEngine());
        if(!editProductRequestModel.getDrive().equals("")) product.setDrive(editProductRequestModel.getDrive());
        if(!editProductRequestModel.getWheel().equals("")) product.setWheel(editProductRequestModel.getWheel());
        if(!editProductRequestModel.getCategory().equals("")) product.setCategory(editProductRequestModel.getCategory());
        if(!editProductRequestModel.getPicture().equals("")) product.setPicture(editProductRequestModel.getPicture());
        admin_productDataAccess.save(product);
        return admin_productOutputBoundary.prepareSuccessEditProductView(ProductDtoModel.productMapper(product));
    }

    @Override
    public ProductDtoModel deleteProduct(Long id) {
        Product product = admin_productDataAccess.deleteById(id);
        return admin_productOutputBoundary.prepareDeletedProductView(ProductDtoModel.productMapper(product));
    }
}

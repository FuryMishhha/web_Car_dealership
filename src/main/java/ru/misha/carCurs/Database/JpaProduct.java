package ru.misha.carCurs.Database;

import ru.misha.carCurs.Repositories.ProductRepository;
import ru.misha.carCurs.Domain.Admin.Products.Admin_ProductDataAccess;
import ru.misha.carCurs.Domain.Order.OrderDataAccess;
import ru.misha.carCurs.Entities.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.Comparator;
import java.util.List;

public class JpaProduct implements Admin_ProductDataAccess, OrderDataAccess {
    private final ProductRepository productRepository;

    @PersistenceContext
    private EntityManager em;

    public JpaProduct(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> filter(String brand, String model, Integer release_year, String body) {
        if (brand.equals("")
                && model.equals("") && body.equals("")
                && release_year==null){
            return getAll();
        }

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery = cb.createQuery(Product.class);
        Root<Product> productRoot = criteriaQuery.from(Product.class);

        Predicate predicateForBrand = cb.equal(productRoot.get("brand"), brand);
        Predicate predicateForModel = cb.equal(productRoot.get("model"), model);
        Predicate predicateForReleaseYear = cb.equal(productRoot.get("release_year"), release_year);
        Predicate predicateForBody = cb.equal(productRoot.get("body"), body);

        Predicate finalePredicate = null;

        if(!brand.equals("")){
            if (finalePredicate != null) finalePredicate = cb.and(finalePredicate,predicateForBrand);
            else finalePredicate = predicateForBrand;
        }
        if(!model.equals("")){
            if (finalePredicate != null) finalePredicate = cb.and(finalePredicate,predicateForModel);
            else finalePredicate = predicateForModel;
        }

        if(release_year!=null){
            if (finalePredicate != null) finalePredicate = cb.and(finalePredicate,predicateForReleaseYear);
            else finalePredicate = predicateForReleaseYear;
        }

        if(!body.equals("")){
            if (finalePredicate != null) finalePredicate = cb.and(finalePredicate,predicateForBody);
            else finalePredicate = predicateForBody;
        }

        criteriaQuery.where(finalePredicate);
        List<Product> products = em.createQuery(criteriaQuery).getResultList();
        products.sort(Comparator.comparingLong(Product::getId));
        return products;
    }

    @Override
    public List<Product> filter(Long id, String category, String brand, String model, Integer release_year, String body) {
        if (id==null && brand.equals("") && category.equals("")
                && model.equals("") && body.equals("")
                && release_year==null){
            return getAll();
        }

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery = cb.createQuery(Product.class);
        Root<Product> productRoot = criteriaQuery.from(Product.class);

        Predicate predicateForId = cb.equal(productRoot.get("id"), id);
        Predicate predicateForBrand = cb.equal(productRoot.get("brand"), brand);
        Predicate predicateForModel = cb.equal(productRoot.get("model"), model);
        Predicate predicateForReleaseYear = cb.equal(productRoot.get("release_year"), release_year);
        Predicate predicateForBody = cb.equal(productRoot.get("body"), body);
        Predicate predicateForCategory = cb.like(productRoot.get("category"),category);

        Predicate finalePredicate = null;

        if(id!=null){
            finalePredicate = cb.and(predicateForId);
        }
        if(!brand.equals("")){
            if (finalePredicate != null) finalePredicate = cb.and(finalePredicate,predicateForBrand);
            else finalePredicate = predicateForBrand;
        }
        if(!model.equals("")){
            if (finalePredicate != null) finalePredicate = cb.and(finalePredicate,predicateForModel);
            else finalePredicate = predicateForModel;
        }

        if(release_year!=null){
            if (finalePredicate != null) finalePredicate = cb.and(finalePredicate,predicateForReleaseYear);
            else finalePredicate = predicateForReleaseYear;
        }

        if(!body.equals("")){
            if (finalePredicate != null) finalePredicate = cb.and(finalePredicate,predicateForBody);
            else finalePredicate = predicateForBody;
        }

        if(!category.equals("")){
            if (finalePredicate != null) finalePredicate = cb.and(finalePredicate,predicateForCategory);
            else finalePredicate = predicateForCategory;
        }

        criteriaQuery.where(finalePredicate);
        List<Product> products = em.createQuery(criteriaQuery).getResultList();
        products.sort(Comparator.comparingLong(Product::getId));
        return products;
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Product product) {
        product.setPicture(parse(product.getPicture()));
        productRepository.save(product);
    }

    @Override
    public Product deleteById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if(product!=null){
            productRepository.deleteById(id);
            return product;
        }
        else return null;
    }

    public String parse(String url){
        if(url.charAt(("https://drive.google.com/").length()) == 'u') return url;
        return "https://drive.google.com/uc?export=view&id="+url.substring(("https://drive.google.com/file/d/").length(),url.length()-"/view?usp=sharing".length());
    }
}

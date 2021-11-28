package ru.misha.carCurs.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.misha.carCurs.Entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}

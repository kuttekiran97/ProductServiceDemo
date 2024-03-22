package com.productservice.productservice.Repositories;

import com.productservice.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    @Override
    Product save(Product product);

    List<Product> findAllByTitle(String Title);

    List<Product> findAllByPrice_ValueGreaterThan(Integer integer);


    List<Product> findAllByPrice_ValueBetween(Integer a,Integer b);


    //@Query(value = "select * from product" , nativeQuery = true)  => MYSQL Query
    @Query("SELECT p FROM Product p")  //This is for JPQL Query
    List<Product> findAllByTitleLike(String s);


}

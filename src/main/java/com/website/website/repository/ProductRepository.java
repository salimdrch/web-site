package com.website.website.repository;

import com.website.website.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// la class est un bean et son but est de communiquer avec une source de donnée(data base)
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findProductByProductCategory(String productCategory);
    Product findProductByProductId(Integer id);

}


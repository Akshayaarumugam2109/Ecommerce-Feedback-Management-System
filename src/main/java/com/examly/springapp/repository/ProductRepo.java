package com.examly.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    Product findByProductName(String productName);

    List<Product> findByCategory_CategoryName(String categoryName);
}

package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.Product;

public interface ProductService {

    Product addProduct(Product product);

    List<Product> getAllProductsList();

    Product getProductById(int id);

    Product updateProduct(int id, Product product);

    List<Product> getProductsByName(String name);

    List<Product> getProductsByCategoryName(String categoryName);
}

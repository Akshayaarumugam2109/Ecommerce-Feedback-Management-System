package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Product;
import com.examly.springapp.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public List<Product> getAllProductsList() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(int id) {
        return productRepo.findById(id).orElse(null);
    }

    @Override
    public Product updateProduct(int id, Product product) {
        Product existing = productRepo.findById(id).orElse(null);

        if (existing != null) {
            existing.setProductName(product.getProductName());
            existing.setPrice(product.getPrice());
            existing.setCategory(product.getCategory());
            return productRepo.save(existing);
        }
        return null;
    }

    @Override
    public List<Product> getProductsByName(String name) {
        Product product = productRepo.findByProductName(name);
        return product != null ? List.of(product) : List.of();
    }

    @Override
    public List<Product> getProductsByCategoryName(String categoryName) {
        return productRepo.findByCategory_CategoryName(categoryName);
    }
}

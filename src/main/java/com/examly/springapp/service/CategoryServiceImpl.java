package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Category;
import com.examly.springapp.repository.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public Category addCategory(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public Category getCategoryById(int id) {
        return categoryRepo.findById(id).orElse(null);
    }

    @Override
    public Category updateCategory(int id, Category category) {
        if (!categoryRepo.existsById(id)) {
            return null;
        }
        category.setCategoryId(id);
        return categoryRepo.save(category);
    }

    @Override
    public void deleteCategory(int id) {
        categoryRepo.deleteById(id);
    }

    @Override
    public Page<Category> getCategoriesWithPagination(int page, int size) {
        return categoryRepo.findAll(PageRequest.of(page, size));
    }
}

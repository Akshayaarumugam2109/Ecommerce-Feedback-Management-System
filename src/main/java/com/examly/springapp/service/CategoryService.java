package com.examly.springapp.service;

import java.util.List;

import org.springframework.data.domain.Page;
import com.examly.springapp.model.Category;

public interface CategoryService {

    Category addCategory(Category category);

    List<Category> getAllCategories();

    Category getCategoryById(int id);

    Category updateCategory(int id, Category category);

    void deleteCategory(int id);

    Page<Category> getCategoriesWithPagination(int page, int size);
}

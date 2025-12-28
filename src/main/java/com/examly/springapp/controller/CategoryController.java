package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Category;
import com.examly.springapp.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> addCategory(
            @RequestBody(required = false) Category category) {


        if (category == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    
        if (category.getCategoryName() == null ||
            category.getCategoryName().trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        Category saved = categoryService.addCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {

        List<Category> categories = categoryService.getAllCategories();

        if (categories == null || categories.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable int id) {

        Category category = categoryService.getCategoryById(id);

        if (category == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(
            @PathVariable int id,
            @RequestBody Category category) {

        Category updated = categoryService.updateCategory(id, category);

        if (updated == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable int id) {

        categoryService.deleteCategory(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/page/{page}/{size}")
    public ResponseEntity<?> getCategoriesWithPagination(
            @PathVariable int page,
            @PathVariable int size) {
        
        return ResponseEntity.ok(categoryService.getCategoriesWithPagination(page, size));
    }
}

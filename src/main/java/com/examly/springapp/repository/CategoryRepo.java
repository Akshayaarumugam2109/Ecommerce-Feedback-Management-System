package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
}

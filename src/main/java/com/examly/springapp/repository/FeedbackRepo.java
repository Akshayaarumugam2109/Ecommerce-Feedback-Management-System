package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.Feedback;

@Repository
public interface FeedbackRepo extends JpaRepository<Feedback, Integer> {
}

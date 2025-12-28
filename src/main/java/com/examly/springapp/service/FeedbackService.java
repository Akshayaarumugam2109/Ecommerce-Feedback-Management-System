package com.examly.springapp.service;

import java.util.List;
import com.examly.springapp.model.Feedback;

public interface FeedbackService {

    Feedback addFeedback(Feedback feedback);

    List<Feedback> getAllFeedbacks();
}

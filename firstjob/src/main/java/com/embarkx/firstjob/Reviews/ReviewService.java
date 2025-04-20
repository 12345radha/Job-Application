package com.embarkx.firstjob.Reviews;
import java.util.*;
public interface ReviewService {

//    this specific company id ask to get all reviews
    List<Review> getAllReviews(Long companyId);
    boolean addReview(Long companyId,Review review);
    Review getReview(Long companyId,Long reviewId);
    boolean updateReview(Long companyId,Long reviewId,Review review);
    boolean deleteReview(Long companyId,Long reviewId);
}

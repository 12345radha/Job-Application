package com.embarkx.firstjob.Reviews.impl;

import com.embarkx.firstjob.Reviews.Review;
import com.embarkx.firstjob.Reviews.ReviewRepository;
import com.embarkx.firstjob.Reviews.ReviewService;
import com.embarkx.firstjob.company.Company;
import com.embarkx.firstjob.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;
//    spring will auto inject the instance of Implememation subclass instance of ReviewRepository
    public ReviewServiceImpl(ReviewRepository reviewRepository,
                                CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService=companyService;
    }


    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews=reviewRepository.findByIdCompanyId(companyId);


        return List.of();
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        Company company=companyService.getCompanyById(companyId);
        if(company!=null)
        {
            review.setCompany(company);
            reviewRepository.save(review);
           return true;
        }
        return false;
    }

    @Override
    public Review getReview(Long companyId, Long reviewId) {
        List<Review>reviews=reviewRepository.findByIdCompanyId(companyId);
        return reviews.stream().
                filter(review -> review.getId().equals(reviewId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review updatedreview) {
        if(companyService.getCompanyById(companyId)!=null)
        {
            updatedreview.setCompany(companyService.getCompanyById(companyId));
            updatedreview.setId(reviewId);
            reviewRepository.save(updatedreview);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        if(companyService.getCompanyById(companyId)!=null
        && reviewRepository.existsById(reviewId))
        {
            Review review=reviewRepository.findById(reviewId).orElse(null);
            Company company=review.getCompany();
            company.getReviews().remove(review);
            companyService.updateCompany(company,companyId);
            reviewRepository.deleteById(reviewId);
            return true;
        }
        return false;
    }
}

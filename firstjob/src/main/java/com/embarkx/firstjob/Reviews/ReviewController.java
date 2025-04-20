package com.embarkx.firstjob.Reviews;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
    private ReviewService reviewService;

//   reviewService this will get injected using spring
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId)
    {
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

//    using the company id we are going to add the review to that specific company.
@PostMapping("/reviews")
public ResponseEntity<String> addReview(@PathVariable Long companyId,
                                        @RequestBody Review review)
{
        boolean isReviewd=reviewService.addReview(companyId,review);
        if(isReviewd) {
            return new ResponseEntity<>("Review added Successfully",
                    HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Review not saved",
                    HttpStatus.NOT_FOUND);
        }

}

@GetMapping("/reviews/{reviewId}")
public ResponseEntity<Review> getReview(@PathVariable Long companyId,
                                        @PathVariable Long reviewId)
{
  return new ResponseEntity<>(reviewService.getReview(companyId,reviewId),HttpStatus.OK);
}

@PutMapping("/reviews/{reviewId}")
 public  ResponseEntity<String> updateReview(@PathVariable Long companyId,
                                             @PathVariable Long reviewId,
                                             @RequestBody Review review
                                             )
{
    boolean isReviewdUpdated= reviewService.updateReview(companyId,reviewId,review);
    if(isReviewdUpdated) {
        return new ResponseEntity<>("Review Updated Successfully",
                HttpStatus.OK);
    }
    else
    {
        return new ResponseEntity<>("Review not  Updated Successfully",
                HttpStatus.NOT_FOUND);
    }

}

@DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId,
                                               @PathVariable Long reviewId){
    boolean isReviewdDeleted= reviewService.deleteReview(companyId,reviewId);
    if(isReviewdDeleted) {
        return new ResponseEntity<>("Review deleted Successfully",
                HttpStatus.OK);
    }
    else
    {
        return new ResponseEntity<>("Review not  deleted Successfully",
                HttpStatus.NOT_FOUND);
    }
}
}

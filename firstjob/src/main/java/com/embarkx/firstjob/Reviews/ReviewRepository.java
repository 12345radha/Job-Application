package com.embarkx.firstjob.Reviews;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {

//    we don't need to define implementation for this , we are asking jpa to provide implementation and it will provide the implementation of this method at runtime.
    List<Review> findByIdCompanyId(Long companyId);
}

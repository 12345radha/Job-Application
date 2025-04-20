package com.embarkx.firstjob.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {
// @Autowired
private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    //    defining here a endpoint /jobs, when we hit this we get all jobs.
    @GetMapping("/jobs")
    public ResponseEntity<List<Job> >findAll(){
        return ResponseEntity.ok(jobService.findAll());
   }

   @PostMapping("/jobs")
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job Addded Successfully",HttpStatus.OK);
   }

//   @GetMapping("/jobs/{id}")
//    public Job getJobById(@PathVariable Long id)
//   {
//       Job job=jobService.getJobById(id);
//       return job;
//   }

//    to handle our response and customizing it with providing httpstatus
    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id)
    {
        Job job=jobService.getJobById(id);
        if(job!=null)
        {
            return new ResponseEntity<>(job, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping ("/jobs/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id,
                                            @RequestBody  Job updatedJob)
    {
        boolean updated=jobService.updateJob(id,updatedJob);
        if(updated)
        return new ResponseEntity<>("Job Updated Succesfully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id)
    {
        boolean deleted=jobService.deleteJobById(id);
        if(deleted)
            return  new ResponseEntity<>("Job Deleted Successfully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}

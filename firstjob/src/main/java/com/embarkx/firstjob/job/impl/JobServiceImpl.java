package com.embarkx.firstjob.job.impl;

import com.embarkx.firstjob.job.Job;
import com.embarkx.firstjob.job.JobRepository;
import com.embarkx.firstjob.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
    //private List<Job> jobs=new ArrayList<>();
   // private Long nextId=1L;
    JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository)
    {
        this.jobRepository=jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
      //  job.setId(nextId++);
    jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
//        for(Job job:jobs)
//        {
//            if(job.getId().equals(id)){
//                return job;
//            }
//        }
       return jobRepository.findById(id).orElse(null);

    }

    @Override
    public boolean updateJob(Long id,Job updatedJob) {
//        for(Job job:jobs)
//        {
//            if(job.getId().equals(id)){
//               // job.setId(updatedJob.getId());
//                job.setTitle(updatedJob.getTitle());
//                job.setDescription(updatedJob.getDescription());
//                job.setLocation(updatedJob.getLocation());
//                job.setMaxSalary(updatedJob.getMaxSalary());
//                job.setMinSalary(updatedJob.getMinSalary());
//                return true;
//
//            }
//        }
//        return false;
        Optional<Job> jobOptional=jobRepository.findById(id);
            if(jobOptional.isPresent()){
                Job job=jobOptional.get();
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setLocation(updatedJob.getLocation());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setMinSalary(updatedJob.getMinSalary());
                jobRepository.save(job);
                return true;

            }
        return false;
    }

    @Override
    public boolean deleteJobById(Long id) {
//        Iterator<Job>iterator= jobs.iterator();
//        while (iterator.hasNext())
//        {
//            Job job=iterator.next();
//            if(job.getId().equals(id)) {
//                iterator.remove();
//                return true;
//            }
//        }
//        return false;
        try {
            jobRepository.deleteById(id);
            return true;
        }catch(Exception e)
        {
            return false;
        }

    }
}

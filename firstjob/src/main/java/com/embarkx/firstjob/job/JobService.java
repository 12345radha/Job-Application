package com.embarkx.firstjob.job;

import java.util.List;

public interface JobService {

List<Job> findAll();
void createJob(Job job);

    Job getJobById(Long id);

    boolean updateJob(Long id,Job job);

    boolean deleteJobById(Long id);
}

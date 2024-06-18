package com.exam.demo.service;

import java.util.List;

import com.exam.demo.pojos.*;

public interface JobService {

	List<JobPosting> getAllJobs();

	JobPosting addNewJob(JobPosting transientJob);

	JobPosting getJobDetails(Long JobId);

	JobPosting updateJob(JobPosting detachedJob);

	String deleteJob(Long JobId);
}

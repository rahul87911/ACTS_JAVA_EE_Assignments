package com.exam.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.demo.service.*;
import com.exam.demo.pojos.*;

@RestController
@RequestMapping("/jobs")
@CrossOrigin("*")
public class JobsController {

	@Autowired
	private JobService jobService;
	
	
	@GetMapping
	public List<JobPosting> getJobs() {
		return jobService.getAllJobs();
	}
	
	@PostMapping
	public JobPosting  addNewJob(@RequestBody JobPosting transientJob) {
		return jobService.addNewJob(transientJob);
	}
	
	@GetMapping("/{jobId}")
	public JobPosting getJobDetails(@PathVariable Long JobId) {
		System.out.println("in get emp " + JobId);
		return jobService.getJobDetails(JobId);
	}
	
	@PutMapping
	public JobPosting updateJobDetails(@RequestBody JobPosting detachedJob) {
		return jobService.updateJob(detachedJob);
	}
	
	@DeleteMapping("/{JobId}")
	public String deleteJobDetails(@PathVariable Long JobId)
	{
		return jobService.deleteJob(JobId);
	}
}

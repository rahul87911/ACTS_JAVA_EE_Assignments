package com.exam.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.exam.demo.exceptions.ResourceNotFoundException;
import com.exam.demo.pojos.JobPosting;
import com.exam.demo.repo.*;

@Service
@Transactional
public class JobServiceImpl implements JobService {
	
	@Autowired
	private JobsRepo jobsRepo;

	@Override
	public List<JobPosting> getAllJobs() {
			return jobsRepo.findAll();
	}

	@Override
	public JobPosting addNewJob(JobPosting transientJob) {
		return jobsRepo.save(transientJob);
	}

	@Override
	public JobPosting getJobDetails(Long JobId) {
		return jobsRepo.findById(JobId).orElseThrow(()
				-> new ResourceNotFoundException("Invalid Job ID !!!!"));
	}

	@Override
	public JobPosting updateJob(JobPosting detachedJob) {
		if(jobsRepo.existsById(detachedJob.getId())) {//select
			//exists --update
			return jobsRepo.save(detachedJob);
		}
		throw new ResourceNotFoundException("Invalid emp id !!!!");
	}

	@Override
	public String deleteJob(Long JobId) {
		if(jobsRepo.existsById(JobId))
		{
			jobsRepo.deleteById(JobId);
			return "deleted emp details...";
		}
		return "deletion of emp details failed !!!!!";
	}

}

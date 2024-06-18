package com.exam.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.demo.pojos.*;

public interface JobsRepo extends JpaRepository<JobPosting, Long> {

}

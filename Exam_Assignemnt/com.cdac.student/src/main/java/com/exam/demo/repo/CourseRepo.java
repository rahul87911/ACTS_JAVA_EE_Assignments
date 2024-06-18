package com.exam.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.demo.pojo.Course;

public interface CourseRepo extends JpaRepository<Course, Long> {

	 List<Course> findByNameContaining(String name);
}

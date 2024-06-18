package com.exam.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.demo.pojo.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

	List<Student> findByCourse_Name(String courseName);
}

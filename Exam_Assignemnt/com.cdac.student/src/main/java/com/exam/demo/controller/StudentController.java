package com.exam.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exam.demo.pojo.Student;
import com.exam.demo.service.EducationService;

@RestController
@RequestMapping("/edu/students")
@CrossOrigin("*")
public class StudentController {

	 @Autowired
	    private EducationService educationService;
	 
	 @GetMapping
	    public List<Student> getStudentsByCourseName(@RequestParam String courseName) {
	        return educationService.findStudentsByCourseName(courseName);
	        
	    }
}

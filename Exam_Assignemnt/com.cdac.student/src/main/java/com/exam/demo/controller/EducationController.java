package com.exam.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exam.demo.exceptions.GlobalException;
import com.exam.demo.pojo.Course;
import com.exam.demo.service.EducationService;

@RestController
@RequestMapping("/edu/courses")
@CrossOrigin("*")
public class EducationController {

	
	   @Autowired
	    private EducationService educationService;
	   
	   @PostMapping
	    public Course addCourse(@Validated @RequestBody Course course) {
		   if(course.getEndDate().isBefore(course.getStartDate()))
		   {
			   throw new GlobalException("End Date cannot be before Start Date");
		   }
	        return educationService.addCourse(course);
	    }

	    @PutMapping("/{id}")
	    public Course updateCourse(@PathVariable Long id,  @RequestBody Course courseDetails) {
	       return educationService.updateCourse(id, courseDetails);
	    }

	    @GetMapping
	    public List<Course> getCoursesByName(@RequestParam String name) {
	        return educationService.findCoursesByName(name);
	        
	    }
}

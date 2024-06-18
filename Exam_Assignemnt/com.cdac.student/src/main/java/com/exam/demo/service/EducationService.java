package com.exam.demo.service;

import java.util.List;

import com.exam.demo.pojo.Course;
import com.exam.demo.pojo.Student;

public interface EducationService {

	    public Course addCourse(Course course) ;

	    public Course updateCourse(Long id, Course courseDetails) ;

	    public List<Course> findCoursesByName(String name); 

	    public List<Student> findStudentsByCourseName(String courseName);
}

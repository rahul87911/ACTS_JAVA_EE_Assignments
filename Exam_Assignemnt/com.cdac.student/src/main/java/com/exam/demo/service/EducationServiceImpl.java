package com.exam.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.demo.pojo.Course;
import com.exam.demo.pojo.Student;
import com.exam.demo.repo.CourseRepo;
import com.exam.demo.repo.StudentRepo;


@Service
public class EducationServiceImpl implements EducationService {

	   @Autowired
	    private CourseRepo courseRepository;

	    @Autowired
	    private StudentRepo studentRepository;
	
	@Override
	public Course addCourse(Course course) {
		 return courseRepository.save(course);
	}

	@Override
	public Course updateCourse(Long id, Course courseDetails) {
	
		Optional<Course> courseOpt = courseRepository.findById(id);
		if (!courseOpt.isPresent()) {
            return null;
        }
        Course course = courseOpt.get();
        course.setStartDate(courseDetails.getStartDate());
        course.setEndDate(courseDetails.getEndDate());
        course.setFee(courseDetails.getFee());
        return courseRepository.save(course);
	}

	@Override
	public List<Course> findCoursesByName(String name) {
		  return courseRepository.findByNameContaining(name);
	}

	@Override
	public List<Student> findStudentsByCourseName(String courseName) {
		   return studentRepository.findByCourse_Name(courseName);
	}

}

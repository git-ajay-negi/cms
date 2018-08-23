package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Course;
import com.example.demo.entity.User;

public interface CourseService {
 
	public List<Course> getAllCourses() ;
	
	public boolean saveUser(User user);
}

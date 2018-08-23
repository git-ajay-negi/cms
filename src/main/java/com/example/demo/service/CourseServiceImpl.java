package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Course;
import com.example.demo.entity.User;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.UserRepository;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private CourseRepository courseRepository;
	
	public boolean saveUser(User user) {
		userRepo.save(user);
		return true;
	}



	@Override
	public List<Course> getAllCourses() {
		
		List<Course> courses=new ArrayList<>();
		 courseRepository.findAll().forEach(course -> courses.add(course));;
		 return courses;
	}

	
	
}

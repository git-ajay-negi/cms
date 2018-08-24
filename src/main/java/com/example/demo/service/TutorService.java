package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Course;
import com.example.demo.entity.Topic;
import com.example.demo.entity.User;

public interface TutorService {
 
	public List<Course> getAllTutors() ;
	
	public Course updateTutor(int tutorId, User user) ;
	
	

	
	public boolean saveUser(User user);
}

package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Course;
import com.example.demo.entity.Topic;
import com.example.demo.entity.User;

public interface TutorService {
 
	public List<User> getAllTutors() ;
	
	public User updateTutor(int tutorId, User user) ;
	
	public User createTutor(User tutor);
	
	public String deleteTutor(int tutorId);

	
}

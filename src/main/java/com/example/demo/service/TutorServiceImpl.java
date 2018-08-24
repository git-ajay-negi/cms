package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Topic;
import com.example.demo.entity.User;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.UserRepository;

@Service
public class TutorServiceImpl implements TutorService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private CourseRepository courseRepository;
	
	public boolean saveUser(User user) {
		userRepo.save(user);
		return true;
	}



	


	@Override
	public List<Course> getAllTutors() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Course updateTutor(int tutorId, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}

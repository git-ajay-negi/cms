package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CalendarDto;
import com.example.demo.entity.Course;
import com.example.demo.entity.Topic;
import com.example.demo.entity.TutorCourseMap;
import com.example.demo.entity.User;
import com.example.demo.repository.CalendarRepository;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private CalendarRepository calendarRepo;
	
	
	public boolean saveUser(User user) {
		userRepo.save(user);
		return true;
	}


	@Override
	public User getByUserNameAndPassword(String userName, String password) {
		List<User>users=userRepo.findByUserNameAndPassword(userName, password);
		if(users.isEmpty())
				return null;
		else
			return users.get(0);
	}



		
}

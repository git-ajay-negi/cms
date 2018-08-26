package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.CalendarDto;
import com.example.demo.entity.Course;
import com.example.demo.entity.Topic;
import com.example.demo.entity.TutorCourseMap;
import com.example.demo.entity.User;

public interface UserService {
 
	public User getByUserNameAndPassword(String userName,String password);
	
	
}

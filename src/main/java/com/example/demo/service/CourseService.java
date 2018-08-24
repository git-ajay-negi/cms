package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Course;
import com.example.demo.entity.Topic;
import com.example.demo.entity.User;

public interface CourseService {
 
	public List<Course> getAllCourses() ;
	
	public Course updateCourse(int courseId,Course course) ;
	
	public Course createCourse(Course course) ;
	
	public String deleteCourse(int courseId);
	
	public Topic createTopic(int courseId,Topic topic);
	
	public Topic updateTopic(int topicId,Topic topic);
	
	public String deleteTopic(int topicId);


	
	public boolean saveUser(User user);
}

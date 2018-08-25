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
public class CalendarServiceImpl implements CalendarService {
	
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
	public List<CalendarDto> getCalendar(String year) {
		
		List<CalendarDto> calendars=new ArrayList<>();
		calendarRepo.findAll().forEach(calendar ->{
			CalendarDto cal=new CalendarDto();
			cal.setCourseName(calendar.getCourse().getCourseName());
			cal.setCourseId(calendar.getCourse().getId());
			cal.setTutorId(calendar.getUser().getId());
			cal.setTutorName(calendar.getUser().getUserName());
			cal.setPeriod(calendar.getPeriod());

			
			calendars.add(cal);
			
		});;
		 return calendars;
	}

	@Override
	public TutorCourseMap assignCourseToTuor(int courseId,int tutorId,String period) {
		TutorCourseMap tutCourse=new TutorCourseMap();
		Course course=courseRepository.findById(courseId).get();
		User tutor=userRepo.findById(tutorId).get();
		tutCourse.setCourse(course);
		tutCourse.setUser(tutor);
		tutCourse.setPeriod(period);
		return calendarRepo.save(tutCourse);
		
		
		
	}



	@Override
	public Course updateCourse(int courseId, Course course) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Course createCourse(Course course) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public String deleteCourse(int courseId) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Topic createTopic(int courseId, Topic topic) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Topic updateTopic(int topicId, Topic topic) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public String deleteTopic(int topicId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}

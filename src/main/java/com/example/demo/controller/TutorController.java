package com.example.demo.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.CalendarDto;
import com.example.demo.entity.Course;
import com.example.demo.entity.User;
import com.example.demo.service.CalendarService;
import com.example.demo.service.CourseService;
import com.example.demo.service.TutorService;

@RestController
public class TutorController {
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private TutorService tutorService;
	
	@Autowired
	private CalendarService calendarService;
	
	@RequestMapping(value="/tutors",method=RequestMethod.GET)
	public ResponseEntity<ApiResponse>  getCourses(){
		ApiResponse response=new ApiResponse();
		//try {
		response.setData(tutorService.getAllTutors());
		response.setStatus("ok");
		response.setStatusCode(2000);
		/*}catch(Exception e) {
			response.setStatus("failed");
			response.setStatusCode(1001);
		}*/
		
		return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);

	}
	
	
	@RequestMapping(value="/tutors",method=RequestMethod.POST)
	public ResponseEntity<ApiResponse>  addTutor( @RequestBody User tutor){
		
		ApiResponse response=new ApiResponse();
		try {
		response.setData(tutorService.createTutor(tutor));
		response.setStatus("Created");
		response.setStatusCode(2000);
		}catch(Exception e) {
			response.setStatus("failed");
			response.setStatusCode(1001);
		}
		
		return new ResponseEntity<ApiResponse>(response, HttpStatus.CREATED);

	}

	
	@RequestMapping(value="/tutors/{tutorId}",method=RequestMethod.PUT)
	public ResponseEntity<ApiResponse>  updateTutor(@PathVariable("tutorId")int tutorId, @RequestBody User tutor){
		
		ApiResponse response=new ApiResponse();
		try {
		response.setData(tutorService.updateTutor(tutorId, tutor));
		response.setStatus("ok");
		response.setStatusCode(2000);
		}catch(Exception e) {
			response.setStatus("failed");
			response.setStatusCode(1001);
		}
		
		return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);

	}
	
	
	@RequestMapping(value="/tutors/{tutorId}/courses/{courseId}",method=RequestMethod.POST)
	public ResponseEntity<ApiResponse>  assignCourseToTutor(@PathVariable("tutorId")Integer tutorId,
			@PathVariable("courseId")Integer courseId, @RequestBody CalendarDto calendar){
		
		ApiResponse response=new ApiResponse();
		try {
			System.out.println("value of course and tutor"+courseId+"  "+tutorId+" "+calendar.getPeriod());
		response.setData(calendarService.assignCourseToTuor(courseId,tutorId, calendar.getPeriod()));
		response.setStatus("Created");
		response.setStatusCode(2000);
		}catch(Exception e) {
			e.printStackTrace();
			response.setStatus("failed");
			response.setStatusCode(1001);
		}
		
		return new ResponseEntity<ApiResponse>(response, HttpStatus.CREATED);

	}
	
	

}

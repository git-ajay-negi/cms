package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.Course;
import com.example.demo.service.CourseService;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping(value="/courses",method=RequestMethod.GET)
	public ResponseEntity<ApiResponse>  getCourses(){
		ApiResponse response=new ApiResponse();
		try {
		response.setData(courseService.getAllCourses());
		response.setStatus("ok");
		response.setStatusCode(2000);
		}catch(Exception e) {
			response.setStatus("failed");
			response.setStatusCode(1001);
		}
		
		return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);

	}
	
	
	@RequestMapping(value="/courses",method=RequestMethod.POST)
	public ResponseEntity<ApiResponse>  addCourses( @RequestBody Course course){
		
		ApiResponse response=new ApiResponse();
		try {
		response.setData(course);
		response.setStatus("Created");
		response.setStatusCode(2000);
		}catch(Exception e) {
			response.setStatus("failed");
			response.setStatusCode(1001);
		}
		
		return new ResponseEntity<ApiResponse>(response, HttpStatus.CREATED);

	}

	
	@RequestMapping(value="/courses/{courseId}",method=RequestMethod.PUT)
	public ResponseEntity<ApiResponse>  addCourses(@PathVariable("courseId")int courseId, @RequestBody Course course){
		
		ApiResponse response=new ApiResponse();
		try {
		response.setData(course);
		response.setStatus("ok");
		response.setStatusCode(2000);
		}catch(Exception e) {
			response.setStatus("failed");
			response.setStatusCode(1001);
		}
		
		return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);

	}
	
	
	
	
	

}

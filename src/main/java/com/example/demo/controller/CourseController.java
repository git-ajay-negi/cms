package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
		response.setData(courseService.getAllCourses());
		response.setStatus("ok");
		response.setStatusCode(2000);
		return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
		
		
	}
	

}

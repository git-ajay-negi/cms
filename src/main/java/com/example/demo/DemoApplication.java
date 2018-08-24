package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Course;
import com.example.demo.entity.Role;
import com.example.demo.entity.Topic;
import com.example.demo.entity.User;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.UserRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private UserRepository usrRepo;
	
	@Autowired
	private CourseRepository  courseRepo;
	
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);;
	}

	@Override
	public void run(String... args) throws Exception {
		User user1=new User("Mr Amit","Amit", "amit",new Role("TUTOR"));
		User user2=new User("Mr Sumit","Sumit", "sumit",new Role("STUDENT"));
		usrRepo.save(user1);
		usrRepo.save(user2);
		System.out.println("users successfully created------------------------------>>>>>>>");
		User fUser;
		if(usrRepo.findById(1).isPresent()) {
			fUser=usrRepo.findById(1).get();
			System.out.println("name "+fUser.getName()+"    "+fUser.getPassword());
		}
		List<Topic>topics=new ArrayList<>();
		Course course=new Course("java", "java-101", topics);

		topics.add(new Topic("core", "101", "core java is core",course));
		topics.add(new Topic("Jee", "102", "j2ee is advance java",course));

		
		 
		
		courseRepo.save(course);
		
	}
	
}

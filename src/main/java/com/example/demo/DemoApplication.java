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
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private UserRepository usrRepo;
	
	@Autowired
	private CourseRepository  courseRepo;
	
	@Autowired
	private RoleRepository  roleRepo;

	
	
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);;
	}

	@Override
	public void run(String... args) throws Exception {
		Role r1=new Role("TUTOR");
		Role r2=new Role("STUDENT");
		Role r3=new Role("ADMIN");
		r1=roleRepo.save(r1);
		r2=roleRepo.save(r2);
		r3=roleRepo.save(r3);

		
		User user1=new User("Mr Amit","Amit", "amit",r1);
		User user2=new User("Mr Sumit","Sumit", "sumit",r2);
		User user3=new User("Mr Rahul","Rahul", "rahul",r3);

		usrRepo.save(user1);
		usrRepo.save(user2);
		usrRepo.save(user3);

		
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

		
		 //lllll
		
		courseRepo.save(course);
		
	}
	
}

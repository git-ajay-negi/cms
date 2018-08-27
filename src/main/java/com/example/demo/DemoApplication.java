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

		
		User user1=new User("Mr Amit","tutor", "tutor",r1);
		User user4=new User("Mr Mohit","tutor1", "tutor1",r1);

		User user2=new User("Mr Sumit","student", "student",r2);
		User user3=new User("Mr Rahul","admin", "admin",r3);

		usrRepo.save(user1);
		usrRepo.save(user2);
		usrRepo.save(user3);
		usrRepo.save(user4);

		
		System.out.println("users successfully created------------------------------>>>>>>>");
		
		List<Topic>topics=new ArrayList<>();
		Course course=new Course("java", "java-101", topics);
		topics.add(new Topic("data type", "101", "about java data types",course));
		topics.add(new Topic("inheritance", "102", "about inheritance",course));
		topics.add(new Topic("static keyword in java", "103", "use of static keywords in java",course));

		
		 //lllll
		List<Topic>dotNetTopics=new ArrayList<>();
	
		Course courseDotNet=new Course("Dot net c sharp", "c-sharp-101", dotNetTopics);
		topics.add(new Topic("method overloading", "1001", "about method overloading",courseDotNet));
		topics.add(new Topic("delegation", "1002", "delegation in c sharp",courseDotNet));
		topics.add(new Topic("multiple inheritance", "1003", "use of multiple inheritance",courseDotNet));
		courseRepo.save(courseDotNet);

		courseRepo.save(course);
		
	}
	
}

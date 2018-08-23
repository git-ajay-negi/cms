package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private UserRepository usrRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);;
	}

	@Override
	public void run(String... args) throws Exception {
		User user1=new User("Amit", "amit");
		User user2=new User("Sumit", "sumit");
		usrRepo.save(user1);
		usrRepo.save(user2);
		System.out.println("users successfully created------------------------------>>>>>>>");
		User fUser;
		if(usrRepo.findById(1).isPresent()) {
			fUser=usrRepo.findById(1).get();
			System.out.println("name "+fUser.getName()+"    "+fUser.getPwd());
		}
	}
	
}

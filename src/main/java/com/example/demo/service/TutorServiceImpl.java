package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Role;
import com.example.demo.entity.Topic;
import com.example.demo.entity.User;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;

@Service
public class TutorServiceImpl implements TutorService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private CourseRepository courseRepository;
	
	
	@Autowired
	private RoleRepository roleRepository;
	

	


	


	@Override
	public List<User> getAllTutors() {
		List<Role> role=roleRepository.findByRole("TUTOR");
		List<User> tutors=userRepo.findByRole(role.isEmpty()?new Role():role.get(0));
		return tutors;
	}



	@Override
	public User updateTutor(int tutorId, User tutor) {
		User user=userRepo.findById(tutorId).get();
		//tutor.setId(tutorId);
		user.setName(tutor.getName());
		user.setUserName(tutor.getUserName());
		user.setPassword(tutor.getPassword());
		return userRepo.save(user);
	}






	@Override
	public User createTutor(User tutor) {
		List<Role> roles=roleRepository.findByRole("TUTOR");
		Role role=roles.isEmpty()?new Role():roles.get(0);
		tutor.setRole(role);
		return userRepo.save(tutor);
	}






	@Override
	public String deleteTutor(int tutorId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}

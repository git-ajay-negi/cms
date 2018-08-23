package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private UserRepository userRepo;
	
	public boolean validateUser(String name,String pwd) {
		
		if("abc".equalsIgnoreCase(name)&&"pwd".equalsIgnoreCase(pwd))
			return true;
		return false;
	}
	
	
	public boolean saveUser(User user) {
		userRepo.save(user);
		return true;
	}

	
	
}

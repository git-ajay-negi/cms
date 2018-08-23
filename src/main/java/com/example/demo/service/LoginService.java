package com.example.demo.service;

import com.example.demo.entity.User;

public interface LoginService {
 
	public boolean validateUser(String name,String pwd) ;;
	
	public boolean saveUser(User user);
}

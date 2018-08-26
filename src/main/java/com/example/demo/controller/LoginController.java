package com.example.demo.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.LoginService;
import com.example.demo.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String getIndexPage() {
		System.out.println("---------------------------index page-------------");
		return "index";
	}

	@RequestMapping("/login")
	public String getLogin() {
		return "login";
	}
	
	@RequestMapping(value="/loginAuth",method=RequestMethod.POST)
	public String getLoginAuth(@RequestParam("name") String name,@RequestParam("pwd")String password) {
		System.out.println("name :"+name+"  pwd  :"+password+" is valid user "+loginService.validateUser(name, password));
		if(Objects.nonNull(userService.getByUserNameAndPassword(name, password))) {
			if(userService.getByUserNameAndPassword(name, password).getRole().getRole().equalsIgnoreCase("STUDENT"))
		return "welcome";
		else
			return "admin_dashboard";
		}
		else 
			return "index";
		
	}
		
	
	@RequestMapping("/welcome")
	public String getWelcomePage() {
		return "welcome";
	}
}

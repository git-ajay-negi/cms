package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
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
		return "welcome";
	}
		
	
	@RequestMapping("/welcome")
	public String getWelcomePage() {
		return "welcome";
	}
}

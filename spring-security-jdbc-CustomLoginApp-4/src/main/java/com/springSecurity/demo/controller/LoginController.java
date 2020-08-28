package com.springSecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class LoginController {

	
	
	@GetMapping("/showLogin")
	public String loginPage() {
		
		
		
	return"login-form";	
	}
}

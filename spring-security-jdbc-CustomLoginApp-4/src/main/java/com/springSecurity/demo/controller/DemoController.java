package com.springSecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	
		@GetMapping("/")
		public String page() {
			
			return "home";
		}
		
		
		@GetMapping("/leaders")
		public String showLeader() {
			
			return "leader";
		}
		
		@GetMapping("/systems")
		public String showSystem() {
			
			return "admin-page";
		}
		
		///access-denied""
		@GetMapping("/access-denied")
		public String showAccessDenied() {
			
			return "accessDenied";
		}
}

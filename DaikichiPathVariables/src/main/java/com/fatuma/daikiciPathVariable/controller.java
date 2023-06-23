package com.fatuma.daikiciPathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class controller {
	 @RequestMapping("/home")
	 public String Home() { 
		 return "Welcome!" ;
					
		

		}}

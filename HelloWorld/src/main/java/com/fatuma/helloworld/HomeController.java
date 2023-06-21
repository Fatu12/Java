package com.fatuma.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
//@RequestMapping("/greeding")
public class HomeController {
	
	@RequestMapping("/")
	 
	public String index() {
		
		return "Hello World";	
		
	}
	@RequestMapping("/world")
	public String world() {
		return "Class annotations are cool too";
	}
	@RequestMapping("/hollo")
	public String hello() {
		return "Hello there";
	}
	@RequestMapping("/goodbye")
	public String goodbye() {
		return "goodbye";
	}


}

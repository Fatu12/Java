package com.fatuma.hellowordRoutes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/")
public class controllers {
@RequestMapping("")
	public String  HelloHumon() {
	return "Hello Homan";
	}
	
	@RequestMapping("/name")
	public String name(@RequestParam(value="firstName") String fname ,Integer  num) {
	
		String outpute = "";
		for(int i = 0; i< num; i++ ) {
			
			if(fname != null) {
			outpute += "Hello" + fname;
			System.out.printf("Hello" + fname);
			
			}
		}
		
		return outpute;
		}
	@RequestMapping("/fullName")
	public String name(@RequestParam(value="firstName", required= false) String fname, @RequestParam(value="lastName", required = false)String lname){
		
		if(fname == null || lname == null ) {
			return  "Hello there what are you trying to do?";
		}
		
		return "Hello" + fname + lname ;
	}
}
		
	


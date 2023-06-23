package com.fatuma.daikiciPathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/daikichi")
public class controller {
	
		@RequestMapping("")
		public String Home() { 
			return "Welcome!" ;
			
		}
		@RequestMapping("/today")
		public String today() {
			return "Today you will find luck in all your endeavors!";
		}
		@RequestMapping(value ="/tomorrow", method = RequestMethod.GET)
		public String tomorrow() {
			return "Tomorow , an opportunity wiil arise, so be sure to be open to new ideas!";
		}
	}
		

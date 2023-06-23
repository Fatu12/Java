package com.fatuma.daikichipathvariable.controllers.copy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RequestMapping("/daikichi")
public class HelloHuman {

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

}

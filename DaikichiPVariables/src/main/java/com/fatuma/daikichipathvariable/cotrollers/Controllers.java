package com.fatuma.daikichipathvariable.cotrollers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// @RestController is checking if any thing coming from the client
@RestController
@RequestMapping("/daikichi")
public class Controllers {
	
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
		
		// {destanation} dynamic variable that allow user to enter any string  and "travel" is the API address 
		
		@RequestMapping("/travel/{destanation}")
		public String Travel(
				@PathVariable("destanation") String destanation) {
			System.out.println( "Congratutions! You will soon travel" + destanation);
			return   "Congratutions! You will soon travel" + destanation;
		}
//		{number} this is dynamic variable that allow user to enter any number and check if the number is even or add then display 
		// the message 
		@RequestMapping("/latto/{number}")
		public String Offers(
			@PathVariable("number") Integer number) {
			if(number % 2 == 0) {
		
			System.out.println(number);
			return   "You will take a grand journey in the near future, but be weary  of tempting offers" ;
		}
			return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
		

}
		
}

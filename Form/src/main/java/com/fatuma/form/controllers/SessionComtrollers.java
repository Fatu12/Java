package com.fatuma.form.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("counting")
public class SessionComtrollers {
	
	@GetMapping("")
	public String index(HttpSession session, Model model ) {
		model.addAttribute("userId", 57 );
		
	    Integer sessionValue = 0;
	    if(session.getAttribute("count")==null){
	    	session.setAttribute("count",1);
	    }
	    else {
		session.setAttribute("count", (Integer) session.getAttribute("count") +1) ;
	
	} 
		return "counter.jsp"; 
		}
	 
		
		@PostMapping("/clear")
		public String clearSession(HttpSession session) {
//			this clear everything 
			session.invalidate();
//			clear just one attributes
			session.removeAttribute("count");
			return "redirect:/counting";
		}
//		userID is not have to match  with the one we have in {userId}

		@PostMapping("/increment/{userId}")
		public String Increment(
				@RequestParam(value="name")String name, @RequestParam(value="amount", required = false) 
				Integer amountIncrement,HttpSession session, RedirectAttributes flash
				, @PathVariable("userId")Integer incomingId) {
			System.out.println(name);
			System.out.print(amountIncrement);
//			session.invalidate();
//			session.removeAttribute("count");
			
			
			if(amountIncrement == null) {
//				create an error message and add it ti redirect attributes
				flash.addFlashAttribute("amountError", "pelase provide an amout to increment by!!!!");
//				the only time in post reqeust your going to return is when you use flash
				return "redirect:/counting";
			}
			session.setAttribute("count",(Integer) session.getAttribute("count")+ amountIncrement-1);
			
//			this two you can use it when you're redirecting from a variable you created in that method
			
//			return "redirect:/counting/pretendredirect/" + incomingId;
//			another way to do it 
			
//			return  String.format("redirect:/counting/pretendredirect/$s" + incomingId);
			
			
			
// this one you can use when redirecting with a path the same path variable accepted in your parameters
	return "redirect:/counting/pretendredirect/{userId}" ;


		
		}
		@GetMapping("/pretendredirect/{newPathVar}")
		public  String redirctMethod(@PathVariable("newPathVar")Integer localVar ) {
			System.out.println("In redirect method");
			System.out.println(localVar);
			return "redirect:/counting";
			
		
//		public String index() {
//			System.out.println("Hello");
//			return "index.jsp";
//		}
//		@RequestMapping("/login")
//		public String login( 
////				now we have access to the email and password that user enterted but we not doing anything to it yet
//			// session is that hold the  user information for temperary time while they are loggedin 
//			@RequestParam(value="email") String email ,
//			@RequestParam(value="password") String password
//			) {
//						
//			
	
		}
	

	}



package com.fatuma.counter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/server")
public class CounterContollers {
	
	@RequestMapping("")
	public String index() {
		return "index.jsp";
	}
	
	
	@RequestMapping("/counter")
	public String IncreamentCounter( HttpSession session ) {
//		Incrementing and count how many time the user visit this page 
		// if the session is null set to be zero 
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", -1);	
		}
//		otherwise set the session and increment by 1
		
		session.setAttribute("count", (Integer) session.getAttribute("count") +1);
		return  "counter.jsp";
	}

//	@PostMapping("/clear")
//	public String clearSession(HttpSession session) {
////		this clear everything 
//		session.invalidate();
////		clear just one attributes
//		session.removeAttribute("count");
//		return "redirect:/counting";
//	}
//	clear the session and set to zero
	@PostMapping("/clear")
	public String  clearSession(HttpSession session) {
		session.invalidate();
		return  "redirect:/server";
		
	}
	
	

}

package com.fatuma.counter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;



@Controller
@RequestMapping("/omikuji")

public class OmikujiFormController {
	@RequestMapping("")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/show")
	public String HOME(HttpSession session ) {
		session.getAttribute("pickNumber");
		
		return "show.jsp";
	}
	
//	since this is post we must specify in our show.jsp that method="POST"
	// as well as the key must match with key in our show.jsp file value="pickNumber" 
	@PostMapping("/display")
	public String createInf(HttpSession session ,
			@RequestParam(value="pickNumber") Integer pickNumber,
			@RequestParam(value="city") String city,
			@RequestParam(value="personName") String name,
			@RequestParam(value="professional") String hobby,
			@RequestParam(value="typeLiving") String typeLiving,
			@RequestParam(value="message") String message
			) {
		
		 session.setAttribute("pickNumber", pickNumber);
		 session.setAttribute("city", city);
		 session.setAttribute("personName", name);
		 session.setAttribute("professional", hobby);
		 session.setAttribute("typeLiving", typeLiving);
		 session.setAttribute("message", message);
			System.out.println(pickNumber);
			System.out.println(hobby);
		
//		we must redirect in post method athorwise it going to refresh the same form with the same information again
		// example if we have credit card, it going to recharges if we not redirect
		
		return "redirect:/omikuji/show";
		
		
	}
	
}

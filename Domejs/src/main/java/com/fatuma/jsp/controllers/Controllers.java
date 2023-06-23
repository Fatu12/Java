package com.fatuma.jsp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controllers {
	@RequestMapping("/")
	public String index() {
	    return "index.jsp";
	}
	
	
//	@RequestMapping("/") 
//	public String index(Model model) {
//		model.addAttribute("name", "Sara");
//		
//		return "Demos.jsp";
//	}
//	
//	
	

}

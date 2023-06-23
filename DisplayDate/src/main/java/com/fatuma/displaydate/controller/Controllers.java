package com.fatuma.displaydate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class Controllers {
	@RequestMapping("/")
	public String Home() {
		return "index.jsp";
		
	}
//	display the current date
	@GetMapping("/date")
	public String date(Model model) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMM d ,yyyy");  
	    Date date = new Date();  
	    System.out.println(formatter.format(date));  

		String formattedTime = formatter.format(date);
		model.addAttribute("date", formattedTime);
		return "date.jsp";
	}
//	display the current time 
	@GetMapping("/time")
	public String time(Model model ) {
		SimpleDateFormat formatter = new SimpleDateFormat("h:mm aa");  
	    Date date = new Date();  
	    System.out.println(formatter.format(date));  

		String formattedTime = formatter.format(date);
		model.addAttribute("time", formattedTime);
		
		return "time.jsp";
	}}
	

//}

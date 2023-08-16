package com.fatuma.liveChat.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller

public class MapsController {
	
	 @GetMapping("/home")
	    public String home() {
	        return "home.jsp"; // The name of your Thymeleaf template without the ".html" extension
 }
 

    @GetMapping("/maps")
	    public String showMap() {
	        return "maps.jsp"; // The name of your Thymeleaf template without the ".html" extension
    }
    

    @GetMapping("/chat")
	    public String chat() {
	        return "chat.jsp"; // The name of your Thymeleaf template without the ".html" extension
    }
    
	}



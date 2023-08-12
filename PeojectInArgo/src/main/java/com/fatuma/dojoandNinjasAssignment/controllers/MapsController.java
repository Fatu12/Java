package com.fatuma.dojoandNinjasAssignment.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller

public class MapsController {

    @GetMapping("/maps")
	    public String showMap() {
	        return "maps.jsp"; // The name of your Thymeleaf template without the ".html" extension
    }
    
    
	}



package com.fatuma.jspDome.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class MainController {
	
	@RequestMapping("/")
	public String  index(){
		System.out.println();
		return "<h1 style='color: red;'>Hello World<h1>";
	}
	
	

}

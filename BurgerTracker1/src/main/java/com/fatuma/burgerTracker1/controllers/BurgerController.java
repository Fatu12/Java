package com.fatuma.burgerTracker1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/burges")
public class BurgerController {
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	

}

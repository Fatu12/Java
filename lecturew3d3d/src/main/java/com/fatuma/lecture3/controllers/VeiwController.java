package com.fatuma.lecture3.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// if we don't want to respond with data but want to respond with a view we use @Controller annotation

@Controller
//@RequestMapping for applicable object ccontroller applies to 
public class VeiwController {
	// if we don't want to use @RequestMapping we going to us the verbs method 
	
//	when we return file name we going to return as string
	
//	Model we passing an object to the fronted through that 
	@RequestMapping("/view")
	public String index(Model viewModel) {
		ArrayList<String> pizzaMenu = new ArrayList<String >();
		pizzaMenu.add("papperoni");
		pizzaMenu.add("Goat cheeese");
		pizzaMenu.add("sausage");
		pizzaMenu.add("Bacon");
		
		
		// adding a variable and value to front end , which 
		// we using built method for addAttributes
		// in this case pizza is key and papperoni is value
		viewModel.addAttribute("pizza", "papperoni");
		viewModel.addAttribute("dfpizza", "Goat cheeese");
		viewModel.addAttribute("allPizzas", pizzaMenu);
		return "index.jsp";
		
	}
	 

}

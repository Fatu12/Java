package com.fatuma.dojoandNinjasAssignment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fatuma.dojoandNinjasAssignment.model.DormModel;
import com.fatuma.dojoandNinjasAssignment.services.DormService;
import com.fatuma.dojoandNinjasAssignment.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/dorms")

public class DormController {
	
	@Autowired
	private DormService dService;
	
	@Autowired UserService uService;
	
	@GetMapping("")
	public String getAllDorms(Model veiwModel) {
		veiwModel.addAttribute("allDorms", this.dService.getAll());
		
		return "displayAllDorms.jsp";
	}
	
	
	@GetMapping("/new")
	
	public String  createForm(@ModelAttribute("newDorm")DormModel newDorm) {
		return  "createDorm.jsp";
	}

	
	@PostMapping("/create")
     public  String createDorm(@Valid @ModelAttribute("newDorm")DormModel newDorm, BindingResult result, HttpSession session) {
		
		// when we printed out we have null value the value get display after we validate 
		if(result.hasErrors()) {
			return "createDorm.jsp";
		}
		newDorm.setCreator(this.uService.findById((long)session.getAttribute("userID")));
		// in many to many that the list is not going to create untill it redirects
		 
		 this.dService.createDorm(newDorm);

//		 newDorm.setCreator(this.uService.findById((Long)session.getAttribute("userID")));
		 System.out.println(newDorm);
		 System.out.println(newDorm.getDormName());
		 System.out.println(newDorm.getCreatedAt());
		 System.out.println(newDorm.getUpdatedAt());
		 System.out.println(newDorm.getCreator());
		 
		return "redirect:/dorms";
	}
	
	
		
	
}

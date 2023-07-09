package com.fatuma.dojoandNinjasAssignment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fatuma.dojoandNinjasAssignment.model.DojosModel;
import com.fatuma.dojoandNinjasAssignment.services.DojosService;

import jakarta.validation.Valid;

@Controller

@RequestMapping("/dojos")
public class DojosContoller {
	// this our constructer
	@Autowired
	private DojosService dService;
	
	// ==================== Get All ====================
	
	// this is going to load our form  
	@GetMapping("/")
	public String index(Model viewModel) {
		viewModel.addAttribute("newDojos", new DojosModel());
		return "createDojo.jsp";
		
	}
	//============================ Create Dojo=======================
	@PostMapping("/new")
	// CREATING  AND VALIDING IF THE USE GIVE VALID INFROMATON
	// DojosModel is our object type
	public String CreateDojo(@Valid @ModelAttribute("newDojos") DojosModel newDojos, BindingResult result, Model viewModel) {
		if(result.hasErrors()) {
			// if there is an error is going to render 
			return "createDojo.jsp";
		}
		// if everything is valid it going to save to the database
		this.dService.create(newDojos);
		return "redirect:/ninja";	
		
	}
	//======================== GET BY ID ==================
	
	@GetMapping("/{oneID}")
	public String show(@PathVariable("oneID")Long oneID, Model viewModel) {
		// datialDojos is how to pass to jsp file  to display the info in the brower
		viewModel.addAttribute("datialDojos", this.dService.getById(oneID));

		return "DisplayOne.jsp";
		
	
	}

}

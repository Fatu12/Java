package com.fatuma.dojoandNinjasAssignment.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fatuma.dojoandNinjasAssignment.model.DojosModel;
import com.fatuma.dojoandNinjasAssignment.model.NinjaModel;
import com.fatuma.dojoandNinjasAssignment.services.DojosService;
import com.fatuma.dojoandNinjasAssignment.services.NinjasService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/ninja")
public class NinjasController {
	
	@Autowired
	private NinjasService nService;
	// since we have to select from the dojo we need to have constructer to access to it 
	@Autowired 
	private  DojosService dService;
	//============================ GET ALL ========================
	@GetMapping("")
	public String index(Model viewModel) {
		// since we need the list of dojo in our database we going to pass here the list 
		// list of dojo object
		List<DojosModel> listDojos = this.dService.getAll();
		// add to our database 
		viewModel.addAttribute("listDojos" ,listDojos);
		viewModel.addAttribute("newNinja", new NinjaModel());
		return "createNinjas.jsp";
		
	}
	
		//============================ CREAT DOJO =======================
		@PostMapping("/new")
		public String CreateDojo(@Valid @ModelAttribute("newNinja") NinjaModel newNinja, BindingResult result, Model viewModel) {
			if(result.hasErrors()) {
				// if the error we going to display the info we have
				List <DojosModel> listDojos = this.dService.getAll();
				viewModel.addAttribute("listDojos" ,listDojos);
				viewModel.addAttribute("newNinja", new NinjaModel());
				return "createNinjas.jsp";
			}
			
			this.nService.create(newNinja);
			

			 
			
			return "redirect:/dojos/" +  newNinja.getDojo().getId() ;
		
		}
		
	

}

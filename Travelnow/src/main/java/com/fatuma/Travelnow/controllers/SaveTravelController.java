package com.fatuma.Travelnow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fatuma.Travelnow.models.SaveTravelModel;
import com.fatuma.Travelnow.services.SaveTravelService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/travel")

public class SaveTravelController {
	
	@Autowired
	private  SaveTravelService tsService;
	
	// ============================= GET ALL ====================
	
	@GetMapping("")
	// this order has to be this order
	//@Valid @ModelAttribute("newSaveTravel")Tweet newTweet,  BindingResult result we adding this to not lose data when error is come up
	public String index( Model viewModel) {
		viewModel.addAttribute("newSaveTravels", new SaveTravelModel());
		viewModel.addAttribute("allSaveTravel", tsService.getAll());	
		return "dashboard.jsp";
}
	//========================= CREATE==================================
	
	// all this primater must be in order 
		// @ModelAttribute("newRTweet") going to load empty object,and the form is need to match that object
		@PostMapping("/create")
		public String createSaveTravel(@Valid @ModelAttribute("newSaveTravels") SaveTravelModel newSaveTravel,  BindingResult result, Model viewModel) {
			
			
			if(result.hasErrors()) {
				// to save our data when the errors come up 
				viewModel.addAttribute("allSaveTravel", tsService.getAll());

				return "dashboard.jsp";
			
			}
			System.out.println(newSaveTravel);
			// to save our new update, so we need the id to because if the save method is given an object without an IDit will
			// create new one
			
			this.tsService.create(newSaveTravel);
			
			return "redirect:/travel";
			
		}
		
		//======================== edit/GET ONE =============================
	
		// since we going to just get one object we going to use Model and id must alway 
		// come form the database,we can not give new name for it
		
		@GetMapping("/edit/{travelID}")
		// model to get from the server so we don't need to path @ModelAttribute(), we want to access to database to get it 
		// since we are getting the "saveTravelToEdit" has to match with our form routes 
		// idToEdit exit only in our function
		
		public String editRender(Model viewModel ,@PathVariable("travelID")Long idToEdit) {
			// "tweetToEdit" need to match with the form  we have in edit.jsp
			// this.tsService.getById(idToEdit) proving the values 
			viewModel.addAttribute("saveTravelToEdit",this.tsService.getById(idToEdit));
			return "edit.jsp";
		}
		// this varible need to be id in post route
		//===================== update/edit, has to id , it need to be there 
		@PostMapping("/update/{id}")
//        @PutMapping("/update/{id}")
		public String updateValues(@Valid @ModelAttribute("saveTravelToEdit") SaveTravelModel editedTravel,  BindingResult result,
			Model viewModel) { 
			if(result.hasErrors()) {
				
				// to save our data when the errors come up 
//				viewModel.addAttribute("tweetToEdit",this.tsService.getAll());
				return "dashboard.jsp";
		
			}
			// tellig the database this need to change
//			this.tsService.update(editedTravel);
			System.out.println(editedTravel);
			return "redirect:/travel";
		}
		
		@GetMapping("/delete/{travelId}")
		public String deleteMe(@PathVariable("travelId")Long travelId) {
			System.out.println(travelId);
			this.tsService.delete(travelId);
			return "redirect:/travel";
		}
		//=============================== READ ONE=================

			@GetMapping("/{oneID}")
			public String displayOne(@PathVariable("oneID")Long oneID, Model viewModel) {
				viewModel.addAttribute("travelExpense", this.tsService.getById(oneID));
		
				return "displayOne.jsp";
				
			}
}

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

import com.fatuma.dojoandNinjasAssignment.model.NoteModel;
import com.fatuma.dojoandNinjasAssignment.model.UserModel;
import com.fatuma.dojoandNinjasAssignment.services.HouseHunterServices;
import com.fatuma.dojoandNinjasAssignment.services.NoteService;
import com.fatuma.dojoandNinjasAssignment.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/notes")

public class NoteController {
	
	@Autowired
	private HouseHunterServices hService;
	@Autowired
	private UserService uService;
	@Autowired
	private NoteService nService;
	
	
	@GetMapping("/{houseHId}")
	public String noteCreaterForm(@PathVariable("houseHId")Long houseId, @ModelAttribute("newNote")NoteModel newNote,Model viewModel,HttpSession session) {
		
			viewModel.addAttribute("thisHouseHuter", this.hService.getByID(houseId));
//			viewModel.addAttribute("currentUser", this.uService.findById((Long)session.getAttribute("userID")));
		     return "DisplayOne.jsp";	
			
	}
	
	@PostMapping("/create/{houseHId}")
	public String createTask(@Valid @ModelAttribute("newNote")NoteModel newNote, BindingResult result
			, Model viewModel,@PathVariable("houseHId")Long houseId,HttpSession session) {

		
	if(result.hasErrors()) {
		viewModel.addAttribute("thisHouseHuter", this.hService.getByID(houseId));
		return "DisplayOne.jsp";
	}
		 // when you make new varable make check the data type
		 UserModel currentUser = this.uService.findById((long)session.getAttribute("userID"));
		this.nService.createNote(newNote, currentUser,this.hService.getByID(houseId));
	
		return "redirect:/notes/{houseHId}";
	}

}

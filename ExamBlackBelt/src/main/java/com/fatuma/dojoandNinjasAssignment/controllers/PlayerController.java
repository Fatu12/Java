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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fatuma.dojoandNinjasAssignment.model.PlayerModel;
import com.fatuma.dojoandNinjasAssignment.model.UserModel;
import com.fatuma.dojoandNinjasAssignment.services.PlayerService;
import com.fatuma.dojoandNinjasAssignment.services.TeamServices;
import com.fatuma.dojoandNinjasAssignment.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("players")

public class PlayerController {
	
	@Autowired
	private UserService uService;
	
	@Autowired 
	private TeamServices tService;
	
	@Autowired
	private PlayerService pService;
	
	

	@GetMapping("/{playerId}")
	public String noteCreaterForm(@PathVariable("playerId")Long playerId, @ModelAttribute("newPlayer")PlayerModel newPlayer,Model viewModel,HttpSession session) {

		if((Long)session.getAttribute("userID")== null) {
			return "redirect:/";
		}
		
			viewModel.addAttribute("thisTeams", this.tService.getByID(playerId));
		     return "displayOne.jsp";	
			
	}
	
	@PostMapping("/create/{playerId}")
	public String createTask(@Valid @ModelAttribute("newPlayer")PlayerModel newPlayer, BindingResult result
			, Model viewModel,@PathVariable("playerId")Long playerId,HttpSession session,RedirectAttributes redirectAttributes) {

		if((Long)session.getAttribute("userID")== null) {
			return "redirect:/";
		}

	if(result.hasErrors()) {
		viewModel.addAttribute("thisTeams", this.tService.getByID(playerId));
		return "displayOne.jsp";
	}
		 // when you make new varable make check the data type

	
	UserModel currentUser = this.uService.findById((long)session.getAttribute("userID"));
		 
	 this.pService.createPlayer(newPlayer, currentUser, this.tService.getByID(playerId));
	
	
		return "redirect:/players/{playerId}";
	}


}

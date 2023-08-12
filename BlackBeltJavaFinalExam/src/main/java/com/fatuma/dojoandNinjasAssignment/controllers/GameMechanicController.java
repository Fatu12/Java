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
import com.fatuma.dojoandNinjasAssignment.model.GameMechanicModel;
import com.fatuma.dojoandNinjasAssignment.model.UserModel;
import com.fatuma.dojoandNinjasAssignment.services.GameMechanicService;
import com.fatuma.dojoandNinjasAssignment.services.GameService;
import com.fatuma.dojoandNinjasAssignment.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/mechanic")

public class GameMechanicController {
	
	@Autowired
	private GameService gService;
	
	@Autowired
	private UserService uService;
	
	@Autowired
	private GameMechanicService mService;
	
	@GetMapping("/{gameId}")
	public String gameCreaterForm(@PathVariable("gameId")Long gameId, @ModelAttribute("newGameMechanic")GameMechanicModel newGame,Model viewModel,HttpSession session) {

	if((Long)session.getAttribute("userID")== null) {
			return "redirect:/";
		}
		
			viewModel.addAttribute("thisGame", this.gService.getByID(gameId));
		     return "displayOne.jsp";	
			
	}
	
	@PostMapping("/create/{gameId}")
	public String createGame(@Valid @ModelAttribute("newGameMechanic")GameMechanicModel newGame, BindingResult result
			, Model viewModel,@PathVariable("gameId")Long gameId,HttpSession session) {

	if((Long)session.getAttribute("userID")== null) {
			return "redirect:/";
		}

	if(result.hasErrors()) {
		viewModel.addAttribute("thisGame", this.gService.getByID(gameId));
		return "displayOne.jsp";
	}
		 

	
	UserModel currentUser = this.uService.findById((long)session.getAttribute("userID"));
		 
	this.mService.createGameMechanic(newGame, currentUser, this.gService.getByID(gameId));
	
		return "redirect:/mechanic/{gameId}";
	}


}

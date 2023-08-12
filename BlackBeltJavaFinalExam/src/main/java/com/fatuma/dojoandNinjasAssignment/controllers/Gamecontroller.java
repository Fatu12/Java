package com.fatuma.dojoandNinjasAssignment.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fatuma.dojoandNinjasAssignment.model.GameModel;
import com.fatuma.dojoandNinjasAssignment.model.UserModel;
import com.fatuma.dojoandNinjasAssignment.services.GameService;
import com.fatuma.dojoandNinjasAssignment.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("games")

public class Gamecontroller {


	
	@Autowired
	private UserService uService;
	
	@Autowired
	private GameService gService;
	
	
	@GetMapping("/new")
	
	public String  createForm(@ModelAttribute("newGame")GameModel newGame,Model viewModel, HttpSession session) {
	

	if((Long)session.getAttribute("userID")== null) {
		return "redirect:/";
	}
	 	Long userId =(long) session.getAttribute("userID");
		 viewModel.addAttribute("currentUser", this.uService.findById(userId));
		return  "createGame.jsp";
	}

	
	@PostMapping("/create")
     public  String createHouseHunter(@Valid @ModelAttribute("newGame")GameModel newGame, BindingResult result, HttpSession session) {
		if(session.getAttribute("userID")== null) {
			return "redirect:/";
		}
		
			if(result.hasErrors()) {
				return "createGame.jsp";
			
		}
			newGame.setCreator(this.uService.findById((Long)session.getAttribute("userID")));

		 this.gService.createGame(newGame);
		 System.out.println(newGame);
		 System.out.println(newGame.getName());
		 System.out.println(newGame.getDescription());
		 System.out.println(newGame.getGenre());
		 System.out.println(newGame.getId());
		 System.out.println(newGame.getCreatedAt());
		 System.out.println(newGame.getCreator());
		 this.gService.createGame(newGame);
		 
		
		
		 
		 
		return "redirect:/users/home";
	}

	
	@GetMapping("/edit/{updateId}")
	public String updateForm(@PathVariable("updateId")Long updateID, Model viewModel,
		HttpSession session) {
	   viewModel.addAttribute("updatedGame", this.gService.getByID(updateID));
		

		if((Long)session.getAttribute("userID")== null) {
			return "redirect:/";
	}
    this.gService.getByID(updateID);	
		return "edit.jsp";
	}
	@PostMapping("/update/{id}")
	public String updateProject(@Valid @ModelAttribute("updatedGame")GameModel updatedGame,BindingResult result,Model viewModel,
			HttpSession session) {
		if(session.getAttribute("userID")== null) {
		return "redirect:/";
	}
		
			if(result.hasErrors()) {
				return "edit.jsp";		
				}
			
			updatedGame.setCreator(this.uService.findById((long)session.getAttribute("userID")));
			this.gService.updateGame(updatedGame);
			return "redirect:/users/home";
	}

	@GetMapping("/delete/{deleteId}")
    public String deleteGame(@PathVariable("deleteId")Long gameId,Model viewModel, HttpSession session ) {

		if((Long)session.getAttribute("userID")== null) {
			return "redirect:/";
		}
		
		UserModel user = this.uService.findById((Long)session.getAttribute("userID"));
	    viewModel.addAttribute("user", user);
		 gService.deleteGame(gameId);
	        return "redirect:/users/home";
	    }


		

	

}



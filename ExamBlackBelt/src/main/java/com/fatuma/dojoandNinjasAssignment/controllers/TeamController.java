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


import com.fatuma.dojoandNinjasAssignment.model.TeamModel;
import com.fatuma.dojoandNinjasAssignment.model.UserModel;
import com.fatuma.dojoandNinjasAssignment.services.TeamServices;
import com.fatuma.dojoandNinjasAssignment.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("teams")

public class TeamController {
	@Autowired
	private UserService uService;
	
	@Autowired 
	private TeamServices tService;
	
	
	@GetMapping("/new")
		
		public String  createForm(@ModelAttribute("newTeam")TeamModel newTeam,Model viewModel, HttpSession session) {
		

		if((Long)session.getAttribute("userID")== null) {
			return "redirect:/";
		}
		 	Long userId =(long) session.getAttribute("userID");
			 viewModel.addAttribute("currentUser", this.uService.findById(userId));
			return  "createTeam.jsp";
		}
	
		
		@PostMapping("/create")
	     public  String createHouseHunter(@Valid @ModelAttribute("newTeam")TeamModel newTeam, BindingResult result, HttpSession session) {
			if(session.getAttribute("userID")== null) {
				return "redirect:/users";
			}
			
				if(result.hasErrors()) {
					return "createTeam.jsp";
				
			}
		     newTeam.setCreatore(this.uService.findById((Long)session.getAttribute("userID")));
	
			 this.tService.createTeam(newTeam);
			 System.out.println(newTeam);
			 System.out.println(newTeam.getName());
			 System.out.println(newTeam.getSkillLevel());
			 System.out.println(newTeam.getId());
			 System.out.println(newTeam.getCreatedAt());
			 System.out.println(newTeam.getCreatore());
			 
			return "redirect:/users/home";
		}
	
		@GetMapping("/edit/{updateId}")
		public String updateForm(@PathVariable("updateId")Long updateID, Model viewModel,
			HttpSession session) {
			viewModel.addAttribute("updatedTeam",this.tService.getByID(updateID));
			

			if((Long)session.getAttribute("userID")== null) {
				return "redirect:/";
			}
//		    this.tService.getByID(updateID);	
			return "edit.jsp";
		}
		@PostMapping("/update/{id}")
		public String updateProject(@Valid @ModelAttribute("updatedTeam")TeamModel updatedTeam,BindingResult result,Model viewModel,
				HttpSession session) {
			if(session.getAttribute("userID")== null) {
				return "redirect:/";
			}
			
				if(result.hasErrors()) {
					return "edit.jsp";		
					}
				
		updatedTeam.setCreatore(this.uService.findById((long)session.getAttribute("userID")));
				this.tService.updateTeam(updatedTeam);
				return "redirect:/users/home";
		}

	
		@GetMapping("/delete/{deleteId}")
	    public String deleteTeam(@PathVariable("deleteId")Long houseId,Model viewModel, HttpSession session ) {

			if((Long)session.getAttribute("userID")== null) {
				return "redirect:/";
			}
			
			UserModel user = this.uService.findById((Long)session.getAttribute("userID"));
		    viewModel.addAttribute("user", user);
			 tService.deleteTeam(houseId);
			 System.out.println(houseId);
		        return "redirect:/users/home";
		    }
	
	
	

}

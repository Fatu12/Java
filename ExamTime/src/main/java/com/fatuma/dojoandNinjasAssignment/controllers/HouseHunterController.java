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

import com.fatuma.dojoandNinjasAssignment.model.HouseHunterModel;
import com.fatuma.dojoandNinjasAssignment.model.NoteModel;
import com.fatuma.dojoandNinjasAssignment.model.UserModel;
import com.fatuma.dojoandNinjasAssignment.services.HouseHunterServices;
import com.fatuma.dojoandNinjasAssignment.services.NoteService;
import com.fatuma.dojoandNinjasAssignment.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/houses")
public class HouseHunterController {
	
	@Autowired
	private UserService uService;
	
	@Autowired
	private HouseHunterServices hService;
	@Autowired
	private NoteService nService;
	
	
@GetMapping("/new")
	
	public String  createForm(@ModelAttribute("newHouseHunter")HouseHunterModel newHouseHunter,Model viewModel, HttpSession session) {
		Long userId =(long) session.getAttribute("userID");
		 viewModel.addAttribute("currentUser", this.uService.findById(userId));
		return  "createHouses.jsp";
	}

	
	@PostMapping("/create")
     public  String createHouseHunter(@Valid @ModelAttribute("newHouseHunter")HouseHunterModel newHouseHunter, BindingResult result, HttpSession session) {
		
	if(result.hasErrors()) {
		return "createHouses.jsp";
			
		}
	newHouseHunter.setCreatore(this.uService.findById((Long)session.getAttribute("userID")));

		 this.hService.createHouseHunter(newHouseHunter);
//		 System.out.println(newHouseHunter);
//		 System.out.println(newHouseHunter.getAddress());
//		 System.out.println(newHouseHunter.getPrice());
//		 System.out.println(newHouseHunter.getId());
//		 System.out.println(newHouseHunter.getCreatedAt());
//		 System.out.println(newHouseHunter.getCreatore());
		 
		return "redirect:/users/home";
	}
	
	
	@GetMapping("/{oneID}")
	public String showHouseHunter(@PathVariable("oneID")Long oneID, Model viewModel, HttpSession session) {
	
	
	viewModel.addAttribute("showHouseHounter",this.hService.getByID(oneID));
	UserModel userId = this.uService.findById((Long)session.getAttribute("userID"));
	viewModel.addAttribute("user", userId);
	
	return "DisplayOne.jsp";
	}
	
	
	@GetMapping("/delete/{deleteId}")
    public String deleteHouseHunter(@PathVariable("deleteId")Long houseId,Model viewModel, HttpSession session ) {
		
	UserModel user = this.uService.findById((Long)session.getAttribute("userID"));
    viewModel.addAttribute("user", user);
	 hService.deleteHouseHunter(houseId);
	 System.out.println(houseId);
        return "redirect:/users/home";
    }
	@GetMapping("/edit/{updateId}")
	public String updateForm(@PathVariable("updateId")Long updateID , Model viewModel,
		HttpSession session) {
		
	viewModel.addAttribute("updatedHouseHunter",this.hService.getByID(updateID));
//		this.hService.getByID(updateID);	
		return "edit.jsp";
	}
	@PostMapping("/update/{id}")
	public String updateProject(@Valid @ModelAttribute("updatedHouseHunter")HouseHunterModel updatedhouseHunter,BindingResult result,Model viewModel,
			HttpSession session) {
	
			if(result.hasErrors()) {
				
				return "edit.jsp";		
				}
			
	updatedhouseHunter.setCreatore(this.uService.findById((long)session.getAttribute("userID")));
			this.hService.updateHouter(updatedhouseHunter);
			return "redirect:/users/home";
	}

	

}

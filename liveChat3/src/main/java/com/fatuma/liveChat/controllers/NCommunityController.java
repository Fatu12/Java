package com.fatuma.liveChat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fatuma.liveChat.models.NcommunityModel;
import com.fatuma.liveChat.services.NCommunityService;
import com.fatuma.liveChat.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/community")
public class NCommunityController {
	@Autowired
	private UserService uService;
	
	@Autowired
	 private  NCommunityService NCService;
	
	@GetMapping("/info")
	public String getAll(HttpSession session, Model viewModel) {
		this.NCService.getAll();
		 System.out.println(this.NCService.getAll());
		Long userId =(long) session.getAttribute("userID");
		 viewModel.addAttribute("currentUser", this.uService.findById(userId));
		 viewModel.addAttribute("allComminityInfo", this.NCService.getAll());
		 
		return "displayAllInfo.jsp";
	}
	
	@GetMapping("/new")
	public String createForm(@ModelAttribute("newNCommunity")NcommunityModel newNCommunity) {

		return "createNCommunity.jsp";				
	}
	
	@PostMapping("/create")
	public String addProject(@Valid @ModelAttribute("newNCommunity")NcommunityModel newNCommunity, BindingResult result, HttpSession session) {
		
			if(result.hasErrors()) {
			return "createNCommunity.jsp";
		}
//		 System.out.println(newNCommunity);
//		 System.out.println(newNCommunity.getTitle());
//		 System.out.println(newNCommunity.getDiscription());
//		 System.out.println(newNCommunity.getAddress());
//		 System.out.println(newNCommunity.getCreator());
//		 System.out.println(newNCommunity.getDate());
			
		 
		 this.NCService.createNCommunity(newNCommunity, this.uService.findById((long)session.getAttribute("userID")));
		

		return "redirect:/community/info";
	}

	@GetMapping("/edit/{comunityId}")
	public String projectEditForm(@PathVariable("comunityId")Long communitId, Model viewModel) {
		viewModel.addAttribute("communityToEdit", this.NCService.getByID(communitId));
		return "edit.jsp";
		
	}
	
	@PostMapping("/update/{id}")
	public String projectEditPost(@Valid @ModelAttribute("communityToEdit") NcommunityModel editCommunity, BindingResult result,
			HttpSession session ) {
	
		if(result.hasErrors()) {
			
			return "edit.jsp";
		}
		// inseade of doing here we have done the same contoller in our service
		editCommunity.setCreator(this.uService.findById((long)session.getAttribute("userID")));

		this.NCService.updateNCommunty(editCommunity);
		return "redirect:/commant/{id}";
	}
	
	@GetMapping("/delete/{deleteId}")
    public String destroy(@PathVariable("deleteId") Long projId,HttpSession session ,Model viewModel) {
	
	this.NCService.deleteNCommunity(projId);
	 System.out.println(projId);
	 return "redirect:/users/home";

       
    }

	}



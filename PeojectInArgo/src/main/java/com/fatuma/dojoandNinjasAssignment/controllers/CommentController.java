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
import com.fatuma.dojoandNinjasAssignment.model.CommentModel;
import com.fatuma.dojoandNinjasAssignment.model.UserModel;
import com.fatuma.dojoandNinjasAssignment.services.CommentService;
import com.fatuma.dojoandNinjasAssignment.services.NCommunityService;
import com.fatuma.dojoandNinjasAssignment.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/commant")

public class CommentController {
	
	@Autowired
	private NCommunityService ncService;
	@Autowired
	private CommentService cService;
	
	@Autowired
	private UserService uService;
	
	@GetMapping("/{NCId}")
	public String noteCreaterForm(@PathVariable("NCId")Long houseId, @ModelAttribute("newComment")CommentModel newComment,Model viewModel,HttpSession session) {
		
			viewModel.addAttribute("thisCommuunity", this.ncService.getByID(houseId));
		     return "displayOne.jsp";	
			
	}
	
	@PostMapping("/create/{NCId}")
	public String createTask(@Valid @ModelAttribute("newComment")CommentModel newComment, BindingResult result
			, Model viewModel,@PathVariable("NCId")Long communityId,HttpSession session) {

		
	if(result.hasErrors()) {
		viewModel.addAttribute("thisCommuunity", this.ncService.getByID(communityId));
		return "displayOne.jsp";
	}
		 UserModel currentUser = this.uService.findById((long)session.getAttribute("userID"));
		this.cService.createComment(newComment, currentUser, this.ncService.getByID(communityId));
	
		return "redirect:/commant/{NCId}";
	}

	@GetMapping("/delete/{deleteId}")
    public String destroy(@PathVariable("deleteId") Long commentId,HttpSession session ,Model viewModel) {
	
	this.cService.deleteCommant(commentId);
	 System.out.println(commentId);
	 return "redirect:/commant/{deleteId}";

       
    }

	
	
	

}

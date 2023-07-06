package com.fatuma.backendlecture.controllers;

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
import org.springframework.web.service.annotation.DeleteExchange;

import com.fatuma.backendlecture.models.Tweet;
import com.fatuma.backendlecture.services.TweetService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/tweet")
public class APIController {
	
	@Autowired
	private TweetService tService;
	
	//============================ GET ALL====================
		
	@GetMapping("")
	// this order has to be this order
	//@Valid @ModelAttribute("newRTweet")Tweet newTweet,  BindingResult result we adding this to lose data when error is come up
	public String index(@Valid @ModelAttribute("newRTweet")Tweet newTweet,  BindingResult result, Model viewModel) {
		viewModel.addAttribute("allTheThings", tService.getAll());
		
		return "index.jsp";
		
		//========================== CREATE==================
}
	// all this primater must be in order 
	// @ModelAttribute("newRTweet") going to load empty object,and the form is need to match that object
	@PostMapping("/create")
	public String createTweet(@Valid @ModelAttribute("newRTweet")Tweet newTweet,  BindingResult result, Model viewModel) {
		
		
		if(result.hasErrors()) {
			// to save our data when the errors come up 
			viewModel.addAttribute("allTheThings", tService.getAll());

			return "index.jsp";
		
		}
		System.out.println(newTweet);
		
		this.tService.create(newTweet);
		
		return "redirect:/tweet";
		
	}
	// since we going to just get one object we going to use Model
	
	@GetMapping("/edit/{tweetId}")
	public String editRender(Model viewModel ,@PathVariable("tweetId")Long idToEdit) {
		// "tweetToEdit" need to match with the variable we have in edit.jsp
		viewModel.addAttribute("tweetToEdit",this.tService.getById(idToEdit));
		return "edit.jsp";
	}
	// this varible need to be id in post route
	//===================== update/edit
	@PostMapping("/update/{id}")
//	@PutMapping("/update/{id}")
	public String updateValues(@Valid @ModelAttribute("tweetToEdit")Tweet editTweet,  BindingResult result,
		Model viewModel) { 
		
		if(result.hasErrors()) {
			
			// to save our data when the errors come up 
//			viewModel.addAttribute("tweetToEdit",this.tService.getAll());


			return "edit.jsp";
	
		}
		// tellig the database this need to change
		this.tService.tweetUpdate(editTweet);
		System.out.println(editTweet);
		return "redirect:/tweet";
	}
	// for usining hidden form 
	@DeleteMapping("/delete/{tweetId}")

//	@GetMapping("/delete/{tweetId}")
	public String deleteMe(@PathVariable("tweetId")Long tweetId) {
		System.out.println(tweetId);
		this.tService.delete(tweetId);
		return "redirect:/tweet";
	}
	
	
	
}
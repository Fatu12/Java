package com.fatuma.backendlecture.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.fatuma.backendlecture.models.Tweet;
import com.fatuma.backendlecture.services.TweetService;

@RestController
@RequestMapping("/api")
public class APITweetController {
	@Autowired
	private TweetService tService;
	//===================== GET ALL ========================
	
	@GetMapping("/")
	public List<Tweet> getAll(){
		return this.tService.getAll();
	}
	//====================== Create==========================
	@PostMapping("/create")
	public Tweet  createTweet(
		@RequestParam("tweetContent")String content,
		@RequestParam("imginaryIntAtt")Integer imaginaryInt) {
		Tweet newTweet = new Tweet(content,imaginaryInt);
		
		System.out.println(content);
		System.out.println(imaginaryInt);
		
		return this.tService.create(newTweet);
	}
	//==================== READ BY ID===================
	
	@GetMapping("/{tweetId}")
	public Tweet getOne(@PathVariable("tweetId")Long id){
		return this.tService.getById(id);
		
	}
	//================UPDATE=======================
	@PutMapping("/update/{tweetID}")
	public String updateObject(@PathVariable("tweetID")Long idUpdate,@RequestParam(value="tweetContent", required= false)String content,
			@RequestParam(value= "imginaryIntAtt", required=false)int imaginaryInt) {
			Tweet newUpdate = tService.getById(idUpdate);
		
			System.out.print(newUpdate.getId());
			// setting the new object 
			newUpdate.setTweetContent(content!=null? content: newUpdate.getTweetContent());
			newUpdate.setImginaryIntAtt(imaginaryInt) ;
			// save the new object 
			this.tService.tweetUpdate(newUpdate);
			
		return "";
	}
	// =================== DELETE BY ID ============================
	@DeleteMapping("/delete/{tweetId}")
	public String deleteObject(@PathVariable("tweetId")Long idDelete) {
		System.out.print(idDelete);
		this.tService.delete(idDelete);
		return "";
		
	}
	
	
//======================== eidt========================
	// since we going to get 
	@GetMapping("/edit/{tweetId}")
	public String editRender() {
		return "edit.jsp";
	}

}


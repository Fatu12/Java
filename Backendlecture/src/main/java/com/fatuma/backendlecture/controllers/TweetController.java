package com.fatuma.backendlecture.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fatuma.backendlecture.models.Tweet;
import com.fatuma.backendlecture.services.TweetService;

@RestController
@RequestMapping
public class TweetController {
	@Autowired
	private TweetService tService;
	@PostMapping("/create")
	public Tweet  createTweet(
		@RequestParam("tweetContent")String content,
		@RequestParam("imginaryIntAtt")Integer imaginaryInt) {
		Tweet newTweet = new Tweet(content,imaginaryInt);
		
		System.out.println(content);
		System.out.println(imaginaryInt);
		
		return this.tService.create(newTweet);
	}
	@GetMapping("")
	public List<Tweet> getAll(){
		return this.tService.getAll();
	}
//	@GetMapping("/{tweetId}")
//	public Tweet getOne(@PathVariable("tweetId")Long id){
//		return this.tService.getById(id);
//	}
}


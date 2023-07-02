package com.fatuma.backendlecture.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatuma.backendlecture.models.Tweet;
import com.fatuma.backendlecture.repository.TweetRepo;

@Service
public class TweetService {
//	 private final TweetRepo tRepo;
//	 public TweetService(TweetRepo tRepo) {
//		 this.tRepo = tRepo;
//		 
//	 }
	 
@Autowired
private TweetRepo tRepo;

// create
public Tweet create(Tweet newTweet) {
	return tRepo.save(newTweet);
	
}

// read

public List<Tweet> getAll() {
    return tRepo.findAll();
}


// update
// Delete
// update



}


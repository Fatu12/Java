package com.fatuma.backendlecture.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fatuma.backendlecture.models.Tweet;

public interface TweetRepo  extends CrudRepository<Tweet,Long>{
	List<Tweet> findAll();
	

}


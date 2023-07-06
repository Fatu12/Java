package com.fatuma.burgerTrackers.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fatuma.burgerTrackers.models.BurgerModel;

@Repository
public interface BurgerRepo extends CrudRepository<BurgerModel , Long>{ 
	
		
		  // this method retrieves all the books from the database
	    List<BurgerModel > findAll();




	
}

package com.fatuma.burgerTrackers.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fatuma.burgerTrackers.models.BurgerModel;
import com.fatuma.burgerTrackers.services.BurgerService;

@RestController

public class BurgerController {
	
	@Autowired
	private BurgerService burgerService;
	
	//============ rendering all the burgers ==================
	
	@GetMapping("/api/burger")
	public List<BurgerModel> index(){
		return  burgerService.allBurgers();
	}
	
	//=======================CREATE
	@RequestMapping(value="create/burgers", method=RequestMethod.POST)
    public BurgerModel create(
    		
    		@RequestParam(value="burgarName") String name, 
    		@RequestParam(value="restName") String restName, 
    		@RequestParam(value="rating") Long rating ,
    		@RequestParam(value="comment") String comment) {
			BurgerModel newBurger = new BurgerModel(name,restName,rating,comment);
        return this.burgerService.createBurger(newBurger);
    }
	@RequestMapping(value="create/burgers{burgerID}", method=RequestMethod.POST)
    public BurgerModel update(
    		@PathVariable("burgerID") Long id, 
    		@RequestParam(value="burgarName") String name, 
    		@RequestParam(value="restName") String restaurantName, 
    		@RequestParam(value="rating") Long rating ,
    		@RequestParam(value="comment") String leaveComment) {
        BurgerModel newBurger= new BurgerModel();
        return this.burgerService.createBurger(newBurger);
    }
	
	
}

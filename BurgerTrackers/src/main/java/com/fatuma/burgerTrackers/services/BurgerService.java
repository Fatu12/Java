package com.fatuma.burgerTrackers.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatuma.burgerTrackers.models.BurgerModel;
import com.fatuma.burgerTrackers.repository.BurgerRepo;

@Service
public class BurgerService {

	//since all our CRUD IS GOING TO PASS TO THIS REP WE NEED TO ACCESS THIS TO 
	// CREATE ALL OUR CREATE WE NEED FOR THIS CLASS
	@Autowired
	
	private BurgerRepo burgerRepo;
	
	// we need to return list of all the burgers in the database
	// since our model is containing all of our attribute we need to create
	// this application, we pass that to  this to get the list of this object
	
	//================== READ ALL ============================
	public List<BurgerModel> allBurgers(){
		return burgerRepo.findAll();
	}
	
	// ===================== CREATE =====================
	
	public BurgerModel createBurger(BurgerModel newBurger) {
		return burgerRepo.save(newBurger);	
		
	}
	//==================== Update=================
	
		    public BurgerModel updateBook(BurgerModel newBurger) {
		        return burgerRepo.save(newBurger);
		    }
		    
		    //================= read one =====================
		    public BurgerModel getById(Long id) {
		    	return burgerRepo.findById(id).orElse(null);
		    	
		    }
		    
		 // ============  delete book  ===============   
		    public void deleteBurgerById(Long id) {
		    	burgerRepo.deleteById(id);
		    }
		     
}

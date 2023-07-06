package com.fatuma.Travelnow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatuma.Travelnow.models.SaveTravelModel;
import com.fatuma.Travelnow.reposotaries.SaveTravelRepo;


// @Service must be proved, and all our CRUD loggic goes here
@Service
public class SaveTravelService {
	
	// using @Autowired is same us creating final attributes and  passig to the constructers
	
 @Autowired
 private SaveTravelRepo stRepo;
 
 //===================== READ ============================
 public List<SaveTravelModel> getAll(){
	 return stRepo.findAll();
 }
 
 // ==================== CREATE======================
 
 // SaveTravelModel is our object we going to create so we must pass here, to create what we want
 public SaveTravelModel create(SaveTravelModel newSaveTravel) {
	 return stRepo.save(newSaveTravel);
	 	
 }
 
 // ======================== UPDATE========================================
 
 public SaveTravelModel update(SaveTravelModel newSaveTravel) {
	 return stRepo.save(newSaveTravel);
	 	
 } 
 // ======================= FIND BY ID ===================================
 
 public SaveTravelModel getById(Long oneId) {
	 return stRepo.findById(oneId).orElse(null);
 }
 
 //==========================DELETE====================================
 public void delete(Long id) {
	 this.stRepo.deleteById(id);
 }
 
}

package com.fatuma.dojoandNinjasAssignment.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatuma.dojoandNinjasAssignment.model.NinjaModel;
import com.fatuma.dojoandNinjasAssignment.repositories.NinjasRepo;


@Service

public class NinjasService {
	@Autowired
	 private NinjasRepo  nRepo;
	 
	 //===================== READ ============================
	 public List<NinjaModel> getAll(){
		 return nRepo.findAll();
	 }
	 
	 // ==================== CREATE======================
	 
	 // SaveTravelModel is our object we going to create so we must pass here, to create what we want
	 public NinjaModel create(NinjaModel newNinja) {
		 return nRepo.save(newNinja);
		 	
	 }
	 
	 // ======================== UPDATE========================================
	 
	 public NinjaModel update(NinjaModel newNinja) {
		 return nRepo.save(newNinja);
		 	
	 } 
	 // ======================= FIND BY ID ===================================
	 
	 public NinjaModel getById(Long oneId) {
		 return nRepo.findById(oneId).orElse(null);
	 }
	 
	 //==========================DELETE====================================
	 public void delete(Long id) {
		 this.nRepo.deleteById(id);
	 }
	 
	}


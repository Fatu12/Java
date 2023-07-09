package com.fatuma.dojoandNinjasAssignment.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatuma.dojoandNinjasAssignment.model.DojosModel;
import com.fatuma.dojoandNinjasAssignment.repositories.DojosRepo;

@Service

public class DojosService {
	
	@Autowired
	 private DojosRepo  dRepo;
	 
	 //===================== READ ============================
	 public List<DojosModel> getAll(){
		 return dRepo.findAll();
	 }
	 
	 // ==================== CREATE======================
	 
	 // SaveTravelModel is our object we going to create so we must pass here, to create what we want
	 public DojosModel create(DojosModel newDojos) {
		 return dRepo.save(newDojos);
		 	
	 }
	 
	 // ======================== UPDATE========================================
	 
	 public DojosModel update(DojosModel newDojos) {
		 return dRepo.save(newDojos);
		 	
	 } 
	 // ======================= FIND BY ID ===================================
	 
	 public DojosModel getById(Long oneId) {
		 return dRepo.findById(oneId).orElse(null);
	 }
	 
	 //==========================DELETE====================================
	 public void delete(Long id) {
		 this.dRepo.deleteById(id);
	 }
	 
	}



	

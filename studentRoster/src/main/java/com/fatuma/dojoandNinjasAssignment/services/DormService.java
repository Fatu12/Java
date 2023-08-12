package com.fatuma.dojoandNinjasAssignment.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatuma.dojoandNinjasAssignment.model.DormModel;
import com.fatuma.dojoandNinjasAssignment.repositories.DormRepo;


@Service
public class DormService {
	
	@Autowired
	private DormRepo dRepo;
	
	//===================== CREATE =========================
	// Since we want when we create we want to add the list of the creator we need to pass the
	// user object
	
	
	public DormModel createDorm(DormModel newDorm) {
		
		
		 return this.dRepo.save(newDorm);	
		
	}
		
		public List<DormModel> getAll(){
			
			return this.dRepo.findAll();
		}
		
		//======================== Update =====================
		
		public DormModel updateDorm(DormModel updatedDorm) {
			return dRepo.save(updatedDorm);
		}
		
		//====================== FIND BY ID ==========================
		
		public DormModel getByID(Long dormId) {
			return dRepo.findById(dormId).orElse(null);
		}
		
	//=================== DELETE==================
		
		public void deleteDorm(Long deleteID) {
			this.dRepo.deleteById(deleteID);
		}
		
				
}



package com.fatuma.dojoandNinjasAssignment.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatuma.dojoandNinjasAssignment.model.HouseHunterModel;
import com.fatuma.dojoandNinjasAssignment.repositories.HousHunterRepo;



@Service

public class HouseHunterServices {
	
@Autowired
	
	private HousHunterRepo hRepo;
	//===================== CREATE =========================
	// Since we want when we create we want to add the list of the creator we need to pass the
	// user object
	
	
	public HouseHunterModel createHouseHunter(HouseHunterModel newHouseHunter) {
		
		 return this.hRepo.save(newHouseHunter);	
		
	}
		
		public List<HouseHunterModel> getAll(){
			
			return this.hRepo.findAll();
		}
		
		//======================== Update =====================
		
		public HouseHunterModel updateHouter(HouseHunterModel updatedHouseHunter) {
			return hRepo.save(updatedHouseHunter);
		}
		
		//====================== FIND BY ID ==========================
		
		public HouseHunterModel getByID(Long houseHunterId) {
			return hRepo.findById(houseHunterId).orElse(null);
		}
		
	//=================== DELETE==================
		
		public void deleteHouseHunter(Long deleteID) {
			this.hRepo.deleteById(deleteID);
		}
		
	

}

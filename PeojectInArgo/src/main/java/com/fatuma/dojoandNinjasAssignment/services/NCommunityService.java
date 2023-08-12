package com.fatuma.dojoandNinjasAssignment.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatuma.dojoandNinjasAssignment.model.NcommunityModel;
import com.fatuma.dojoandNinjasAssignment.model.UserModel;
import com.fatuma.dojoandNinjasAssignment.repositories.NCommunityRepo;
@Service
public class NCommunityService {

	
	@Autowired
	private NCommunityRepo NCRepo;
	
	//===================== CREATE =========================
	// Since we want when we create we want to add the list of the creator we need to pass the
	// user object
	
	
	public NcommunityModel createNCommunity(NcommunityModel newNComm, UserModel user) {
		newNComm.setCreator(user);
		
		return this.NCRepo.save(newNComm);
	}
		
		public List<NcommunityModel> getAll(){
			
			return this.NCRepo.findAll();
		}
			

		//======================== Update =====================
		
		public NcommunityModel updateNCommunty(NcommunityModel updatedNComm) {
			return NCRepo.save(updatedNComm);
		}
		
		//====================== FIND BY ID ==========================
		
		public NcommunityModel getByID(Long commId) {
			return NCRepo.findById(commId).orElse(null);
		}
		
	//=================== DELETE==================
		
		public void deleteNCommunity(Long deleteID) {
			this.NCRepo.deleteById(deleteID);
		}
		
	
}

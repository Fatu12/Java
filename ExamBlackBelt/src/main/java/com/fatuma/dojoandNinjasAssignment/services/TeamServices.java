package com.fatuma.dojoandNinjasAssignment.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatuma.dojoandNinjasAssignment.model.TeamModel;
import com.fatuma.dojoandNinjasAssignment.repositories.TeamRepo;


@Service

public class TeamServices {
	
	@Autowired
	
	private TeamRepo tRepo;
	//===================== CREATE =========================
	// Since we want when we create we want to add the list of the creator we need to pass the
	// user object
	
	
	public TeamModel createTeam(TeamModel newTeam) {
		
		 return this.tRepo.save(newTeam);	
		
	}
		
		public List<TeamModel> getAll(){
			
			return this.tRepo.findAll();
		}
		
		//======================== Update =====================
		
		public TeamModel updateTeam(TeamModel updatedTeam) {
			return tRepo.save(updatedTeam);
		}
		
		//====================== FIND BY ID ==========================
		
		public TeamModel getByID(Long teamId) {
			return tRepo.findById(teamId).orElse(null);
		}
		
	//=================== DELETE==================
		
		public void deleteTeam(Long deleteID) {
			this.tRepo.deleteById(deleteID);
		}
		

	
}

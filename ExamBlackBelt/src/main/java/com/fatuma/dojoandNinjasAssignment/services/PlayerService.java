package com.fatuma.dojoandNinjasAssignment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fatuma.dojoandNinjasAssignment.model.PlayerModel;
import com.fatuma.dojoandNinjasAssignment.model.TeamModel;
import com.fatuma.dojoandNinjasAssignment.model.UserModel;
import com.fatuma.dojoandNinjasAssignment.repositories.PlayerRepo;

@Service

public class PlayerService {
	
	@Autowired
	private PlayerRepo pRepo;
	
	public PlayerModel createPlayer(PlayerModel newPlayer, UserModel newUser,TeamModel newTeam) {
//		
//		if(this.pRepo.count() >=9) {
//			return this.pRepo.save(newPlayer);
//			
//		}
		
			newPlayer.setUserPlayer(newUser);

			newPlayer.setTeamPlayer(newTeam);

		
			return this.pRepo.save(newPlayer);

			
		}
		
		
//		this.pRepo.count();
//		
//		System.out.print(this.pRepo.count());
		
	
		
		
	}
	
	
	
	


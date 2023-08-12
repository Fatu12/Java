package com.fatuma.dojoandNinjasAssignment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatuma.dojoandNinjasAssignment.model.GameMechanicModel;
import com.fatuma.dojoandNinjasAssignment.model.GameModel;

import com.fatuma.dojoandNinjasAssignment.model.UserModel;
import com.fatuma.dojoandNinjasAssignment.repositories.GameMechanicRepo;

@Service
public class GameMechanicService {
	
	@Autowired
	private GameMechanicRepo mRepo;
	
	
	public GameMechanicModel createGameMechanic(GameMechanicModel newGameMechanic, UserModel newUser,GameModel newGame) {

		newGameMechanic.setUserMechanic(newUser);
		newGameMechanic.setGameMechanic(newGame);

			return this.mRepo.save(newGameMechanic);

			
		}

}

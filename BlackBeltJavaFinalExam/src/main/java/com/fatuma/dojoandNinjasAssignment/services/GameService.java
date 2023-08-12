package com.fatuma.dojoandNinjasAssignment.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatuma.dojoandNinjasAssignment.model.GameModel;
import com.fatuma.dojoandNinjasAssignment.repositories.GameRepo;

@Service

public class GameService {
	@Autowired
	private GameRepo gRepo;
	

	public GameModel createGame(GameModel newGame) {
		
		 return this.gRepo.save(newGame);
		
	}
		
		public List<GameModel> getAll(){
			List<String> names = new ArrayList<>();
			Collections.sort(names);
			
			return this.gRepo.findAll();
		}
		
		//======================== Update =====================
		
		public GameModel updateGame(GameModel updatedGame) {
			return gRepo.save(updatedGame);
		}
		
		//====================== FIND BY ID ==========================
		
		public GameModel getByID(Long gameId) {
			return gRepo.findById(gameId).orElse(null);
		}
		
	//=================== DELETE==================
		
		public void deleteGame(Long deleteID) {
			this.gRepo.deleteById(deleteID);
		}
		
		public void sortNames(List<GameModel> games) {
	        Collections.sort(games, (game1, game2) -> game1.getName().compareTo(game2.getName()));
	    }

//		 public List<GameModel> getAllGameMyOrder(String  name) {
//			return this.gRepo.findByNameOrderByName(name);
//			
//		}
}

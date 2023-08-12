package com.fatuma.dojoandNinjasAssignment.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.fatuma.dojoandNinjasAssignment.model.GameModel;


public interface GameRepo extends CrudRepository<GameModel,Long>{
	List<GameModel> findAll();
//	List<GameModel> findByNameOrderByName(String game);
	
	

}
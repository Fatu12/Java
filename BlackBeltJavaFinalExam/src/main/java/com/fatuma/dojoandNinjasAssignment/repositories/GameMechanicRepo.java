package com.fatuma.dojoandNinjasAssignment.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.fatuma.dojoandNinjasAssignment.model.GameMechanicModel;

public interface GameMechanicRepo  extends CrudRepository<GameMechanicModel,Long>{
	List<GameMechanicModel> findAll();
	
}



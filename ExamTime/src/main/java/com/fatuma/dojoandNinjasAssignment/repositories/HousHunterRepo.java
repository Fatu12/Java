package com.fatuma.dojoandNinjasAssignment.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fatuma.dojoandNinjasAssignment.model.HouseHunterModel;


public interface HousHunterRepo extends CrudRepository<HouseHunterModel,Long>{
	List<HouseHunterModel> findAll();
	

}
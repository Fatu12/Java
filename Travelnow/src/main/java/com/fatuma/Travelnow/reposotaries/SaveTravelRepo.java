package com.fatuma.Travelnow.reposotaries;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fatuma.Travelnow.models.SaveTravelModel;



public interface SaveTravelRepo  extends CrudRepository<SaveTravelModel,Long>{
	List<SaveTravelModel> findAll();
	

}



package com.fatuma.dojoandNinjasAssignment.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fatuma.dojoandNinjasAssignment.model.DormModel;

public interface DormRepo extends CrudRepository<DormModel,Long>{
	List<DormModel> findAll();
	

}
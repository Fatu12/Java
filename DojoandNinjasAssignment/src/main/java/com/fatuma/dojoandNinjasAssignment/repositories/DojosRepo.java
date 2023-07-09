package com.fatuma.dojoandNinjasAssignment.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fatuma.dojoandNinjasAssignment.model.DojosModel;

public interface DojosRepo extends CrudRepository<DojosModel,Long>{
	List<DojosModel> findAll();
}
	

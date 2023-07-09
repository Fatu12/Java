package com.fatuma.dojoandNinjasAssignment.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fatuma.dojoandNinjasAssignment.model.NinjaModel;

public interface NinjasRepo  extends CrudRepository<NinjaModel,Long>{
	List<NinjaModel> findAll();
}
	
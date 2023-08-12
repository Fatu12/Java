package com.fatuma.dojoandNinjasAssignment.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fatuma.dojoandNinjasAssignment.model.TeamModel;

public interface TeamRepo  extends CrudRepository<TeamModel,Long>{
	List<TeamModel> findAll();
}
package com.fatuma.dojoandNinjasAssignment.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.fatuma.dojoandNinjasAssignment.model.ProjectsModels;
import com.fatuma.dojoandNinjasAssignment.model.UserModel;


public interface ProjectRepo extends CrudRepository<ProjectsModels,Long>{
	List<ProjectsModels> findAll();
//	
//	List<ProjectsModels> findAllByTeamMembersNotContains(UserModel user);



}
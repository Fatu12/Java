package com.fatuma.dojoandNinjasAssignment.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fatuma.dojoandNinjasAssignment.model.ProjectModel;
import com.fatuma.dojoandNinjasAssignment.model.UserModel;



public interface ProjectRepo extends CrudRepository<ProjectModel,Long>{
	List<ProjectModel> findAll();
	List<ProjectModel> findAllByTeamMembershipNotContains(UserModel user);
}
	
package com.fatuma.BookBroker.repositores;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fatuma.BookBroker.models.ProjectModel;
import com.fatuma.BookBroker.models.UserModel;

public interface ProjectRepo extends  CrudRepository<ProjectModel,Long>{
	List<ProjectModel> findAll();
	List<ProjectModel> findAllByTeamMembersNotContains(UserModel user);
	
}


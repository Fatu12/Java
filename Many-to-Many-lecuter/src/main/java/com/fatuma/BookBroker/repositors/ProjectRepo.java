package com.fatuma.BookBroker.repositors;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.fatuma.BookBroker.models.ProjectModel;
import com.fatuma.BookBroker.models.UserModel;

public interface ProjectRepo extends CrudRepository<ProjectModel,Long>{
	List<ProjectModel> findAll();
	
	
	// we want that the user is not member of it,for this reason we need to pass 
	// user Object
	List<ProjectModel> findAllByTeamMembersNotContains(UserModel user);
	
	
	
	
	

}
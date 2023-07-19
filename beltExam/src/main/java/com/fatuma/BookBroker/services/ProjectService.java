package com.fatuma.BookBroker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatuma.BookBroker.models.ProjectModel;
import com.fatuma.BookBroker.models.UserModel;
import com.fatuma.BookBroker.repositores.ProjectRepo;

@Service
public class ProjectService {
	
	//============================= ACCESS REPO=========================
	
	@Autowired 
	private ProjectRepo pRespo;
	
	
	
	//================================ GET ALL ======================
	
	public List<ProjectModel> getAll(){
		return this.pRespo.findAll();
	}
	
	
	//=============================== CREATE ======================
	
	public ProjectModel createProjocts(ProjectModel newProj, UserModel user) {
		newProj.setCreator(user);
		return this.pRespo.save(newProj);
		
	}
	
	//==========================  UPDATE ======================
	
	
	public ProjectModel updateProjocts(ProjectModel updatedProj) {
		// you ca n do it in controller tooo 
		ProjectModel oldProj = this.getByID(updatedProj.getId());
		updatedProj.setCreator(oldProj.getCreator());
		return this.pRespo.save(updatedProj);

	}
	
	
	
	//================================= GET BY ID==========================
	
	public ProjectModel getByID(Long projectID) {
		return this.pRespo.findById(projectID).orElse(null);
		
	}
	
	public void deleteProject(Long deleteID) {
	 this.pRespo.deleteById(deleteID);
	}
	public ProjectModel joinTeam(ProjectModel proj, UserModel users) {
		//we can pass the id to join as well as objects 
		proj.getTeamMembers().add(users);
		return this.pRespo.save(proj);
	
		
	}

	public ProjectModel unJoinTeam(ProjectModel proj, UserModel users) {
	
		//we can pass the id to join as well as objects 
		proj.getTeamMembers().remove(users);
		// save the thing  that pass to it
		return this.pRespo.save(proj);
	
		
	}
	
	public List<ProjectModel> getAllWithoutMember( UserModel user){
		return this.pRespo.findAllByTeamMembersNotContains(user);
		
		
	}
	

}

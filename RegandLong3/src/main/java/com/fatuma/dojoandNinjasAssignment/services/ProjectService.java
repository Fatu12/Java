package com.fatuma.dojoandNinjasAssignment.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatuma.dojoandNinjasAssignment.model.ProjectsModels;
import com.fatuma.dojoandNinjasAssignment.model.UserModel;
import com.fatuma.dojoandNinjasAssignment.repositories.ProjectRepo;
import com.fatuma.dojoandNinjasAssignment.repositories.UserRepo;

@Service

public class ProjectService {
	
	@Autowired
	private ProjectRepo pRepo;
	
	@Autowired
	private UserRepo uRepo;

	//============================ GET ALL ========================

	public List<ProjectsModels> getAll(){
		return this.pRepo.findAll();
	}
	
//================================ Create ===========================
	
	public ProjectsModels createProjects(ProjectsModels newProject) {
		
		// we want the creator to be teamMember my deafult
	
		return this.pRepo.save(newProject);
	}
	//================================ Create ===========================
	
	public ProjectsModels updateProjects(ProjectsModels updatedProject) {
		ProjectsModels oldProject = this.getById(updatedProject.getId());
		updatedProject.setCreator(oldProject.getCreator());
		return this.pRepo.save(updatedProject);
	}
		//============================ GET BY ID =========================
		
		public ProjectsModels  getById(Long projectId) {
			return this.pRepo.findById(projectId).orElse(null);
		}
		
		public void deleteProject(Long deleteProjId) {
			this.pRepo.deleteById(deleteProjId);
		}
		
//		public List< ProjectsModels> getWithOutMember(UserModel user) {
//			return this.pRepo.findAllByTeamMembersNotContains(user);
//			
//		}
//		
//	

}

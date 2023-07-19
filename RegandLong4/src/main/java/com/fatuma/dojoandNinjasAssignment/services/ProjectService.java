package com.fatuma.dojoandNinjasAssignment.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatuma.dojoandNinjasAssignment.model.ProjectModel;
import com.fatuma.dojoandNinjasAssignment.model.UserModel;
import com.fatuma.dojoandNinjasAssignment.repositories.ProjectRepo;
import com.fatuma.dojoandNinjasAssignment.repositories.UserRepo;



@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepo pRepo;
	
	@Autowired
	private UserRepo uRepo;
	
	//===================== CREATE ===========
	

	public ProjectModel createProject(ProjectModel newPro, UserModel user) {
		newPro.setCreatore(user);
		return this.pRepo.save(newPro);
	
		
		
	}
		
		public List<ProjectModel> getAll(){
			
			return this.pRepo.findAll();
		}
			
		
		//======================== Update =====================
		
		public ProjectModel updateProject(ProjectModel updatedProject) {
			 return this.pRepo.save(updatedProject);

		}
		
		//====================== FIND BY ID ==========================
		
		public ProjectModel getByID(Long projectID) {
			return pRepo.findById(projectID).orElse(null);
		}
		
	//=================== DELETE==================
		
		public void deleteProject(Long deleteID) {
			this.pRepo.deleteById(deleteID);
		}
		
		
		public ProjectModel joinTeamProject(ProjectModel joinedProject, UserModel user) {		
					joinedProject.getTeamMemberSHip().add(user);
					return this.pRepo.save(joinedProject);
			
	}
		
		public ProjectModel unJoinTeamProject(ProjectModel joinedProject, UserModel user) {		
			joinedProject.getTeamMemberSHip().remove(user);
						return this.pRepo.save(joinedProject);
				
		}
		
		
		
		public List<ProjectModel> getAllwithoutTeamMember(UserModel user) {
			return this.pRepo.findAllByTeamMemberSHipNotContains(user);
			
		}
}

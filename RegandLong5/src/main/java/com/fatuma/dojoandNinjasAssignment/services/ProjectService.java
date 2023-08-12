package com.fatuma.dojoandNinjasAssignment.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fatuma.dojoandNinjasAssignment.model.ProjectModel;
import com.fatuma.dojoandNinjasAssignment.model.UserModel;
import com.fatuma.dojoandNinjasAssignment.repositories.ProjectRepo;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepo pRepo;
	
	//===================== CREATE =========================
	// Since we want when we create we want to add the list of the creator we need to pass the
	// user object
	
	
	public ProjectModel createProject(ProjectModel newPro, UserModel user) {
		newPro.setCreatore(user);
		
		 return this.pRepo.save(newPro);	
		
	}
		
		public List<ProjectModel> getAll(){
			
			return this.pRepo.findAll();
		}
			

		//======================== Update =====================
		
		public ProjectModel updateProject(ProjectModel updatedProject) {
			return pRepo.save(updatedProject);
		}
		
		//====================== FIND BY ID ==========================
		
		public ProjectModel getByID(Long bookID) {
			return pRepo.findById(bookID).orElse(null);
		}
	
	//=================== DELETE==================
		
		public void deleteProject(Long deleteID) {
			this.pRepo.deleteById(deleteID);
		}
		
		public ProjectModel joinTeam(ProjectModel proj , UserModel user) {
			
			proj.getTeamMembership().add(user);
			return this.pRepo.save(proj);
		}
					
		public ProjectModel unJoinTeam(ProjectModel proj , UserModel user) {
			
			proj.getTeamMembership().remove(user);
			return this.pRepo.save(proj);
		}
			
		public List<ProjectModel> getAllWithoutProject( UserModel user) {
			return this.pRepo.findAllByTeamMembershipNotContains(user);
			
		}
}

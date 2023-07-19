package com.fatuma.BookBroker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatuma.BookBroker.models.ProjectModel;
import com.fatuma.BookBroker.models.UserModel;
import com.fatuma.BookBroker.repositors.ProjectRepo;

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
			System.out.println(updatedProject);
			ProjectModel oldProj = this.getByID(updatedProject.getId());
			updatedProject.setCreatore(oldProj.getCreatore());

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
		
		
		//==================JOIN TEAM===================================
		
		
		// since we joining the team we need to have an user and team objects, beacuse user is who are going 
		// to join the team and athe team are the project, so both are need it here 
		// or we can use that user and projecct id as well 
		
		
		public ProjectModel joinTeam(ProjectModel proj,UserModel users) {
			proj.getTeamMembers().add(users);
			// it going to update both list for us and return them 
			 return this.pRepo.save(proj);
			
		}
		
		public void unjoinTeam(ProjectModel proj,UserModel users) {
			proj.getTeamMembers().remove(users);
			System.out.println(proj.getTeamMembers().remove(users));
			// it going to update both list for us
			this.pRepo.save(proj);
			
		}
		
		// get user that is not member of any team so, just pass the user object not project object , there is not team 
		// without user
		public List<ProjectModel> getProjectWithoutMember(UserModel user){
			return this.pRepo.findAllByTeamMembersNotContains(user);
			
			
		}
		
		
		
		
		
		
		
		
		
	

}

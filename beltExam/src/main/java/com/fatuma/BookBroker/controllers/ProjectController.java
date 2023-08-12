package com.fatuma.BookBroker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fatuma.BookBroker.models.ProjectModel;
import com.fatuma.BookBroker.models.UserModel;
import com.fatuma.BookBroker.services.ProjectService;
import com.fatuma.BookBroker.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	private ProjectService pService;
	
	@Autowired
	private UserService uService;
	@GetMapping("/new")
	public String createForm(@ModelAttribute("newProject")ProjectModel newProject,HttpSession session) {
		
		return "createProject.jsp";
	}
	//================================= CREATE THIS PROJECT ==============================
	@PostMapping("/create")
	public  String createProject(@Valid @ModelAttribute("newProject")ProjectModel newProject, BindingResult result ,HttpSession session) {

			
		
		if(result.hasErrors()) {
			return "createProject.jsp";
		}
			System.out.println(newProject);
			System.out.println(newProject.getDescription());
			System.out.println(newProject.getTitle());
			System.out.println(newProject.getDuaDate());
			
			// tie user upand ont the project creater , we now the user is in the session.
//			newProject.setCreator(this.uService.findById((long)session.getAttribute("userID")));

			System.out.println(newProject.getCreator());
			 UserModel currentUser = this.uService.findById((long)session.getAttribute("userID"));
			this.pService.createProjocts(newProject, currentUser);
			
		return "redirect:/project/join/" + newProject.getId() ;
	}
	
	@GetMapping("/edit/{updateID}")
	public String updateForm(@PathVariable("updateID")Long updateID , Model viewModel,
			HttpSession session) {
		viewModel.addAttribute("updatedProject",this.pService.getByID(updateID));
		System.out.println(updateID);
		this.pService.getByID(updateID);	
		return "edit.jsp";
	}
	@PostMapping("/update/{id}")
	public String updateProject(@Valid @ModelAttribute("updatedProject")ProjectModel updatedModel,BindingResult result,
			HttpSession session) {
			
			if(result.hasErrors()) {
	
				
				return "edit.jsp";
			}
			
			// in spring if we don't porved all the infromation we going to lose the data, that means 
			// if we don't reset it going  to los the logged in your that associated with
//		updatedModel.setCreator(this.uService.findById((long)session.getAttribute("userID")));
			this.pService.updateProjocts(updatedModel);
			return "redirect:/users/home";
	}

// ============================================ DELETE====================================


		@GetMapping("/delete/{deleteID}")
		public String deleteProject(@PathVariable("deleteID")Long deleteId,Model viewModel,HttpSession session ) {
			viewModel.addAttribute("user",this.uService.findById((long)session.getAttribute("userID")));
			
			this.pService.deleteProject(deleteId);
			System.out.println(deleteId);
		
			return "redirect:/users/home";
		}
		// since the user who logged in is the one who is goig to login we don't need to pass that that our method, 
		// we can get it from the session.
		@GetMapping("/join/{joinId}")
	    public String  joinTeam(@PathVariable("joinId") Long projectID,HttpSession session) {
			Long currrentUserID = (Long)session.getAttribute("userID");
			if(currrentUserID == null) {
				return "redirect:/";
		}
			
			this.pService.joinTeam(this.pService.getByID(projectID), this.uService.findById(currrentUserID));
			
			return "redirect:/users/home";
		
	}
		@GetMapping("/unjoin/{joinId}")
		public String  unjoinTeam(@PathVariable("joinId") Long projectID,HttpSession session) {
			Long currrentUserID = (Long)session.getAttribute("userID");
			if(currrentUserID == null) {
				return "redirect:/";
		}
			
			this.pService.unJoinTeam(this.pService.getByID(projectID), this.uService.findById(currrentUserID));
			
			return "redirect:/users/home";
		
	}
}

package com.fatuma.dojoandNinjasAssignment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fatuma.dojoandNinjasAssignment.model.ProjectModel;
import com.fatuma.dojoandNinjasAssignment.model.UserModel;
import com.fatuma.dojoandNinjasAssignment.services.ProjectService;
import com.fatuma.dojoandNinjasAssignment.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/projects")
public class ProjectController {
	@Autowired
	private ProjectService pService;
	
	@Autowired
	private UserService uService;
	
	@GetMapping("/new")

	public String createForm(@ModelAttribute("newProject")ProjectModel newProject) {

		return "createProject.jsp";	
				
	}
	
	
	@PostMapping("/create")
	private String addProject(@Valid @ModelAttribute("newProject")ProjectModel newProject, BindingResult result, HttpSession session) {
		// when we printed out we have null value the value get display after we validate 
		if(result.hasErrors()) {
			return "createProject.jsp";
		}
		 
		
		 System.out.println(newProject);
		 System.out.println(newProject.getTitle());
		 System.out.println(newProject.getComment());
		 System.out.println(newProject.getDuaDate());
		 System.out.println(newProject.getCreatore());
		 
//		 UserModel currentUser = this.uService.findById((Long)session.getAttribute("userID"));

		 newProject.setCreatore(this.uService.findById((Long)session.getAttribute("userID")));
		 this.pService.createProject(newProject, this.uService.findById((Long)session.getAttribute("userID")));
		 	
		 
		return "redirect:/projects/join/" + newProject.getId() ;
	}
	 
	@GetMapping("/edit/{projectId}")
	public String projectEditForm(@PathVariable("projectId")Long ProjeID, Model viewModel) {
		viewModel.addAttribute("updateProject", this.pService.getByID(ProjeID));
		return "editProject.jsp";
		
	}
	
	@PostMapping("/update/{id}")
	public String projectEditPost(@Valid @ModelAttribute("updateProject") ProjectModel updatedPorject, BindingResult result,
			HttpSession session ) {
	
		if(result.hasErrors()) {
			return "editProject.jsp";
		}
		
		updatedPorject.setCreatore(this.uService.findById((Long)session.getAttribute("userID")));


		this.pService.updateProject(updatedPorject);
		return "redirect:/users/home";
	}

	@GetMapping("/delete/{deleteId}")
    public String destroy(@PathVariable("deleteId") Long ProjDeleteId,HttpSession session ,Model viewModel) {
		
	this.pService.deleteProject(ProjDeleteId);
	 System.out.println(ProjDeleteId);
	 return "redirect:/users/home";
       
	}
	
	@GetMapping("/{oneId}")
	public String displayOne(@PathVariable("oneId")Long oneID,HttpSession session ,Model viewModel) {
		 
		viewModel.addAttribute("ProjectDetails", this.pService.getByID(oneID));
		return "displayOne.jsp";
		
	}
	
	@GetMapping("/join/{projId}")
	public String joinProject(@PathVariable("projId")Long projID, HttpSession session) {
		Long currrentUserID = (Long)session.getAttribute("userID");
		
		if (currrentUserID == null) {
			return "redirect:/";
		}
		
		// in our join we need to pass the project object to the join team method
		this.pService.joinTeamProject(this.pService.getByID(projID), this.uService.findById(currrentUserID));
		return "redirect:/users/home";
	}
	@GetMapping("/unjoin/{projId}")
	public String unJoinProject(@PathVariable("projId")Long projID, HttpSession session) {
		Long currrentUserID = (Long)session.getAttribute("userID");
		
		if (currrentUserID == null) {
			return "redirect:/";
		}
		
		// in our join we need to pass the project object to the join team method
		this.pService.joinTeamProject(this.pService.getByID(projID), this.uService.findById(currrentUserID));
		return "redirect:/users/home";
	}
	
}

	
	
	
	
	
	
	


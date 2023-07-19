package com.fatuma.dojoandNinjasAssignment.controllers;

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

import com.fatuma.dojoandNinjasAssignment.model.ProjectModel;
import com.fatuma.dojoandNinjasAssignment.services.ProjectService;
import com.fatuma.dojoandNinjasAssignment.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;



@Controller
@RequestMapping("/projects")
public class ProjectController {
	@Autowired
	private UserService uService; 
	
	@Autowired
	private ProjectService pService;
	
	
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
//	 newProject.setCreatore(this.uService.findById((long)session.getAttribute("userID")));
		// in many to many that the list is not going to create untill it redirects
		 
		
		 System.out.println(newProject);
		 System.out.println(newProject.getTitle());
		 System.out.println(newProject.getComment());
		 System.out.println(newProject.getDuaDate());
		 System.out.println(newProject.getCreatore());
//		 Long userId =(long) session.getAttribute("userID");
		 // when you make new varable make check the data type
//		 UserModel currentUser = this.uService.findById(userId);
		 
		 // create going to take project from the form and user object
		 
//		newProject.setCreatore(this.uService.findById((long)session.getAttribute("userID")));
		this.pService.createProject(newProject,this.uService.findById((long)session.getAttribute("userID")));
		

		return "redirect:/projects/join/" + newProject.getId();
	}
	

	@GetMapping("/edit/{projectID}")
	public String projectEditForm(@PathVariable("projectID")Long ProjeID, Model viewModel) {
		viewModel.addAttribute("projectToEdit", this.pService.getByID(ProjeID));
		return "edit.jsp";
		
	}
	
	@PutMapping("/update/{id}")
	public String projectEditPost(@Valid @ModelAttribute("projectToEdit") ProjectModel editPorject, BindingResult result,
			HttpSession session ) {
	
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		// inseade of doing here we have done the same contoller in our service
	editPorject.setCreatore(this.uService.findById((long)session.getAttribute("userID")));

		this.pService.updateProject(editPorject);
		return "redirect:/users/home";
	}
	
	@GetMapping("/delete/{deleteId}")
    public String destroy(@PathVariable("deleteId") Long projId,HttpSession session ,Model viewModel) {
	
	this.pService.deleteProject(projId);
	 System.out.println(projId);
	 return "redirect:/users/home";

       
    }
	@GetMapping("/join/{joinId}")
	public String joinproject(@PathVariable("joinId")Long joinID, HttpSession session) {
		this.pService.joinTeam(this.pService.getByID(joinID),this.uService.findById((Long)session.getAttribute("userID")));
		 return "redirect:/users/home";
		
	}
	
	@GetMapping("/unjoin/{joinId}")
	public String unJoinproject(@PathVariable("joinId")Long joinID, HttpSession session) {
		this.pService.unJoinTeam(this.pService.getByID(joinID), this.uService.findById((Long)session.getAttribute("userID")));
		 return "redirect:/users/home";
		
	}
//	@GetMapping("/{oneID}")
//	public String show(@PathVariable("oneID")Long oneID, Model viewModel, HttpSession session) {
//	// datialDojos is how to pass to jsp file  to display the info in the
//	
//	
//	viewModel.addAttribute("showBook",this.pService.getByID(oneID));
//	UserModel user = this.uService.findById((Long)session.getAttribute("userID"));
//	viewModel.addAttribute("user", user);
//	
//	return "bookId.jsp";
//	}
	


}

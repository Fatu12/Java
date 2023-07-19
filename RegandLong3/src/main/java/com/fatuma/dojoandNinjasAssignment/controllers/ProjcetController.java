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

import com.fatuma.dojoandNinjasAssignment.model.ProjectsModels;

import com.fatuma.dojoandNinjasAssignment.services.ProjectService;
import com.fatuma.dojoandNinjasAssignment.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/projects")

public class ProjcetController {
	
	@Autowired
	private ProjectService pService;
	
	@Autowired
	private UserService uService;
	

	@GetMapping("/new")
	public String createForm(@ModelAttribute("newProjects") ProjectsModels newProject,HttpSession sessio ) {
		 	
		return "createProject.jsp";
			
	}
	
	@PostMapping("/create")
	public String createProjects(@Valid @ModelAttribute("newProjects")ProjectsModels newProject,BindingResult result ,HttpSession session) {
		if(result.hasErrors()) {
			
			return "createProject.jsp";
		}
		System.out.println(newProject);
		System.out.println(newProject.getDescription());
		System.out.println(newProject.getTitle());
		System.out.println(newProject.getDuaDate());

		
		this.pService.createProjects(newProject);
		newProject.setCreator(this.uService.findById((long)session.getAttribute("userID")));
		System.out.println(newProject.getCreator());

			return "redirect:/users/home";
		}
	
		@GetMapping("/edit/{editID}")
		public String editForm(@PathVariable("editID")Long editId, Model viewModel) {
			
			viewModel.addAttribute("updatedProject", this.pService.getById(editId));
			return "edit.jsp";
		}
			
		@PostMapping("/update/{id}")
		public String updateProject(@Valid @ModelAttribute("updatedProject")ProjectsModels updatedProject ,BindingResult result ,HttpSession session) {
			if(result.hasErrors()) {
				return "edit.jsp";
			}
//			updatedProject.setCreator(this.uService.findById((long)session.getAttribute("userID")));
			this.pService.updateProjects(updatedProject);

			 return "redirect:/users/home";
		}
		@GetMapping("/delete/{deletId}")
		public String deleteProject(@PathVariable("deletId")Long Id , Model viewModel,HttpSession session) {
			Long currentUserID = (long)session.getAttribute("userID");
			
		viewModel.addAttribute("user", this.uService.findById(currentUserID));
			
			this.pService.deleteProject(Id);
			return "redirect:/users/home";
			
			
		}

		}
		
	
	

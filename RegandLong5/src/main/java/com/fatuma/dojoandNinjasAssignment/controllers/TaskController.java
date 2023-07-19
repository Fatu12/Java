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

import com.fatuma.dojoandNinjasAssignment.model.TaskModel;
import com.fatuma.dojoandNinjasAssignment.model.UserModel;
import com.fatuma.dojoandNinjasAssignment.services.ProjectService;
import com.fatuma.dojoandNinjasAssignment.services.TasksService;
import com.fatuma.dojoandNinjasAssignment.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/tasks")

public class TaskController {
	
	@Autowired
	private ProjectService pService;
	
	@Autowired
	private UserService uService;
	@Autowired
	private TasksService tService;
	
//	@GetMapping("/{taskId}")
//	public String createForm(@PathVariable("taskId")Long taskID,
//			@ModelAttribute("newTask")TaskModel newTask,Model viewModel) {
//		viewModel.addAttribute("thisProjects", this.pService.getByID(taskID));
//
//		return "newTask.jsp";	
//				
//	}
//	@PostMapping("/create/{projId}")
//	public String createTask(@Valid @ModelAttribute("newTask")TaskModel newTask, BindingResult result,Model viewModel,
//			 @PathVariable("projId")Long projId, HttpSession session) {
//		if(result.hasErrors()) {
//			viewModel.addAttribute("thisProjects", this.pService.getByID(projId));
//
//			return "newTask.jsp";
//		}
//		
//		UserModel currentUser = this.uService.findById((Long)session.getAttribute("userID"));
//		this.tService.createTask(newTask, currentUser, this.pService.getByID(projId));
//		return"redirect:/tasks/{projId}";
//		
//	}
	@GetMapping("/{projectId}")
	public String taskCreaterForm(@PathVariable("projectId")Long projId, @ModelAttribute("newTask")TaskModel newTask,Model viewModel) {
			viewModel.addAttribute("thisProject", this.pService.getByID(projId));
		     return "newTask.jsp";	
			
	}
	
	@PostMapping("/create/{projectId}")
	public String createTask(@Valid @ModelAttribute("newTask")TaskModel newTask, BindingResult result
			, Model viewModel,@PathVariable("projectId")Long projId,HttpSession session) {
		
		if(result.hasErrors()) {
			viewModel.addAttribute("thisProject", this.pService.getByID(projId));

			return "newTask.jsp";
		}
		 // when you make new varable make check the data type
		 UserModel currentUser = this.uService.findById((long)session.getAttribute("userID"));
		this.tService.createTask(newTask, currentUser, this.pService.getByID(projId));
		
		return "redirect:/tasks/{projectId}";
	}
	

}

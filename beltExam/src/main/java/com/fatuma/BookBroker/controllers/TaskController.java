package com.fatuma.BookBroker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fatuma.BookBroker.models.TaskModel;
import com.fatuma.BookBroker.models.UserModel;
import com.fatuma.BookBroker.services.ProjectService;
import com.fatuma.BookBroker.services.TaskService;
import com.fatuma.BookBroker.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("tasks")

public class TaskController {
	@Autowired
	private ProjectService pService;
	@Autowired
	private TaskService tService;
	@Autowired
	private UserService uService;
//	@GetMapping("/{taskId}")
//	public String createForm(@ModelAttribute("newTask")TaskModel newTask,@PathVariable("taskId")Long taskId,Model viewModel,HttpSession session) {
//		
//		viewModel.addAttribute("thisProjectTask", this.pService.getByID(taskId));
//		
//		return "task.jsp";
//	}
//	//================================= CREATE THIS PROJECT ==============================
//	@PostMapping("/create/{taskId}")
//	public  String createProject(@Valid @ModelAttribute("newProject")TaskModel newTask, BindingResult result ,@PathVariable("taskId")Long taskId, HttpSession session) {
//		
//	
//	if(result.hasErrors()) {
//			return "createProject.jsp";
//		}
//	 UserModel currentUser = this.uService.findById((long)session.getAttribute("userID"));
//		
//		this.tService.createTask(newTask, currentUser,this.pService.getByID(taskId));
//
//		return "redirect:/tasks/{projectId}";
//	}}
	@GetMapping("/{projectId}")
	public String taskCreaterForm(@PathVariable("projectId")Long projId, @ModelAttribute("newTask")TaskModel newTask,Model viewModel) {
			viewModel.addAttribute("thisProject", this.pService.getByID(projId));
		     return "task.jsp";	
			
	}
	
	@PostMapping("/create/{projectId}")
	public String createTask(@Valid @ModelAttribute("newTask")TaskModel newTask, BindingResult result
			, Model viewModel,@PathVariable("projectId")Long projId,HttpSession session) {
		
		if(result.hasErrors()) {
			viewModel.addAttribute("thisProject", this.pService.getByID(projId));

			return "task.jsp";
		}
		 // when you make new varable make check the data type
		 UserModel currentUser = this.uService.findById((long)session.getAttribute("userID"));
		this.tService.createTask(newTask, currentUser, this.pService.getByID(projId));
		
		return "redirect:/tasks/{projectId}";
	}
}



package com.fatuma.dojoandNinjasAssignment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fatuma.dojoandNinjasAssignment.model.DormModel;
import com.fatuma.dojoandNinjasAssignment.model.StudentsModel;
import com.fatuma.dojoandNinjasAssignment.services.DormService;
import com.fatuma.dojoandNinjasAssignment.services.StudentsService;
import com.fatuma.dojoandNinjasAssignment.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/students")

public class StudentsController {
	
	@Autowired
	private DormService dService;
	
	@Autowired 
	 private UserService uService;
	
	@Autowired
	private StudentsService sService;
	

	@GetMapping("/new")
	
	public String  createForm(@ModelAttribute("newStudents")StudentsModel newStudent) {
		return  "createStudents.jsp";
	}

	
	@PostMapping("/create")
     public  String createStudent(@Valid @ModelAttribute("newStudents")StudentsModel newStudent, BindingResult result,Model viewModel, HttpSession session) {
		
		viewModel.addAttribute("listDorm", this.dService.getAll());
		// when we printed out we have null value the value get display after we validate 
		if(result.hasErrors()) {
			return "createStudents.jsp";
		}
//		newStudent.setCreator(this.uService.findById((long)session.getAttribute("userID")));
		// in many to many that the list is not going to create untill it redirects
		 
		 this.sService.createStudent(newStudent);
		 System.out.println(newStudent.getStudentName());
		 System.out.println(newStudent.getCreatedAt());
		 System.out.println(newStudent.getUpdatedAt());
		 
		 
		 	 
		return "redirect:/dorms";
	}
	
	

}

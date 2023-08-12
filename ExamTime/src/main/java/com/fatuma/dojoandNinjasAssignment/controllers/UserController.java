package com.fatuma.dojoandNinjasAssignment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fatuma.dojoandNinjasAssignment.model.UserModel;
import com.fatuma.dojoandNinjasAssignment.services.HouseHunterServices;
import com.fatuma.dojoandNinjasAssignment.services.UserService;
import com.fatuma.dojoandNinjasAssignment.validators.LoginValidator;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/users")

public class UserController {
	@Autowired
	private UserService uService; 
	
	
	@Autowired
	private HouseHunterServices hService;
	//============================= GET ALL ================================
	// bind empty bean to reg/login form
	@GetMapping("")
	public String index(@ModelAttribute("newUser")UserModel newUser, Model viewModel) {
//		viewModel.addAttribute("newUser", new UserModel());
		viewModel.addAttribute("loginUser", new LoginValidator());

		return "index.jsp";
				
	}
	//BindingResult like session, that going to hold infromation from service to our controller where we doing 
	//another check with a re-render
	
	// ====================== Register =====================
	// BindingResult that allows for automatically writing the form data into a new object that we bind to the JSP page using the view model, that is, the Model model that you're accustomed to using.

	 @PostMapping("/register")
	    public String register(@Valid @ModelAttribute("newUser") UserModel user, 
	            BindingResult result, Model model, HttpSession session) {
	        
		 // user is carries the value coming from the form 
		 // since we adding values , we have to call register
		 
		 // why do we need to inst again 
		 
		 // adding data to database
		 UserModel newestUser = this.uService.register(user, result);
	        
	        if(result.hasErrors()) {
	            // Be sure to send in the empty LoginUser before 
	            // re-rendering the page.
	 	       model.addAttribute("loginUser", new LoginValidator());
	            return "index.jsp";
	        }
	        // saving 
	        session.setAttribute("userID", newestUser.getId());
	     
	    
	        return "redirect:/users/home";
	    }
	   //======================== Login Method ==================
	 //that allows for automatically writing the form data into a new object that we bind to the JSP page using the view model, that is,
	 //the Model model that you're accustomed to using.
	 @PostMapping("/login")
	    public String login(@Valid @ModelAttribute("loginUser") LoginValidator newLogin, 
	            BindingResult result, Model model, HttpSession session) {
	        
	        // Add once service is implemented:
	         UserModel user = uService.login(newLogin, result);
	    
	        if(result.hasErrors()) {
	            model.addAttribute("newUser", new UserModel());

	            return "index.jsp";
	        }
	        session.setAttribute("userID", user.getId());

	        return "redirect:/users/home";
	    }
	    
	 @GetMapping("/home")
	 public String homeRoute(Model viewModel,HttpSession session ) {
		 Long userId =(long) session.getAttribute("userID");
		 viewModel.addAttribute("currentUser", this.uService.findById(userId));
		 viewModel.addAttribute("allHouseHunter",this.hService.getAll());
		 return "dashboard.jsp";
	 }
	 // THIS IS GOING TO CLEAR THE SESSION AND LOGOUT 
	 @GetMapping("/logout")
	 public String logout(HttpSession session) {
		 session.invalidate();
		 return "redirect:/users";
		 
		 
	 }
	 
	 
	 @GetMapping("/check")
	 public String check(Model viewModel,HttpSession session ) {
		 Long userId =(long) session.getAttribute("userID");
		 viewModel.addAttribute("currentUser", this.uService.findById(userId));
		 return "check.jsp";
	 
	 
	    
	 }
	

}

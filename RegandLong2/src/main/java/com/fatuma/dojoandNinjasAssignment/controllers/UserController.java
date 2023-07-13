package com.fatuma.dojoandNinjasAssignment.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fatuma.dojoandNinjasAssignment.model.BookModel;
import com.fatuma.dojoandNinjasAssignment.model.UserModel;
import com.fatuma.dojoandNinjasAssignment.services.BookService;
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
	private BookService bService;
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
	    
//	 @GetMapping("/home")
//		 public String homeRoute(Model viewModel,HttpSession session ) {
//			 Long userId =(long) session.getAttribute("userID");
//		 viewModel.addAttribute("currentUser", this.uService.findById(userId));
//			 return "dashboard.jsp";
//		 }
		 // THIS IS GOING TO CLEAR THE SESSION AND LOGOUT 
	 @GetMapping("/logout")
		 public String logout(HttpSession session,Model viewModel) {
			 session.invalidate();
			 return "redirect:/users";
		 
		 
	 }
	 @GetMapping("/home")
	 public String homeRoute(Model viewModel,HttpSession session ) {
		 if(this.uService.findById((long) session.getAttribute("userID"))== null) {
			 System.out.println("==========================");
				return "redirect:/users";
		 }
//			 List<BookModel> allBooks = this.bService.getAll();
//			 System.out.printf("!!!!!!!!!!!!!!!!!!!!!!!!!!!!! $s" ,allBooks);
			 Long userId =(long) session.getAttribute("userID");
			 System.out.println(userId);
			 viewModel.addAttribute("currentUser", this.uService.findById(userId));
			 viewModel.addAttribute("books", this.bService.getAll());
		 return "dashboard.jsp";
		 }
	 
		 
	 
	 //============================= GET ALL ==========================
//	 
//	 @GetMapping("/home")	
//		public String index(Model viewModel,HttpSession session) {
//		 
//		
//		 if(!(session.getAttribute("user_id") == null)) {
//			 viewModel.addAttribute("books", this.bService.getAll());
//		   viewModel.addAttribute("newUser", this.uService.findById((Long)session.getAttribute("userId")));
//				    	return "dashboard.jsp";
//			   }
//	    	
//		 	return "redirect:/users";
//	 }
	 
	 @RequestMapping("/book/new")
		 public  String renderBook(Model viewModel, HttpSession session) {
		 if((Long)session.getAttribute("userID")== null) {
			 return "redirect:/users";
			 
		 }
		 UserModel user = this.uService.findById((Long)session.getAttribute("userID"));
	    	viewModel.addAttribute("user", user);
	    	viewModel.addAttribute("newBook", new BookModel());
	    	viewModel.addAttribute("books", this.bService.getAll());
	    	return "CreateBook.jsp";
	    }
	 
//		 if(this.uService.findById((long) session.getAttribute("userID"))== null) {
//			 System.out.println("==========================");
//				return "redirect:/users";
//		 }
//			 viewModel.addAttribute("newBook", new BookModel());
//			 viewModel.addAttribute("books", this.bService.getAll());
//			 Long userId =(long) session.getAttribute("userID");
//			 System.out.println(userId);
//			 viewModel.addAttribute("currentUser", this.uService.findById(userId));
//		
//			 
//			 return "CreateBook.jsp";
//			 
//		 }
	 
	//=============================== CREATE===============================
	 
	@PostMapping("/create") 
			public String Createbooks(@Valid @ModelAttribute("newBook")BookModel newBooks, BindingResult result, Model viewModel,HttpSession session ) {
			if(result.hasErrors()) {
					return "CreateBook.jsp";
							}
				UserModel user = this.uService.findById((Long)session.getAttribute("userID"));
		    	viewModel.addAttribute("user", user);
		    	this.bService.createBooks(newBooks);
				return "redirect:/users/home";
				
	}
	
	//===================== GET BY ID======================

	@GetMapping("/{oneID}")
	public String show(@PathVariable("oneID")Long oneID, Model viewModel, HttpSession session) {
		// datialDojos is how to pass to jsp file  to display the info in the


		viewModel.addAttribute("showBook",this.bService.getByID(oneID));
		UserModel user = this.uService.findById((Long)session.getAttribute("userID"));
    	viewModel.addAttribute("user", user);

		return "bookId.jsp";
	
		 
	}
	
	@GetMapping("/{upateID}/edit")
	public String editRender(Model viewModel, @PathVariable("upateID")Long bookId,HttpSession session) {
				viewModel.addAttribute("bookEdit", this.bService.getByID(bookId));
				UserModel user = this.uService.findById((Long)session.getAttribute("userID"));
		    	viewModel.addAttribute("user", user);
				return "edit.jsp";
	}
	// always id has to come from the database we can't name anything else
	// and if we don't proved the id it going to create one
	
	@PostMapping("/update/{id}")
	public String updateBook(@Valid @ModelAttribute("bookEdit") BookModel updatedBook, BindingResult result, Model viewModel,HttpSession session ) {
		
		if(result.hasErrors()) {
			return "edit.jsp";
		
	}
		// this is going to save the changing without this is not show as the change

	
		UserModel user = this.uService.findById((Long)session.getAttribute("userID"));
    	viewModel.addAttribute("user", user);
    	this.bService.updateBook(updatedBook);
    	return "redirect:/users/home";
		
	}
	
	@GetMapping("/{deleteId}/delete")
    public String destroy(@PathVariable("deleteId") Long bookID,HttpSession session ,Model viewModel) {
		
	UserModel user = this.uService.findById((Long)session.getAttribute("userID"));
    viewModel.addAttribute("user", user);
	 bService.delete(bookID);
	 System.out.println(bookID);
        return "redirect:/users/home";
    }
	 }
 		    	
	 
	    
	
	

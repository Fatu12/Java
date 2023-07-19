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

import com.fatuma.BookBroker.models.BookModel;
import com.fatuma.BookBroker.models.UserModel;
import com.fatuma.BookBroker.services.BookService;
import com.fatuma.BookBroker.services.UserService;


import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/users/books")

public class BookController {
	
	@Autowired
	private BookService bService;
	
	@Autowired
	private UserService uService;
	
	
	@GetMapping("")
	public String homeRoute(Model viewModel,HttpSession session) {
		if(session.getAttribute("userID")== null) {
		 System.out.println("==========================");
				return "redirect:/users";
	}
		 
			Long userId =(long) session.getAttribute("userID");
			System.out.println(userId);
		viewModel.addAttribute("currentUser", this.uService.findById(userId));
			viewModel.addAttribute("allBooks", this.bService.getAll());
		
		System.out.println(viewModel.addAttribute("allBooks", this.bService.getAll()));
		return "displayAll.jsp";
	}
	
	
	@RequestMapping("/new")
	 public  String renderBook(Model viewModel, HttpSession session) {
//	 if((Long)session.getAttribute("userID")== null) {
//		 return "redirect:/users";
//		 
//	 }
//	 UserModel user = this.uService.findById((Long)session.getAttribute("userID"));
//   	viewModel.addAttribute("user", user);
   	viewModel.addAttribute("newBook", new BookModel());
   	viewModel.addAttribute("books", this.bService.getAll());
   
   	return "CreateBook.jsp";
    
	}
   	
		@PostMapping("/create") 
				public String Createbooks(@Valid @ModelAttribute("newBook")BookModel newBooks, BindingResult result, Model viewModel,HttpSession session ) {
				if(result.hasErrors()) {
						return "CreateBook.jsp";
								}
//					UserModel user = this.uService.findById((Long)session.getAttribute("userID"));
//			    	viewModel.addAttribute("user", user);
			    	this.bService.createBooks(newBooks);
					return "redirect:/users/books";
					
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
//					UserModel user = this.uService.findById((Long)session.getAttribute("userID"));
//			    	viewModel.addAttribute("user", user);
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
			
			
//			UserModel user = this.uService.findById((Long)session.getAttribute("userID"));
//			viewModel.addAttribute("user", user);
			this.bService.updateBook(updatedBook);
			return "redirect:/users/books";
			
			}
			
			@GetMapping("/{deleteId}/delete")
			public String destroy(@PathVariable("deleteId") Long bookID,HttpSession session ,Model viewModel) {
			
			UserModel user = this.uService.findById((Long)session.getAttribute("userID"));
			viewModel.addAttribute("user", user);
			bService.deleteBook(bookID);
			System.out.println(bookID);
			return "redirect:/users/home";
			}
			}
				    	
			
				
			    
		

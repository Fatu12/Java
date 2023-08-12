package com.fatuma.dojoandNinjasAssignment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fatuma.dojoandNinjasAssignment.model.BookModel;
import com.fatuma.dojoandNinjasAssignment.model.UserModel;
import com.fatuma.dojoandNinjasAssignment.services.BookService;
import com.fatuma.dojoandNinjasAssignment.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService bService;
	
	@Autowired UserService uService;
	
	@GetMapping("")
	public String getAllBooks(Model veiwModel,Model viewModel, HttpSession session) {
		veiwModel.addAttribute("allBooks", this.bService.getAll());
		Long userId =(long) session.getAttribute("userID");
		 viewModel.addAttribute("currentUser", this.uService.findById(userId));
		
		return "displayAllBook.jsp";
	}
	
	
	@GetMapping("/new")
	
	public String  createForm(@ModelAttribute("newBook")BookModel newBook,Model viewModel, HttpSession session) {
		Long userId =(long) session.getAttribute("userID");
		 viewModel.addAttribute("currentUser", this.uService.findById(userId));
		return  "createBook.jsp";
	}

	
	@PostMapping("/create")
     public  String createBook(@Valid @ModelAttribute("newBook")BookModel newBook, BindingResult result, HttpSession session) {
		
//		// when we printed out we have null value the value get display after we validate 
	if(result.hasErrors()) {
		return "createBook.jsp";
			
		}
	newBook.setCreatore(this.uService.findById((Long)session.getAttribute("userID")));
//		newBook.setCreator(this.uService.findById((long)session.getAttribute("userID")));
		// in many to many that the list is not going to create untill it redirects
		 
		 this.bService.createDorm(newBook);
	  newBook.setCreatore(this.uService.findById((Long)session.getAttribute("userID")));
		 System.out.println(newBook);
		 System.out.println(newBook.getAuthor());
		 System.out.println(newBook.getComment());
		 System.out.println(newBook.getUpdatedAt());
		 System.out.println(newBook.getCreatore());
		 
		return "redirect:/books";
	}
	
	@GetMapping("/edit/{bookID}")
	public String projectEditForm(@PathVariable("bookID")Long ProjeID, Model viewModel) {
		viewModel.addAttribute("bookToEdit", this.bService.getByID(ProjeID));
		return "edit.jsp";
		
	}
	
	@PutMapping("/update/{id}")
	public String projectEditPost(@Valid @ModelAttribute("projectToEdit") BookModel editBook, BindingResult result,
			HttpSession session ) {
	
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		// inseade of doing here we have done the same contoller in our service
		editBook.setCreatore(this.uService.findById((long)session.getAttribute("userID")));

		this.bService.updateDorm(editBook);
		return "redirect:/users/home";
	}
	
	@GetMapping("/delete/{deleteId}")
    public String destroy(@PathVariable("deleteId") Long projId,HttpSession session ,Model viewModel) {
	
	this.bService.deleteDorm(projId);
	 System.out.println(projId);
	 return "redirect:/users/home";

       
    }
	
	@GetMapping("/{oneID}")
	public String show(@PathVariable("oneID")Long oneID, Model viewModel, HttpSession session) {
	// datialDojos is how to pass to jsp file  to display the info in the
	
	
	viewModel.addAttribute("showBook",this.bService.getByID(oneID));
	UserModel userId = this.uService.findById((Long)session.getAttribute("userID"));
	viewModel.addAttribute("user", userId);
	
	return "displayOne.jsp";
	}
	
	
	@DeleteMapping("/delete/{deleteId}")
    public String deleteBook(@PathVariable("deleteId")Long bookID,Model viewModel, HttpSession session ) {
		
	UserModel user = this.uService.findById((Long)session.getAttribute("userID"));
    viewModel.addAttribute("user", user);
	 bService.deleteDorm(bookID);
	 System.out.println(bookID);
        return "redirect:/users/home";
    }
	 
	
	
	

}

package com.fatuma.bookAPIs.controllers;





import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



import com.fatuma.bookAPIs.models.Book;
import com.fatuma.bookAPIs.services.BookService.BookService;




@Controller

public class BookController {
	@Autowired
	private  BookService bookService;
	
	@RequestMapping("/books")
	
	public String home(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("book", books);
		return "displayAll.jsp";
				
	}
//	
//	public String (Model model) {
//        List<Book> books = bookService.allBooks();
//        model.addAttribute("books", books);
//        return "/books/index.jsp"
//	
	
	
//	public String index(Model model) {
//        List<Book> books = bookService.allBooks();
//        model.addAttribute("books", books);
//        return "/books/index.jsp"
//	
//	
	// know we want to get book out of the data base
	// Inseade of making a variable and putting into consturtor we can say{@Autowired} 
	
	// thus is giving us dependency injection
	

    @RequestMapping("/show/{bookId}")
    public String show(@PathVariable("bookId") Long id, Model model) {
    	System.out.println(id);
    	
    	// get id from database
    	Book book = bookService.getById(id);
//    	System.out.println(book);
    	model.addAttribute("book" ,book );
    	
    	return "/show.jsp";
    }

    
    
}

		

	
		

package com.fatuma.bookAPIs.controllers;

import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fatuma.bookAPIs.models.Book;
import com.fatuma.bookAPIs.services.BookService.BookService;

@RestController


public class BookAPIController {
	
	
	@Autowired
   private BookService bookService;
	
	@RequestMapping("/api/book")
	public List<Book> index(){
		return bookService.allBooks();
	}
	
	@PostMapping("/create")
	public Book createBook(
		@PathVariable("id") Long id, 
		@RequestParam(value="title") String title, 
		@RequestParam(value="description") String desc, 
		@RequestParam(value="language") String lang,
		@RequestParam(value="pages") Integer numOfPages) {
		Book newBook = new Book(title, desc,lang, numOfPages);
    return this.bookService.createBook(newBook);
	}
	
    // other methods removed for brevity
    public BookAPIController(BookService bookService) {
		super();
		this.bookService = bookService;
	}

	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public Book update(
    		@PathVariable("id") Long id, 
    		@RequestParam(value="title") String title, 
    		@RequestParam(value="description") String desc, 
    		@RequestParam(value="language") String lang,
    		@RequestParam(value="pages") Integer numOfPages) {
        Book newBook = new Book(title, desc,lang, numOfPages);
        return this.bookService.createBook(newBook);
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        bookService. deleteBookById(id);
    }}
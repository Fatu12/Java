package com.fatuma.bookAPI.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class BookAPI {

	 BooksApi {
		    private final BookService bookService;
		    
		    public BookAPI(BookService bookService){
		        this.bookService = bookService;
		    }
		    // other methods removed for brevity
		    @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
		    public Book update(
		    		@PathVariable("id") Long id, 
		    		@RequestParam(value="title") String title, 
		    		@RequestParam(value="description") String desc, 
		    		@RequestParam(value="language") String lang,
		    		@RequestParam(value="pages") Integer numOfPages) {
		        Book book = bookService.updateBook(id, title, desc, lang, numOfPages);
		        return book;
		    }
		    
		    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
		    public void destroy(@PathVariable("id") Long id) {
		        bookService.deleteBook(id)
}

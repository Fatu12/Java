package com.fatuma.bookAPIs.services.BookService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatuma.bookAPIs.models.Book;
import com.fatuma.bookAPIs.repositories.BookRepo;

@Service
public class BookService {
	// adding the book repository as a dependency and connection to our repository since 
	// we need need them
//	this is for our repo
//    private final BookRepo bookRepo;
//    
//    public BookService(BookRepo bookRepo) {
//        this.bookRepo = bookRepo;
//    }
//	inseted of the the above we can use this 
	@Autowired
	
	private  BookRepo bookRepo;
	
    // returns all the books we have created
    public List<Book> allBooks() {
        return bookRepo.findAll();
    }
    //================= creates a book ================
    public Book createBook(Book newBook) {
        return bookRepo.save(newBook);
    }
 // ===============update a book ================
    public Book updateBook(Book newBook) {
        return bookRepo.save(newBook);
    }
    // ================ find book by id =================
//    public Book findBook(Long id) {
//        Optional<Book> optionalBook = bookRepo.findById(id);
//        if(optionalBook.isPresent()) {
//            return optionalBook.get();
//        } else {
//            return null;
//        }
//    }
    // same as above 
    
    //================= read one =====================
    public Book getById(Long id) {
    	return bookRepo.findById(id).orElse(null);
    	
    }
        
//        public void deleteBook(Long id) {
//        	
//        	Optional<Book> optionalBook = bookRepo.findById(id);
//        		if(optionalBook.isPresent()) {
//        			bookRepo.deleteById(id);
//        		}
//        	}
// ============  delete book  ===============   
    public void deleteBookById(Long id) {
    	bookRepo.deleteById(id);
    }
        }
   
    


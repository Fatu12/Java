package com.fatuma.dojoandNinjasAssignment.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatuma.dojoandNinjasAssignment.model.BookModel;
import com.fatuma.dojoandNinjasAssignment.repositories.BookRepo;

@Service

public class BookService {
	
	@Autowired
	
	private BookRepo bRepo;
	//===================== CREATE =========================
	// Since we want when we create we want to add the list of the creator we need to pass the
	// user object
	
	
	public BookModel createDorm(BookModel newBook) {
		
		
		 return this.bRepo.save(newBook);	
		
	}
		
		public List<BookModel> getAll(){
			
			return this.bRepo.findAll();
		}
		
		//======================== Update =====================
		
		public BookModel updateDorm(BookModel updatedBook) {
			return bRepo.save(updatedBook);
		}
		
		//====================== FIND BY ID ==========================
		
		public BookModel getByID(Long bookId) {
			return bRepo.findById(bookId).orElse(null);
		}
		
	//=================== DELETE==================
		
		public void deleteDorm(Long deleteID) {
			this.bRepo.deleteById(deleteID);
		}
		
				
}




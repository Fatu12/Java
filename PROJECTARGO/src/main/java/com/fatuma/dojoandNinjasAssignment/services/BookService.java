package com.fatuma.dojoandNinjasAssignment.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatuma.dojoandNinjasAssignment.model.BookModel;
import com.fatuma.dojoandNinjasAssignment.repositories.BookRepo;

@Service
public class BookService {

	
	// accessing book repo
	@Autowired
	private BookRepo bRepo;
	
	//=========================== Read ALL ==============================

	public List<BookModel> getAll(){
		return bRepo.findAll();
	}
	// ========================== Create=================
	
	public BookModel createBooks(BookModel newBooks) {
		return bRepo.save(newBooks);
	}
	
	
	//======================== Update =====================
	
	public BookModel updateBook(BookModel updatedBooks) {
		return bRepo.save(updatedBooks);
	}
	
	//====================== FIND BY ID ==========================
	
	public BookModel getByID(Long bookID) {
		return bRepo.findById(bookID).orElse(null);
	}
	
//=================== DELETE==================
	
	public void delete(Long deleteID) {
		this.bRepo.deleteById(deleteID);
	}
	
	
	
}

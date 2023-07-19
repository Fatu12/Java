package com.fatuma.BookBroker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatuma.BookBroker.models.BookModel;
import com.fatuma.BookBroker.repositrories.BookRepo;

@Service
public class BookService {
	
	@Autowired
	private BookRepo bRepo;
	
	//===================== READ ALL======================
	
public List<BookModel> getAll(){
	return this.bRepo.findAll();
	
}

//===================== CREATE ============================

public BookModel createBooks(BookModel newBooks) {
	return this.bRepo.save(newBooks);
}

//===================UPDATE=========================

public BookModel updateBook(BookModel updatedBooks) {
	return this.bRepo.save(updatedBooks);
}

//====================== FIND BY ID =========================

public BookModel getByID(Long bookId) {
	return this.bRepo.findById(bookId).orElse(null);
}

//========================= DELETE ===========================

public void deleteBook(Long deleteID) {
	this.bRepo.deleteById(deleteID);
}
	
	

	
}

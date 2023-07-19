package com.fatuma.BookBroker.repositrories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fatuma.BookBroker.models.BookModel;

public interface BookRepo extends CrudRepository<BookModel,Long>{
	List<BookModel> findAll();
	

}
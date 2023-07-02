package com.fatuma.bookAPIs.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fatuma.bookAPIs.models.Book;
//A Repository represents all objects of a certain type as a conceptual set. It acts like a collection, except with
//more elaborate querying capability. CrudRepository building method 
@Repository, 
public interface BookRepo extends CrudRepository<Book,Long> {
	List<Book> findAll();
	
	// this method finds books with descriptions containing the search string
    List<Book> findByDescriptionContaining(String search);

}

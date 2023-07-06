package com.fatuma.bookAPIs.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fatuma.bookAPIs.models.Book;

@Repository

public interface BookRepo  extends CrudRepository<Book , Long>{
	
	  // this method retrieves all the books from the database
    List<Book > findAll();




}

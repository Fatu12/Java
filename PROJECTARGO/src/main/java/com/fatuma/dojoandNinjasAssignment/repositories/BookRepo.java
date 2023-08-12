package com.fatuma.dojoandNinjasAssignment.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fatuma.dojoandNinjasAssignment.model.BookModel;

@Repository

public interface BookRepo extends CrudRepository<BookModel,Long>{
	List<BookModel> findAll();

}
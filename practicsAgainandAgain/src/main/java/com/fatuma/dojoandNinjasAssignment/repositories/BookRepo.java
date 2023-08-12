package com.fatuma.dojoandNinjasAssignment.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fatuma.dojoandNinjasAssignment.model.BookModel;

public interface BookRepo  extends CrudRepository<BookModel,Long>{
	List<BookModel> findAll();

}
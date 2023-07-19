package com.fatuma.BookBroker.repositors;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fatuma.BookBroker.models.TaskModel;

public interface TaskRepo extends CrudRepository<TaskModel,Long>{
	List<TaskModel> findAll();
	

}
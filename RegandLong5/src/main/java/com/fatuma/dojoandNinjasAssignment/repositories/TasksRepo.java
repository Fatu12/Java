package com.fatuma.dojoandNinjasAssignment.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fatuma.dojoandNinjasAssignment.model.TaskModel;



public interface TasksRepo extends  CrudRepository<TaskModel,Long>{
	List<TaskModel> findAll();
}
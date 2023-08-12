package com.fatuma.dojoandNinjasAssignment.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fatuma.dojoandNinjasAssignment.model.StudentsModel;

public interface StudentRepo extends CrudRepository<StudentsModel,Long>{
	List<StudentsModel> findAll();
	

}
package com.fatuma.dojoandNinjasAssignment.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fatuma.dojoandNinjasAssignment.model.NoteModel;

public interface NoteRepo extends CrudRepository<NoteModel,Long>{
	List<NoteModel> findAll();
	

}
package com.fatuma.dojoandNinjasAssignment.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fatuma.dojoandNinjasAssignment.model.CommentModel;

public interface CommentRepo extends CrudRepository <CommentModel,Long> {
	List<CommentModel> findAll();
}
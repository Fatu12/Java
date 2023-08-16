package com.fatuma.liveChat.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fatuma.liveChat.models.CommentModel;


public interface CommentRepo extends CrudRepository <CommentModel,Long> {
	List<CommentModel> findAll();
}
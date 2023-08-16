package com.fatuma.liveChat.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.fatuma.liveChat.models.UserModel;



public interface UserRepo extends CrudRepository<UserModel,Long>{
	List<UserModel> findAll();
	Optional<UserModel> findByEmail(String email);

}
package com.fatuma.bookClubs.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.fatuma.bookClubs.model.UserModel;


public interface UserRepo extends CrudRepository<UserModel,Long>{
	List<UserModel> findAll();
	Optional<UserModel> findByEmail(String email);

}
package com.fatuma.liveChat.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fatuma.liveChat.models.NcommunityModel;


public interface NCommunityRepo extends CrudRepository <NcommunityModel,Long> {
	List<NcommunityModel> findAll();
}
	
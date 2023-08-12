package com.fatuma.dojoandNinjasAssignment.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fatuma.dojoandNinjasAssignment.model.NcommunityModel;

public interface NCommunityRepo extends CrudRepository <NcommunityModel,Long> {
	List<NcommunityModel> findAll();
}
	
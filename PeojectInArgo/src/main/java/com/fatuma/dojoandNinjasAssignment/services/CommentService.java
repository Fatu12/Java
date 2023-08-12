package com.fatuma.dojoandNinjasAssignment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatuma.dojoandNinjasAssignment.model.CommentModel;
import com.fatuma.dojoandNinjasAssignment.model.NcommunityModel;
import com.fatuma.dojoandNinjasAssignment.model.UserModel;
import com.fatuma.dojoandNinjasAssignment.repositories.CommentRepo;


@Service

public class CommentService {
	
	@Autowired
	private CommentRepo cRepo;
	
	public CommentModel createComment(CommentModel newComment, UserModel newUser,NcommunityModel newCommunity) {
		newComment.setCreatorCommant(newUser);;
		newComment.setCommantyCommant(newCommunity);
		return this.cRepo.save(newComment);
		
	}

		public void deleteCommant(Long deleteID) {
			this.cRepo.deleteById(deleteID);
		}
		


}

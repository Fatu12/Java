package com.fatuma.liveChat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatuma.liveChat.models.CommentModel;
import com.fatuma.liveChat.models.NcommunityModel;
import com.fatuma.liveChat.models.UserModel;
import com.fatuma.liveChat.repository.CommentRepo;


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

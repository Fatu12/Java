package com.fatuma.dojoandNinjasAssignment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatuma.dojoandNinjasAssignment.model.HouseHunterModel;
import com.fatuma.dojoandNinjasAssignment.model.NoteModel;

import com.fatuma.dojoandNinjasAssignment.model.UserModel;
import com.fatuma.dojoandNinjasAssignment.repositories.NoteRepo;

@Service

public class NoteService {
	
@Autowired
private NoteRepo nRepo;

public NoteModel createNote(NoteModel newNote, UserModel newUser,HouseHunterModel newHouseH) {
	newNote.setUserNote(newUser);
	newNote.setHouseHunterNote(newHouseH);
	return this.nRepo.save(newNote);

	
	
}


}

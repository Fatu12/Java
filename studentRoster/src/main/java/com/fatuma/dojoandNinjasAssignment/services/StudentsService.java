package com.fatuma.dojoandNinjasAssignment.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatuma.dojoandNinjasAssignment.model.StudentsModel;
import com.fatuma.dojoandNinjasAssignment.repositories.StudentRepo;

@Service

public class StudentsService {
	
	@Autowired
	private StudentRepo sRepo;
	
	//===================== CREATE =========================
	// Since we want when we create we want to add the list of the creator we need to pass the
	// user object
	
	
	public StudentsModel createStudent(StudentsModel newStudent) {
		
		
		 return this.sRepo.save(newStudent);	
		
	}
		
		public List<StudentsModel> getAll(){
			
			return this.sRepo.findAll();
		}
		
		//======================== Update =====================
		
		public StudentsModel updateDorm(StudentsModel updatedStudent) {
			return sRepo.save(updatedStudent);
		}
		
		//====================== FIND BY ID ==========================
		
		public StudentsModel getByID(Long studentId) {
			return sRepo.findById(studentId).orElse(null);
		}
		
	//=================== DELETE==================
		
		public void deleteDorm(Long deleteID) {
			this.sRepo.deleteById(deleteID);
		}
		

}

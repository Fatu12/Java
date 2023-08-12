package com.fatuma.BookBroker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatuma.BookBroker.models.ProjectModel;
import com.fatuma.BookBroker.models.TaskModel;
import com.fatuma.BookBroker.models.UserModel;
import com.fatuma.BookBroker.repositores.ProjectRepo;
import com.fatuma.BookBroker.repositores.TaskRepo;

@Service

public class TaskService {
	
	
	//============================= ACCESS REPO=========================
	
		@Autowired 
		private TaskRepo tRepo;
		
		
		
		//================================ GET ALL ======================
		
		public List<TaskModel> getAll(){
			return this.tRepo.findAll();
		}
		
		//=============================== CREATE ======================
		
		public TaskModel createTask(TaskModel newTask, UserModel newUser, ProjectModel newProject) {
			newTask.setUserTask(newUser);
			newTask.setProjectTask(newProject);
			
		

			return this.tRepo.save(newTask);	
		}
		
		//==========================  UPDATE ======================
	
		public TaskModel updateProjocts(TaskModel updatedTask) {
			
			
			return this.tRepo.save(updatedTask);

		}
		
		//================================= GET BY ID==========================
		
		public TaskModel getByID(Long taskId) {
			return this.tRepo.findById(taskId).orElse(null);
			
		}
		
		public void deletedTask(Long deleteId) {
		 this.tRepo.deleteById(deleteId);
		}
		
	
}
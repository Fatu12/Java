package com.fatuma.BookBroker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatuma.BookBroker.models.ProjectModel;
import com.fatuma.BookBroker.models.TaskModel;
import com.fatuma.BookBroker.models.UserModel;
import com.fatuma.BookBroker.repositors.TaskRepo;

@Service

public class TaskService {
	@Autowired
	private TaskRepo tRepo;
	
	public TaskModel createTask(TaskModel newTask, UserModel user,ProjectModel thisProj) {
		newTask.setCreater(user);
		newTask.setProjectTask(thisProj);
		return this.tRepo.save(newTask);
	}
	

}

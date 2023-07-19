package com.fatuma.dojoandNinjasAssignment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatuma.dojoandNinjasAssignment.model.ProjectModel;
import com.fatuma.dojoandNinjasAssignment.model.TaskModel;
import com.fatuma.dojoandNinjasAssignment.model.UserModel;
import com.fatuma.dojoandNinjasAssignment.repositories.TasksRepo;

@Service
public class TasksService {
	@Autowired
	private TasksRepo tRepo;
	
	public TaskModel createTask(TaskModel newTask, UserModel user, ProjectModel thisProj) {
		newTask.setUserTask(user);
		newTask.setProjectTask(thisProj);
		return this.tRepo.save(newTask);
		
	}

}

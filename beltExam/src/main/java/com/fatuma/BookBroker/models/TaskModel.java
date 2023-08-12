package com.fatuma.BookBroker.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="tasks")

public class TaskModel {
	//=========basic class object Attratutes========
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	   
	    //This will allow the createdAt column to be updated after creation happen 
	 	//this is not changable, so we it is created it always that
	    @Column(updatable=false)
	    @DateTimeFormat(pattern="MM/dd/yyyy JJ:mm:ss")
	    private Date createdAt;
	    @DateTimeFormat(pattern="MM/dd/yyyy HH:mm:ss")
	    private Date updatedAt;
	    // =================== setter and getter==============================
	    // other getters and setters removed for brevity
	    @PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
	    
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
	    
	    //================================== ATTRIBUTE =======================
	    
	    @NotBlank(message="ticket required")
	    @Size(min=2, max=255, message="tiket must be more than 2 letter")
	    private String taskTicket;
	    
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="user_id")
	    private UserModel userTask;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="project_id")
	    private ProjectModel projectTask;
	    
	    
	        
		public UserModel getUserTask() {
			return userTask;
		}

		public void setUserTask(UserModel userTask) {
			this.userTask = userTask;
		}

		public ProjectModel getProjectTask() {
			return projectTask;
		}

		public void setProjectTask(ProjectModel projectTask) {
			this.projectTask = projectTask;
		}

		public TaskModel() {
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}

		public String getTaskTicket() {
			return taskTicket;
		}

		public void setTaskTicket(String taskTicket) {
			this.taskTicket = taskTicket;
		}
		
		
	
	    

}

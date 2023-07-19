package com.fatuma.BookBroker.models;

import java.util.Date;
import java.util.List;


import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="projects")

public class ProjectModel {
	

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
	    
	  //================================== ATTRIBUTE =====================
	    @NotBlank(message="title required")
	    @Size(min=2, max=255, message="title must be more than 2 characters")
	    private String title;
	    

	    @NotBlank(message=" comment required")
	    @Size(min=2, max=255, message="comment must be more than 2 characters")
	    private String comment;
	    
	    @NotNull(message="duaDate required")
	    @Future(message="The date must not be in the past")
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private Date duaDate;
	    
	    // ============================= TABLE RELATIONSHIPS======================
	    
	    @ManyToOne(fetch=FetchType.LAZY)
	    @JoinColumn(name="creatore_id")
	    
	    // chech that  @ManyToOne it mean project only blong to one user, that means creatore hold ,
	    // just that object of one users that have logged in. 
	    
	    private UserModel creatore;
	    
	    
	    @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(
	        name = "teams", 
	        joinColumns = @JoinColumn(name = "product_id"), 
	        inverseJoinColumns = @JoinColumn(name = "user_id")
	    )
	    private List<UserModel> teamMembers;
	    
	    
	    
	    @OneToMany(mappedBy="projectTask", fetch=FetchType.LAZY)
	    private List<TaskModel> projectTask;
	    
	   
	    
	    
	    public List<TaskModel> getProjectTask() {
			return projectTask;
		}

		public void setProjectTask(List<TaskModel> projectTask) {
			this.projectTask = projectTask;
		}

	
	    //============================ CONSTUCTERS =================================
	    
	    public List<UserModel> getTeamMembers() {
			return teamMembers;
		}

		public void setTeamMembers(List<UserModel> teamMembers) {
			this.teamMembers = teamMembers;
		}

		public ProjectModel() {
				
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

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getComment() {
			return comment;
		}

		public void setComment(String comment) {
			this.comment = comment;
		}

		public Date getDuaDate() {
			return duaDate;
		}

		public void setDuaDate(Date duaDate) {
			this.duaDate = duaDate;
		}

		public UserModel getCreatore() {
			return creatore;
		}

		public void setCreatore(UserModel creatore) {
			this.creatore = creatore;
		}
	}

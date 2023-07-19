package com.fatuma.dojoandNinjasAssignment.model;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

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
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="projects")

public class ProjectsModels {
	
	//=========basic class object ATTRIBUTE========
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
    //============================= Attributes ====================
    
    @NotBlank(message="title required")
    @Size(min=2, max=255,message="title must be greater 2 letter")
    private String title;
    
    @NotBlank(message="description required")
    @Size(min=2, max=255,message="description must be greater 3 letter")
    private String description;
    
    
    @NotNull(message="duaDate required")
    @Future(message="The date must not be in the past")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date duaDate;
    
    
  
    //========================== Table Relationships ======================
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="creator_id")
    private UserModel creator;
    
    
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//        name = "teams", 
//        joinColumns = @JoinColumn(name = "project_id"), 
//        inverseJoinColumns = @JoinColumn(name = "user_id")
//    )
//    private List<UserModel> teamMember;
//    
  //======================= CONTSTRUCTER=================================
  	public ProjectsModels() {
  		
  	}
      
  	
  	//=============================== GETTER AND SETTER ============================	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDuaDate() {
		return duaDate;
	}

	public void setDuaDate(Date duaDate) {
		this.duaDate = duaDate;
	}

	public UserModel getCreator() {
		return creator;
	}

	public void setCreator(UserModel creator) {
		this.creator = creator;
	}

	
    
    
}

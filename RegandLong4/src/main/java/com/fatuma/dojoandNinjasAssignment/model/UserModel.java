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
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users")

public class UserModel {

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
	    
	    @NotBlank(message="Last Name  is required!")
	    @Size(min=3, max=30, message="First Name must be between 3 and 30 characters")
	    private String lastName;
	    
	    
	    @NotBlank(message="last name is required!")
	    @Size(min=3, max=30, message="Last Name must be between 3 and 30 characters")
	    private String firstName;
	    
	    // EMAIL IS UNIQUE 
	    
	    @NotBlank(message="Email is required!")
	    @Email(message="Please enter a valid email!")
	    private String email;
	    
	    @NotBlank(message="Password is required!")
	    @Size(min=8, max=20000, message="Password must be between 8 and 128 characters")
	    private String password;
	    //This will allow us to use confirm on an instance of User temporarily, without ever saving it to the database. 
	    @Transient
	    @NotBlank(message="Confirm Password is required!")
	    @Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters")
	    
	   
	    private String confirm;
	    
	    //====================== TABLE RELATIONSHIP ==============================
	    @OneToMany(mappedBy="creatore", fetch=FetchType.LAZY)
	    // one to many List<ProjectModel> that is a list of object that blong to the user 
	    // that I have creteed, that means that the user who are loggedin and create that projoct,
	    // can have list of the project that blong to them 
	    private List<ProjectModel> myProjects;
	    
	    
	    @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(
	        name = "teams", 
          joinColumns = @JoinColumn(name = "user_id"), 
	        inverseJoinColumns = @JoinColumn(name = "project_id")
    )
	    private List<ProjectModel> millionDollarIdeas;
	    
	    
//	    @ManyToMany(fetch = FetchType.LAZY)
//	    @JoinTable(
//	        name = "teams", 
//	        joinColumns = @JoinColumn(name = "user_id"), 
//	        inverseJoinColumns = @JoinColumn(name ="product_id")
//	    )
//	    private List<ProjectModel> millionDollarIdeas;
//	    
	    
	    // ===================CONSTURCTURE===================== 
		public UserModel() {
		
		}
		//================== GETTER AND SETTER ================

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

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getConfirm() {
			return confirm;
		}

		public void setConfirm(String confirm) {
			this.confirm = confirm;
		}

		public List<ProjectModel> getMyProjects() {
			return myProjects;
		}

		public void setMyProjects(List<ProjectModel> myProjects) {
			this.myProjects = myProjects;
		}

		public List<ProjectModel> getMillionDollarIdeas() {
			return millionDollarIdeas;
		}

		public void setMillionDollarIdeas(List<ProjectModel> millionDollarIdeas) {
			this.millionDollarIdeas = millionDollarIdeas;
		}

		
		

		
		
		
		
		
	    
	    
}



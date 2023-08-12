package com.fatuma.dojoandNinjasAssignment.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	    @Size(min=3, max=255, message="First Name must be between 3  characters")
	    private String lastName;
	    
	    
	    @NotBlank(message="last name is required!")
	    @Size(min=3, max=255, message="Last Name must be  3  characters")
	    private String firstName;
	    
	    // EMAIL IS UNIQUE 
	    
	    @NotBlank(message="Email is required!")
	    @Email(message="Please enter a valid email!")
	    private String email;
	    
	    @NotBlank(message="Password is required!")
	    @Size(min=8, max=20000, message="Password must be  8 characters")
	    private String password;
	    //This will allow us to use confirm on an instance of User temporarily, without ever saving it to the database. 
	    @Transient
	    @NotBlank(message="Confirm Password is required!")
	    @Size(min=8, max=255, message="Confirm Password mutch  ")
	    private String confirm;
	    
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
		
		
	    
	    
}



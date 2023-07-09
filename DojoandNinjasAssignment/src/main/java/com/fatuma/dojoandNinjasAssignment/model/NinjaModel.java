package com.fatuma.dojoandNinjasAssignment.model;

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
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="ninjas")

public class NinjaModel {
	
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
	    
	    @NotBlank(message="firstName required")
	    @Size(min=2,max=255,message="first name must be over 2 characters")
	    private String firstName;
	    
	    @NotBlank(message="lastName required")
	    @Size(min=2, max=255,message="last name must be over 2 characters")
	    private String lastName;
	    
	    @NotNull(message= "age required")
	    @Min(value=0, message="age must be greater then 0")
	    private Integer age;
	    
	    //==================== Table Relationship Attributes ==================
	    // many to one  beacuse of th FK,  Whether the association should be lazily 
	    //loaded or must be eagerly fetched.
	    @ManyToOne(fetch=FetchType.LAZY)
	    // this hold the Fk in this table Fk is must be unique, this is going to be the one carries the value in  the
	    // databse is going to be this 
		@JoinColumn(name="dojo_id")
	    private DojosModel dojo;

	    
		public Long getId() {
			return id;
		}
	
		public NinjaModel() {
		
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
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public Integer getAge() {
			return age;
		}
		public void setAge(Integer age) {
			this.age = age;
		}
		public DojosModel getDojo() {
			return dojo;
		}
		public void setDojo(DojosModel dojo) {
			this.dojo = dojo;
		}
		
	  
}

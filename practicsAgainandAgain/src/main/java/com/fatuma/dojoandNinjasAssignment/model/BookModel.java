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
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="books")

public class BookModel {

	
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
 
    @NotBlank(message="title is required!")
    @Size(min=3, max=30, message="title must be between 3 and 30 characters")
    private String title;
    
    // EMAIL IS UNIQUE 
    
    
    
    @NotBlank(message="author is required!")
    @Size(min=2, max=20000, message="author must be between 8 and 128 characters")
    private String author;
    //This will allow us to use confirm on an instance of User temporarily, without ever saving it to the database. 
    
    @NotBlank(message="comment Password is required!")
    @Size(min=2, max=128, message="comemnt must be between  and 128 characters")
    private String comment;
    
    
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="creatore_id")
  
    private UserModel creatore;
	public BookModel() {
		
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public UserModel getCreatore() {
		return creatore;
	}

	public void setCreatore(UserModel creatore) {
		this.creatore = creatore;
	}
    
    
    
}

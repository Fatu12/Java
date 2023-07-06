package com.fatuma.backendlecture.models;

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
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
 
@Entity
@Table(name="twitters")

//everthing we going to write in this data base it going to create a table for us
public class Tweet {
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
	    
	    // other getters and setters removed for brevity
	    @PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
	    // objecct specific attributes 
	    // all of this takes messages
	    
	   
	    @NotBlank(message="content Required")
	    @Size(min=2,max=255, message="content must be over 2 chareacters")
//	     the message don't nedd comma, just the attributes
	    private String tweetContent;
	    
	    @NotNull(message="imaginaryIntAtt Required")
	    @Min(value=10,message="imgainaryIntAtt must be over 10")
	    private int imginaryIntAtt;
	    
	    
	    // Table Relationship Attributes ===============
	    
	    // Empty Constructor ================

		public Tweet() {
			
		}
	
		public Tweet(
				 String tweetContent,
				 int imginaryIntAtt) {
			this.tweetContent = tweetContent;
			this.imginaryIntAtt = imginaryIntAtt;
		}
		// getter and setter since we have private faild we need getter and setter to access
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
		public String getTweetContent() {
			return tweetContent;
		}
		public void setTweetContent(String tweetContent) {
			this.tweetContent = tweetContent;
		}
		public int getImginaryIntAtt() {
			return imginaryIntAtt;
		}
		public void setImginaryIntAtt(int imginaryIntAtt) {
			this.imginaryIntAtt = imginaryIntAtt;
		}    
	    
	    
	}

	
	



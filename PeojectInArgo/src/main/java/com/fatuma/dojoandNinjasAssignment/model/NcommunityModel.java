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
@Table(name="communities")

public class NcommunityModel {
	
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
    
    @NotBlank(message="title  is required!")
    @Size(min=3, max=255, message="title must be between 3  characters")
    private String title;
    
    @NotBlank(message="description  is required!")
    @Size(min=3, max=255, message="description must be between 3  characters")
    private String discription;

    @NotNull(message="date required")
    @Future(message="date must not be in the past")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    
    @NotBlank(message="address is required!")
    @Size(min=3, max=255, message="address must be between 3  characters")
    private String address;
    
    //============================== RELATIONSHIP TABLE =================================
    
	

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="creator_id")
    private UserModel creator;
    
    
   @OneToMany(mappedBy="commantyCommant", fetch=FetchType.LAZY)
   private List<CommentModel> commantyCommant;
    
    //=========================== CONSTURECTER =====================================


	
   	public List<CommentModel> getCommantyCommant() {
		return commantyCommant;
	}

	public void setCommantyCommant(List<CommentModel> commantyCommant) {
		this.commantyCommant = commantyCommant;
	}

	public NcommunityModel() {
   		
   	}
    //================================== GETTER AND SETTER ====================================
  
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

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public UserModel getCreator() {
		return creator;
	}

	public void setCreator(UserModel creator) {
		this.creator = creator;
	}
    

}

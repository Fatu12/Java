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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="dorms")

public class DormModel {
	
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
    

    @NotBlank(message="dorm name  is required!")
    @Size(min=3, max=30, message="dorm name must be between 3 and 30 characters")
    private String dormName;
    
    //===================== TABLE RALASHINSHIP =====================
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="creator_id")
    private UserModel creator;
    
    
    @OneToMany(mappedBy="myDorom", fetch=FetchType.LAZY)
	private List<StudentsModel> ListDormstudents;
	
    
    
    
	public UserModel getCreator() {
		return creator;
	}

	public void setCreator(UserModel creator) {
		this.creator = creator;
	}

	public DormModel() {
		
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

	public String getDormName() {
		return dormName;
	}

	public void setDormName(String dormName) {
		this.dormName = dormName;
	}

	public List<StudentsModel> getListDormstudents() {
		return ListDormstudents;
	}

	public void setListDormstudents(List<StudentsModel> listDormstudents) {
		ListDormstudents = listDormstudents;
	}
    
}

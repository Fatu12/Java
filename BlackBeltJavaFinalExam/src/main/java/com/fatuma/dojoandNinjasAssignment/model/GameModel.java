package com.fatuma.dojoandNinjasAssignment.model;

import java.util.Date;
import java.util.List;

import org.springframework.boot.context.properties.bind.Name;
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
@Table(name="games")

public class GameModel {

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
	  
	    @NotBlank(message="name is required!")
	    @Size(min=3, max=255, message="name be 3 characters")
	    private String name;
	    
	    @NotBlank(message="genre is required!")
	    @Size(min=3, max=255, message="genre be 3 characters")
	    private String genre;
	    
	   @NotBlank(message="description is required!")
	    @Size(min=3, max=255, message="description be 3 characters")
	    private String description;
	    
	    @ManyToOne(fetch=FetchType.LAZY)
	    @JoinColumn(name="creator_id")
	    private UserModel creator;
	    
	    
	    @OneToMany(mappedBy="gameMechanic", fetch=FetchType.LAZY)
	    private List<GameMechanicModel> allGameMechanic;
	    
	    
		public List<GameMechanicModel> getAllGameMechanic() {
			return allGameMechanic;
		}

		public void setAllGameMechanic(List<GameMechanicModel> allGameMechanic) {
			this.allGameMechanic = allGameMechanic;
		}

		public GameModel() {
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

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getGenre() {
			return genre;
		}

		public void setGenre(String genre) {
			this.genre = genre;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public UserModel getCreator() {
			return creator;
		}

		public void setCreator(UserModel creator) {
			this.creator = creator;
		}
	    
		
	    
	    

}

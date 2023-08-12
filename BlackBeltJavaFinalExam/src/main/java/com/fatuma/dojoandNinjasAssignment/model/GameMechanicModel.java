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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="mechanics")

public class GameMechanicModel {
	
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
	    
	    @NotBlank(message="Game Mechanic required")
	    @Size(min=3, max=255, message="Game Mechanic must be 3 more than  characters")
	    private String  mechanicName;  
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name ="game_id")
	    private GameModel gameMechanic;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="user_id")
	    private UserModel userMechanic;
	    
		public GameMechanicModel() {
			super();
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

		public String getMechanicName() {
			return mechanicName;
		}

		public void setMechanicName(String mechanicName) {
			this.mechanicName = mechanicName;
		}

		public GameModel getGameMechanic() {
			return gameMechanic;
		}

		public void setGameMechanic(GameModel gameMechanic) {
			this.gameMechanic = gameMechanic;
		}

		public UserModel getUserMechanic() {
			return userMechanic;
		}

		public void setUserMechanic(UserModel userMechanic) {
			this.userMechanic = userMechanic;
		}
	    
	    
		

}

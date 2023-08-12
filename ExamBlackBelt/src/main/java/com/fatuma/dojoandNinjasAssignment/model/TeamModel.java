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
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity

@Table(name="teams")

public class TeamModel {
	
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
    
    @NotNull(message=" Skill Level is required")
	 @Min(value=1 , message="Skill Level between 1-5")
	@Max(value=5, message = "rating max must be 5")
	private Integer skillLevel ;
    
    @NotNull(message="game day required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date gameDay;
    
//    @NotBlank(message="game day is required!")
//    @Size(min=3, max=255, message="game name  be 3 characters")
//    private Date gameDay;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="creatore_id")
    private UserModel creatore;
    
    @OneToMany(mappedBy="teamPlayer", fetch=FetchType.LAZY)
    private List<PlayerModel> allTeamPlayers;
	public TeamModel() {
	
	}
	

	public List<PlayerModel> getAllTeamPlayers() {
		return allTeamPlayers;
	}

	public void setAllTeamPlayers(List<PlayerModel> allTeamPlayers) {
		this.allTeamPlayers = allTeamPlayers;
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

	public Integer getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(Integer skillLevel) {
		this.skillLevel = skillLevel;
	}



	public Date getGameDay() {
		return gameDay;
	}

	public void setGameDay(Date gameDay) {
		this.gameDay = gameDay;
	}

	public UserModel getCreatore() {
		return creatore;
	}

	public void setCreatore(UserModel creatore) {
		this.creatore = creatore;
	}
	
	
    
 


}

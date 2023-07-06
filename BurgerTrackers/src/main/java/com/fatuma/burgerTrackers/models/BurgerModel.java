package com.fatuma.burgerTrackers.models;

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
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
@Entity
@Table(name="burgers")
public class BurgerModel {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	// @Column going make sure it not get update after it get create it, I mean that it not changeble
	@Column(updatable= false)
	@DateTimeFormat(pattern= "MM/dd/yyyy JJ:mm:ss")
	 private Date createdAt;
	@DateTimeFormat(pattern= "MM/dd/yyyy HH:mm:ss")
	private Date updateAt;
	//============== this two are getter and setter===================
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
		
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updateAt = new Date();
		
	}
	@NotNull(message="Burger name is required")
	private String burgerName;
	
	@NotNull(message=" restaurant name  is required")
	private String restaurantName;
	
	
	
	@NotNull(message=" commment  is required")
	private String restcomment;
	
	@NotNull(message=" rating is required")
	 @Min(value=1 , message="rating must be over 1")
//	@Max(value=1, message = "rating max must be 5")
	private Integer restRating;
	
	
	

	public BurgerModel() {

	}

	public BurgerModel(
					Long id,
			        String burgerName,
					String restaurantName,
					Integer restRating,
					String restcomment) {
		
		this.id = id;
		this.burgerName = burgerName;
		
		this.restaurantName = restaurantName;
		this.restcomment = restcomment;
		this.restRating = restRating;
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

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	public String getBurgerName() {
		return burgerName;
	}

	public void setBurgerName(String burgerName) {
		this.burgerName = burgerName;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public Integer getRestRating() {
		return restRating;
	}

	public void setRestRating(Integer restRating) {
		this.restRating = restRating;
	}

	public String getRestcomment() {
		return restcomment;
	}

	public void setRestcomment(String restcomment) {
		this.restcomment = restcomment;
	}
	
	
	
}

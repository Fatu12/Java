package com.fatuma.travelsave.controllers;

import org.springframework.lang.NonNull;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name= "travel")

public class TravelSave {
	
	@NonNull
	public String fatu() {
		return "";
	}

}

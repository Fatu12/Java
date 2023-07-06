package com.fatuma.burgerTrackers.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="books")
public class Burger {
	
	@NotBlank(message="title Required")
	 @Size(min =2 , max=255, message="title must be over 2 chareacters")
	 private String bookTittle;

}

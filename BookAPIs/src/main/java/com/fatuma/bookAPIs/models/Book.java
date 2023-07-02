package com.fatuma.bookAPIs.models;

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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="books")
public class Book {
	
	// IN THIS CLASS WHAT WE DO IS EVERYTHING THAT WE NEED TO CREATE THIS APPLICATION(ATTRIBUTES)
	 //(@Id,@GeneratedValue) is going to establish thia as our primary key for our table in database
  
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
	 @NotBlank(message="title Required")
	 @Size(min =2 , max=255, message="title must be over 2 chareacters")
	 private String bookTittle;
	 
	 @NotBlank(message="description  Required")
	 @Size(min =2 , max=255, message="description must be over 2 chareacters")
	 private String  bookDesctiption;
	 // this is going to happen after whatever it updated it 
	 @NotBlank(message="language Required")
	 @Size(min =2 , max=255, message="language must be over 2 chareacters")
	 private String  bookLanguage;
	 @NotNull(message="Pages required")
	 @Min(value=30 , message="pages must be over 30 pages")
	 private Integer bookPage;
	 // ================Constructor always we need constructor=====================
	 
	public Book() {
	}
	
	
	//==================== getter and setter ============================

	public Book(
			String bookTittle,
			  String bookDesctiption,
			 String bookLanguage,
			 Integer bookPage) {
		super();
		this.bookTittle = bookTittle;
		this.bookDesctiption = bookDesctiption;
		this.bookLanguage = bookLanguage;
		this.bookPage = bookPage;
	}

	public Integer getBookPage() {
		return bookPage;
	}

	public void setBookPage(Integer bookPage) {
		this.bookPage = bookPage;
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

	public String getBookTittle() {
		return bookTittle;
	}

	public void setBookTittle(String bookTittle) {
		this.bookTittle = bookTittle;
	}

	public String getBookDesctiption() {
		return bookDesctiption;
	}

	public void setBookDesctiption(String bookDesctiption) {
		this.bookDesctiption = bookDesctiption;
	}

	public String getBookLanguage() {
		return bookLanguage;
	}

	public void setBookLanguage(String bookLanguage) {
		this.bookLanguage = bookLanguage;
	}
	 	

}

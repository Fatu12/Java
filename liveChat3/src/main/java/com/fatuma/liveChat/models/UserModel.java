package com.fatuma.liveChat.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users")

public class UserModel {

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
	    
	    @NotBlank(message="Last Name must be between 3  characters")
	    @Size(min=3, max=255,message="and required!")
	    private String lastName;
	    
	    
	    @NotBlank(message=" First Name must be 3 characters")
	    @Size(min=3, max=255,message="and required!")
	    private String firstName;
	    
	    // EMAIL IS UNIQUE 
	    
	    @NotBlank(message="Please enter a valid email!")
	    @Email(message="and required!")
	    private String email;
	    
	    @NotBlank(message="and required!")
	    @Size(min=8, max=20000,message="Password must be  8 characters")
	    private String password;
	    
	    //This will allow us to use confirm on an instance of User temporarily, without ever saving it to the database. 
	    @Transient
	    @NotBlank(message="Password must be mutch")
	    @Size(min=8, max=255,message="and required!")
	    private String confirm;
	    
	  
		@NotNull(message="Language must be over 1")
		@Min(value=1 ,message="and required!")
	    private Integer languageList;
	    
		@NotBlank(message="Language Name must be between 3  characters")
	    @Size(min=3, max=255,message="and required!")
	    private String langauge;
		
	    @NotBlank(message ="Race must be 3 characters")
	    @Size(min=3, max=255 ,message="and required!" )
	    private String race;
	    
	    @NotNull(message="Age must be over 1 and required!")
		@Min(value=1 , message="age must be over 1")
	    private Integer age;
	    
	    @NotBlank(message ="gander must be 3 characters")
	    @Size(min=3, max=255 ,message="and required!" )
	    private String gander;
	    

		private String socialMadia;
	    
	    private String phoneNumber;
	    
	    private String additioan;
	    
	    //======================== Relationship Table===========================
	    
	    @OneToMany(mappedBy="creator", fetch=FetchType.LAZY)
		 
	    private List<NcommunityModel> myCommunity;
	    
	    
	    @OneToMany(mappedBy="creatorCommant", fetch=FetchType.LAZY)
	    private List<CommentModel> communityMembers;
	    
	    
	    public String getAdditioan() {
			return additioan;
		}

		public String getLangauge() {
			return langauge;
		}

		public void setLangauge(String langauge) {
			this.langauge = langauge;
		}

		public void setAdditioan(String additioan) {
			this.additioan = additioan;
		}

		

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public Integer getLanguageList() {
			return languageList;
		}

		public void setLanguageList(Integer languageList) {
			this.languageList = languageList;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}


		public String getRace() {
			return race;
		}

		public void setRace(String race) {
			this.race = race;
		}


		public String getSocialMadia() {
			return socialMadia;
		}

		public void setSocialMadia(String socialMadia) {
			this.socialMadia = socialMadia;
		}

		public List<CommentModel> getCommunityMembers() {
			return communityMembers;
		}

		public void setCommunityMembers(List<CommentModel> communityMembers) {
			this.communityMembers = communityMembers;
		}

		public List<NcommunityModel> getMyCommunity() {
			return myCommunity;
		}

		public void setMyCommunity(List<NcommunityModel> myCommunity) {
			this.myCommunity = myCommunity;
		}

		// ===================CONSTURCTURE===================== 
		public UserModel() {
		
		}
		//================== GETTER AND SETTER ================

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

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getConfirm() {
			return confirm;
		}

		public void setConfirm(String confirm) {
			this.confirm = confirm;
		}

		public String getGander() {
			return gander;
		}

		public void setGander(String gander) {
			this.gander = gander;
		}   
		
}



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
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="houses")
public class HouseHunterModel {
	
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
    
    @NotBlank(message="address is required!")
    @Size(min=3, max=255, message="address be 3 characters")
    private String address;
    
    @NotNull(message=" price is required")
	 @Min(value=0 , message="price must be greater 0")
//	@Max(value=1, message = "rating max must be 5")
	private Integer price;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="creatore_id")
    private UserModel creatore;
    
    @OneToMany(mappedBy="houseHunterNote", fetch=FetchType.LAZY)
    private List<NoteModel> houseHNotes;
	public HouseHunterModel() {
	
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public UserModel getCreatore() {
		return creatore;
	}

	public void setCreatore(UserModel creatore) {
		this.creatore = creatore;
	}

	public List<NoteModel> getHouseHNotes() {
		return houseHNotes;
	}

	public void setHouseHNotes(List<NoteModel> houseHNotes) {
		this.houseHNotes = houseHNotes;
	}
    
	
		
	}



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
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="dojos")
public class DojosModel {
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
	    
	    @NotBlank(message="firstName required")
	    @Size(min=2,max=255,message="name must be over 2 characters")
	    private String name;
	
	    //==================== Table Relationship Attributes ==================
	    // one to many  because it holds primary keys
	    // ffor the "mappedBy" it need to plaged the attribute name of the other table and
	    //It  This may be used within an embeddable class contained within an entity class to specify a relationship to a 
	    //collection of entities This element is only specified on the 
	    //inverse (non-owning) side of the association.
	    // we don't want to to go get this information ubless we asked for it
	    //LAZY: The association is fetched when needed
	    
	    @OneToMany(mappedBy="dojo", fetch = FetchType.LAZY)
	    // this attributes is the object type  of our  other table
	    private List<NinjaModel> ninja;
	    
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
		public List<NinjaModel> getNinja() {
			return ninja;
		}
		public void setNinja(List<NinjaModel> ninja) {
			this.ninja = ninja;
		}
	    
		
	

}

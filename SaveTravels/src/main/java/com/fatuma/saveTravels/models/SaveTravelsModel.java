package com.fatuma.saveTravels.models;

import org.hibernate.annotations.Table;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;






// ALL OUR ATTRIBUTES WE NEED FOR THIS APP GOES HERE 
@Entity
@Table(name="travels")
public class SaveTravelsModel {
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
    
    // other getters and setters removed for brevity
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    // objecct specific attributes 
    // all of this takes messages
    
    @NotBlank(message="content Required")   
    @Size(min=2,max=255, message="content must be over 2 chareacters")
//     the message don't nedd comma, just the attributes
    private String tweetContent;
    
    @NotNull(message="imaginaryIntAtt Required")
    @Min(value=10,message="imgainaryIntAtt must be over 10")
    private int imginary
    
	
	
	

}

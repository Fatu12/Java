package com.fatuma.dojoandNinjasAssignment.validators;

import jakarta.validation.constraints.NotBlank;


// this is a helper class, that cab be used to modularize any group of functionalities that are not going to be part of the database, beacase
// we're not going to give it an entity , we not going to give a table name, jsut to grap same feilds 
// is only exists in the logic side of our app but not in the persistence layer not in our database

public class LoginValidator {
	
	@NotBlank(message= "Email is required to longgin !")
//    @Email(message="Please enter valid email and password")
    private String email;
    
    @NotBlank(message ="Password is required to longgin ")
//    @Size(min=8, max=128,message="Password has")
    private String password;

	public LoginValidator() {
		
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
   

}

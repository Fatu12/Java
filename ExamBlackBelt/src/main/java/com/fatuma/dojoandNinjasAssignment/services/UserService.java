package com.fatuma.dojoandNinjasAssignment.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import com.fatuma.dojoandNinjasAssignment.model.UserModel;

import com.fatuma.dojoandNinjasAssignment.repositories.UserRepo;
import com.fatuma.dojoandNinjasAssignment.validators.LoginValidator;

// service is required
// ALL OUR LOGIC GOES HERE 
@Service
public class UserService {
	//  we hava to acccess to our repo, otherwise we can't create any CRUD

@Autowired
private UserRepo uRepo;


// This method will be called from the controller
// whenever a user submits a registration form.
// newUser is holding the information that the user past it
// BindingResult that allows for automatically writing the form data into a new object that we bind to the JSP page using the view model, that is, the Model model that you're accustomed to using.

public UserModel register(UserModel newUser, BindingResult result) {

	// this newUser infromation coming from the form
	Optional<UserModel> potentialUser = uRepo.findByEmail(newUser.getEmail());
    // Reject if email is taken (present in database)
	if(potentialUser.isPresent()) {
		result.rejectValue("email", "Email already exist please choose diffrent email or login");
	}
	
    // Reject if password doesn't match confirmation
	if(!newUser.getPassword().equals(newUser.getConfirm())) {
		result.rejectValue("password", "Matches", "Passwod must mutch");
	}
		
		 if(result.hasErrors()) {
			 return  null;
		 }
		 
	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
	
		newUser.setPassword(hashed);
		// save the password 
		
    // Hash and set password, save user to database
	return this.uRepo.save(newUser);
    
}
//==================== FIND BY ID  ===================
public UserModel findById(Long id) {
	return this.uRepo.findById(id).orElse(null);
}
//==================== login ================

public UserModel login(LoginValidator newLoginObject, BindingResult result) {
    // TO-DO - Reject values:
    
	// we getting then email from the form that the user provided
	Optional<UserModel> potentialUser = uRepo.findByEmail(newLoginObject.getEmail());

	if(potentialUser.isPresent()) {
		UserModel user = potentialUser.get();
	
		// Reject if BCrypt password match fails
		if(!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
		    result.rejectValue("password", "Matches", "Invalid Password!");
		    return null;
	
	
	}
		return user;
		}
	else {
		if(!newLoginObject.getEmail().equals("")) {
	    result.rejectValue("email", "Matches", "Email is already registered!");
		}
		
		
	    return null;

		
	

}
}}



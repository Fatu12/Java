package com.fatuma.caresoft.clinacapp;

import java.sql.Date;
import java.util.ArrayList;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {

	
//... imports class definition...
    
    // Inside class:
    private String role;
    private ArrayList<String> securityIncidents;
    
    
    AdminUser(Integer id , String role) {
		super(id);
		this.role = role;
		this.securityIncidents = new ArrayList<String>() ;
		// TODO Auto-generated constructor stub
	}
    
    // TO DO: Implement a constructor that takes an ID and a role
    // TO DO: Implement HIPAACompliantUser!
    // TO DO: Implement HIPAACompliantAdmin!
    
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(id), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(id), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
    
    // TO DO: Setters & Getterscopy


	

	@Override
	public boolean assignPin(int pin) {
//		pin must be 6 digits or more; returns false if not expected to assign the pin ton the user 
		// (as a member variables)
		if(pin < 100000 || pin > 999999) {
		
			return false;
		}
		// TODO Auto-generated method stub\
		this.pin = pin;
		
		return false;
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if(this.id !=confirmedAuthID) {
			this.authIncident();
			return false;
		}
		// TODO Auto-generated method stub
		
		return true;
	}
	@Override
	public ArrayList<String> reportSecurityIncidents() {
		// TODO Auto-generated method stub
		return this.securityIncidents;
	}

}

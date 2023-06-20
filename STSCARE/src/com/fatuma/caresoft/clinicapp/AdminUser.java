package com.fatuma.caresoft.clinicapp;

import java.sql.Date;
import java.util.ArrayList;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {

	public AdminUser(Integer id, String role) {
		
		super(id);
		this.role = role;
		// TODO Auto-generated constructor stub
	}
	
//... imports class definition...
    
    // Inside class:
    private String role;
    private ArrayList<String> securityIncidents = new  ArrayList<String> () ;
    
    
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
    
    

	@Override
	public ArrayList<String> reportSecurityIncidents() {
		// TODO Auto-generated method stub
		return null;
	}
	// from abstract classes

	@Override
	public boolean assignPin(int pin) {
		if(pin > 99999 && pin <1000000) {
			this.pin = pin;
			return true;
		}
		return false;
		
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAUTHID) {
		
		if(id.equals(confirmedAUTHID)) {
			this.authIncident();
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

}

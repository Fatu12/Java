package com.fatuma.caresoft.clinicapp;

import java.sql.Date;
import java.util.ArrayList;

public class Physician extends User implements HIPAACompliantUser {	
//... imports class definition...
        // Inside class:    
    private ArrayList<String> patientNotes;
    // TO DO: Constructor that takes an ID
    // TO DO: Implement HIPAACompliantUser!
	public Physician(Integer id) {
      //inhereting  from the user classes
		super(id);
		// TODO Auto-generated constructor stub
	}
	  public void newPatientNotes(String notes, String patientName, Date date) {
	        String report = String.format(
	            "Datetime Submitted: %s \n", date);
	        report += String.format("Reported By ID: %s\n", this.id);
	        report += String.format("Patient Name: %s\n", patientName);
	        report += String.format("Notes: %s \n", notes);
	        this.patientNotes.add(report);
	  }
	// abstract methods from HIPAACompliantUser
	
	// PIN must be exactly 4 digits, returns false if not. Expected to assign the pin to the user 
	//(as a member variable)
	
	@Override
	public boolean assignPin(int pin){
		return (pin > 999 && pin < 10000) ? true : false;
		
	}
	@Override
	public boolean accessAuthorized(Integer confirmedAUTHID) {
		// checks the physician's id against the given id; returns true if they are a match, 
		// otherwise false
		return (this.id.equals(confirmedAUTHID)) ? true : false;
	
	}

	
}

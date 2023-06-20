package com.fatuma.caresoft.clinicapp.oop.classes;

public interface HIPAACompliantUser {
	abstract boolean assignPin(int pin);
    abstract boolean accessAuthorized(Integer confirmedAuthID);

	


}


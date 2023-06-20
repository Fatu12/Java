package com.fatuma.caresoft.clinicapp.oop.classes;

public class User {
	protected Integer id;
	protected int pin;
  //implement a constructor that takes an ID
	public User(int id ) {
		this.id = id;
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	
	 

}

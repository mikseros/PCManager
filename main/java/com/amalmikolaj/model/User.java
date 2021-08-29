package com.amalmikolaj.model;

import java.util.Date;

public class User extends AbstractUser {
	
	public User() {
		
	}
	
	public User(int id, String name, String surname, Date dateOfBirth, String post, String password, String email) {
		super(id, name, surname, dateOfBirth, post, password, email);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void showMachines() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showMachine() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addMachine() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editMyProfile() {
		// TODO Auto-generated method stub
		
	}

	
}

package com.amalmikolaj.model;

import java.util.Date;

public class Admin extends AbstractUser implements AdminInterface {

	Admin(int id, String name, String surname, Date dateOfBirth, String post, String password) {
		super(id, name, surname, dateOfBirth, post, password);
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

	@Override
	public void deleteMachine() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addUser() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyUser() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser() {
		// TODO Auto-generated method stub
		
	}

}

package com.amalmikolaj.model;

import java.util.Date;

public abstract class AbstractUser implements UserInterface{

    int id;
    String name;
    String surname;
    Date dateOfBirth;
    String post;
    String password;
    String email;
    
	AbstractUser() {
		
	}

    AbstractUser(int id, String name, String surname, Date dateOfBirth, String post, String password, String email){

        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.post = post;
        this.password = password;
        this.email = email;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "AbstractUser [id=" + id + ", name=" + name + ", surname=" + surname + ", dateOfBirth=" + dateOfBirth
				+ ", post=" + post + ", password=" + password + ", email=" + email + "]";
	}

	
	

}
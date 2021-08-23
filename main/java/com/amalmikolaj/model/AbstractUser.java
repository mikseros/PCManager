package com.amalmikolaj.model;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public abstract class AbstractUser implements UserInterface{

    int id;
    String name;
    String surname;
    Date dateOfBirth;
    String post;
    StringBuilder password;
    
	protected StringBuilder EncryptPassword(String password) {
		
	    MessageDigest msg = null;
	    StringBuilder s = new StringBuilder();
		try {
			msg = MessageDigest.getInstance("SHA-256");
		    byte[] hash = msg.digest(password.getBytes(StandardCharsets.UTF_8));
		    // convertir bytes en hexadécimal
		    
		    for (byte b : hash) {
		        s.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
		    }
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return s;
		}

    AbstractUser(int id, String name, String surname, Date dateOfBirth, String post, String password){

        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.post = post;
        this.password = EncryptPassword(password);
    }

	public StringBuilder getPassword() {
		return password;
	}

	public void setPassword(StringBuilder password) {
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
		return "User [id=" + id + ", name=" + name + ", surname=" + surname + ", dateOfBirth=" + dateOfBirth
				+ ", post=" + post + "]";
	}
	

}

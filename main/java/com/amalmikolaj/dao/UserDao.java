package com.amalmikolaj.dao;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.amalmikolaj.model.User;
import com.amalmikolaj.model.Workstation;

public class UserDao {

	private Connection connection;

	public UserDao(Connection con) {
		this.connection = con;
	}

	public User getUserById(int id) {
		User user = null;
		String userQuery = ("SELECT * FROM user WHERE user_id = ?;");
		try {
			PreparedStatement ps = connection.prepareStatement(userQuery);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6));
			}

//			ps.close();
//			connection.close();
			//System.out.println(user.toString());
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
		}
		return user;
	}

	enum Post {
		Admin, User
	};
	public StringBuilder EncryptPassword(String password) {
		
	    MessageDigest msg = null;
	    StringBuilder s = new StringBuilder();
		try {
			msg = MessageDigest.getInstance("SHA-256");
		    byte[] hash = msg.digest(password.getBytes(StandardCharsets.UTF_8));
		    // convertir bytes en hexadécimal
		    
		    for (byte b : hash) {
		        s.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
		    }
		    System.out.println(s);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return s;
		}
	public void addUser(User user) {
		String userQuery = "Insert into user (name, surname, date_of_birth, post ,password) VALUES(?,?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(userQuery);
			ps.setString(1, user.getName());
			ps.setString(2, user.getSurname());
			ps.setDate(3, (Date) user.getDateOfBirth());
			ps.setString(4,user.getPost());
			ps.setString(5, EncryptPassword(user.getPassword()).toString());
			ps.executeUpdate();
			//ps.close();
			//connection.close();
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
		}
	}

	public void updateUser(int id, String post) {
		String SQLString = "UPDATE User SET post = ? WHERE user_id = ?;";
		try {
			PreparedStatement ps = connection.prepareStatement(SQLString);
			ps.setString(1, post);
			ps.setInt(2, id);
			ps.executeUpdate();
			ps.close();
			connection.close();
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
		}
	}
	
	public void deleteUser(int id) {
		String SQLString = ("DELETE FROM user WHERE user_id = ?;");
		
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(SQLString);
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
			connection.close();
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
		}
		
	}
}
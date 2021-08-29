package com.amalmikolaj.dao;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.amalmikolaj.UserFrame;
import com.amalmikolaj.LoginFrame;
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
				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7));
			}

//			ps.close();
//			connection.close();
			//System.out.println(user.toString());
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
		}
		return user;
	}
	
	public User getUserByMail(String mail) {
		User user = null;
		String userQuery = ("SELECT * FROM user WHERE mailAdress = ?;");
		try {
			PreparedStatement ps = connection.prepareStatement(userQuery);
			ps.setString(1, mail);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7));
			}

		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
		}
		return user;
	}

	enum Post {
		Admin, User
	};
	private StringBuilder EncryptPassword(String password) {
		
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
	public void addUser(User user) {
		String userQuery = "Insert into user (name, surname, date_of_birth, post ,password, mailAdress) VALUES(?,?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(userQuery);
			ps.setString(1, user.getName());
			ps.setString(2, user.getSurname());
			ps.setDate(3, (Date) user.getDateOfBirth());
			ps.setString(4,user.getPost());
			ps.setString(5, EncryptPassword(user.getPassword()).toString());
			ps.setString(6, user.getEmail());
			ps.executeUpdate();
			ps.close();
			//connection.close();
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
		}
	}
	
	public void modifyUser(User user, String mail) throws Exception{
		
			String modify = "UPDATE user SET name = ?, surname = ?, date_of_birth = ?, "
					+ "post = ?, password =?, mailAdress = ? WHERE mailAdress = ?";
			PreparedStatement ps = connection.prepareStatement(modify);
			ps.setString(1, user.getName());
			ps.setString(2, user.getSurname());
			ps.setDate(3, (java.sql.Date) user.getDateOfBirth());
			ps.setString(4, user.getPost());
			ps.setString(5, EncryptPassword(user.getPassword()).toString());
			ps.setString(6, user.getEmail());
			ps.setString(7, mail);
			ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Update successful!");
	}
	
	
	public void updateUser(int id, String post) {
		String SQLString = "UPDATE User SET post = ? WHERE user_id = ?;";
		try {
			PreparedStatement ps = connection.prepareStatement(SQLString);
			ps.setString(1, post);
			ps.setInt(2, id);
			ps.executeUpdate();
			ps.close();
			//connection.close();
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
			//connection.close();
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
		}
		
	}
	
	public void login(LoginFrame frame) {
		try {
			String passwordText = frame.passwordField.getText();
			
			try {
				
				StringBuilder  pass = EncryptPassword(passwordText);
				PreparedStatement ps = (PreparedStatement) connection.prepareStatement("SELECT mailAdress, password FROM user WHERE mailAdress=? AND password=?;");
				ps.setString(1, frame.userTextField.getText());
				ps.setString(2, pass.toString());
				//frame.passwordField.getText()
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					frame.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(frame, "Wrong username or password");
					frame.userTextField.setText("");
					frame.passwordField.setText("");
				}
			
			} catch (Exception ex){
				System.out.println(ex.getMessage());
		};
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void checkPost(LoginFrame frame) {
		
		try {
			
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement("SELECT post FROM user WHERE mailAdress = ?;");
			ps.setString(1, frame.userTextField.getText());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				switch(rs.getString("post")) {
				case "user":
					UserFrame uFrame = new UserFrame(frame.userTextField.getText());
					uFrame.setVisible(true);
					break;
				case "admin":
					JOptionPane.showMessageDialog(frame, "Admin panel in progress");
					break;
				}
			}
		} catch (Exception ex){
			System.out.println(ex.getMessage());
		};
	}

}
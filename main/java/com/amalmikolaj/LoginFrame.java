package com.amalmikolaj;

import javax.swing.*;

import com.amalmikolaj.dao.DaoFactory;
import com.amalmikolaj.model.User;
import com.amalmikolaj.*;

import java.awt.*;
import java.awt.event.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;

public class LoginFrame extends JFrame implements ActionListener{
	
	Container container = getContentPane();
	JLabel userLabel = new JLabel("Your e-mail");
	JLabel passwordLabel = new JLabel("PASSWORD");
	public JTextField userTextField = new JTextField();
	public JPasswordField passwordField = new JPasswordField();
	JButton loginButton = new JButton("LOGIN");
	JButton resetButton = new JButton("RESET");
	JCheckBox showPassword = new JCheckBox("SHOW PASSWORD");
	Connection con;
	DaoFactory dao = new DaoFactory();
	User u;
	
	public LoginFrame() {
		
		this.setTitle("PCManager Login");
		this.setVisible(true);
		this.setBounds(10, 10, 370, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		addActionEvent();
	}
	
	public void setLayoutManager() {
		container.setLayout(null);
	}
	
	public void setLocationAndSize() {
		userLabel.setBounds(50, 150, 100, 30);
		passwordLabel.setBounds(50, 220, 100, 30);
		passwordField.setBounds(50, 220, 100, 30);
		userTextField.setBounds(150, 150, 150, 30);
		passwordField.setBounds(150, 220, 150, 30);
		showPassword.setBounds(150, 250, 150, 30);
		loginButton.setBounds(50, 300, 100, 30);
		resetButton.setBounds(200, 300, 100, 30);
	}
	
	public void addComponentsToContainer() {
		container.add(userLabel);
		container.add(passwordLabel);
		container.add(userTextField);
		container.add(passwordField);
		container.add(showPassword);
		container.add(loginButton);
		container.add(resetButton);
	}
	
	public void addActionEvent() {
		
		loginButton.addActionListener(this);
		resetButton.addActionListener(this);
		showPassword.addActionListener(this);
	}
	
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
	
	@Override
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource()==loginButton) {
			dao.getUserDao().login(this);
			dao.getUserDao().checkPost(this);
			//u = dao.getUserDao().getUserByMail(userTextField.getText());
		}
		
		if(e.getSource()==resetButton) {
			userTextField.setText("");
			passwordField.setText("");
		}
		
		if(e.getSource()==showPassword) {
			if(showPassword.isSelected()) {
				passwordField.setEchoChar((char)0);
			} else {
				passwordField.setEchoChar('*');
			}
		}	
	}
	

}

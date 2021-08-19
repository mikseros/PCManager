package com.amalmikolaj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {

	private Connection con;
	private String uname = "xxx";
	private String pass = "12345";
	
	public DaoFactory() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcmanager", uname, pass);
	}
	
	public UserDao getUserDao() {
		 return new UserDao(con);
	}
	
	public WorkstationDao getWorkstationDao() {
		return new WorkstationDao(con);
	}
}

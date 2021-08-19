package com.amalmikolaj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.amalmikolaj.model.*;

public class WorkstationDao {
	
	private Connection connection;
	
	public WorkstationDao(Connection con) {
		this.connection = con;
	}
	
	public Workstation getWorkstation(int id) throws Exception {
		
		Workstation w = new Workstation();
		String pcQuery = ("SELECT * FROM pc WHERE id = ?;");
		PreparedStatement ps = connection.prepareStatement(pcQuery);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			w = new Workstation(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
				rs.getString(6), rs.getString(7), rs.getBoolean(8), rs.getString(9), rs.getDate(10));
		}
		ps.close();
		connection.close();
		System.out.println(w.toString());
		return w;
	}
	
	public List<Workstation> showAllMachines() throws Exception {
		
		List<Workstation> PCList= new ArrayList<Workstation>();
		String query = "SELECT * FROM pc;";
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			Workstation w = new Workstation(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6), rs.getString(7), rs.getBoolean(8), rs.getString(9), rs.getDate(10));
			PCList.add(w);
		}
		st.close();
		connection.close();
		System.out.println(PCList);
		return PCList;
		
	}
	
	public Workstation addWorkstation(int id, String brand, String model, String tag, String studentName, String studentSurname, String course, boolean cheque, String returnComment, Date dateOfBorrow) throws Exception{
		
		Workstation w = new Workstation();
		String newPC = ("INSERT INTO pc (brand, model, tag, studentName, studentSurname, course, cheque, returnComment, dateOfBorrow) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);");
		PreparedStatement ps = connection.prepareStatement(newPC);
		ps.setString(2, brand);
		ps.setString(3, model);
		ps.setString(4, tag);
		ps.setString(5, studentName);
		ps.setString(6, studentSurname);
		ps.setString(7, course);
		ps.setBoolean(8, cheque);
		ps.setString(9, returnComment);
		ps.setDate(10, (java.sql.Date) dateOfBorrow);
		
		ps.executeUpdate();
		
		if (ps.executeUpdate() == 1) {
			System.out.println("New PC added");
		} else {
			System.out.println("Something went wrong...");
		}
		ps.close();
		connection.close();
		System.out.println(w);
		return w;
	}
	
	public void deletePC(int id) throws Exception{
			
			String deletePC = ("DELETE FROM pc WHERE id = ?;");
			
			PreparedStatement ps = connection.prepareStatement(deletePC);
			ps.setInt(1, id);
			ps.executeUpdate();
			
			if (ps.executeUpdate()== 1) {
				System.out.println("1 row affected");
			} else {
				System.out.println("0 rows affected");
			}
			ps.close();
			connection.close();
	}
 }

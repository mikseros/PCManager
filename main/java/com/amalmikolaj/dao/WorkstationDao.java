package com.amalmikolaj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.amalmikolaj.model.*;

public class WorkstationDao {
	
	private Connection connection;
	
	public WorkstationDao(Connection con) {
		this.connection = con;
	}
	
	public Workstation getWorkstation(int id) throws Exception {
		
		Workstation w = new Workstation();
		String pcQuery = ("SELECT * FROM pc WHERE PC_id = ?;");
		PreparedStatement ps = connection.prepareStatement(pcQuery);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			w = new Workstation(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
				rs.getString(6), rs.getString(7), rs.getString(8), rs.getBoolean(9), rs.getString(10));
		}
		ps.close();
		connection.close();
		return w;
	}
	
	public List<Workstation> showAllMachines() throws Exception {
		
		List<Workstation> PCList = new ArrayList<Workstation>();
		String query = "SELECT * FROM pc;";
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			Workstation w = new Workstation(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6), rs.getString(7), rs.getString(8), rs.getBoolean(9), rs.getString(10));
			PCList.add(w);
		}
		st.close();
		connection.close();
		return PCList;
		
	}
	
	public Workstation addWorkstation(String brand, String model, String tag, String studentName, String studentSurname, String course, String dateOfBorrow, boolean cheque, String returnComment) throws Exception {
		
		//Workstation w = new Workstation();
		String newPC = ("INSERT INTO pc (brand, model, tag, student_name, student_surname, course, date_of_borrow, cheque, return_comment) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);");
		PreparedStatement ps = connection.prepareStatement(newPC);
		ps.setString(1, brand);
		ps.setString(2, model);
		ps.setString(3, tag);
		ps.setString(4, studentName);
		ps.setString(5, studentSurname);
		ps.setString(6, course);
		ps.setString(7, dateOfBorrow);
		ps.setBoolean(8, cheque);
		ps.setString(9, returnComment);
		try {
		if(ps.executeUpdate()==1) {
			System.out.println("1 row affected");
		}else {
			System.out.println("Something went wrong...");
		};
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		ps.close();
		connection.close();
		
		return null;
	}
	
	public void deletePC(int id) throws Exception{
			
			String deletePC = ("DELETE FROM pc WHERE PC_id = ?;");
			
			PreparedStatement ps = connection.prepareStatement(deletePC);
			ps.setInt(1, id);
			try {
				if(ps.executeUpdate()==1) {
					System.out.println("1 row deleted");
				}else {
					System.out.println("Something went wrong...");
				};
				} catch (Exception e){
					System.out.println(e.getMessage());
				}
			ps.close();
			connection.close();
	}
 }

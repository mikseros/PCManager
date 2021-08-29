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
	
	public Workstation getWorkstationById(int id) throws Exception {
		
		Workstation w = new Workstation();
		String pcQuery = ("SELECT * FROM pc WHERE pc_id = ?;");
		PreparedStatement ps = connection.prepareStatement(pcQuery);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			w = new Workstation(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
				rs.getString(6), rs.getString(7), rs.getDate(8), rs.getBoolean(9), rs.getString(10));
		}
		ps.close();
		//connection.close();
		//System.out.println(w.toString());
		return w;
	}
	
	public List<Workstation> showAllMachines() throws Exception {

        List<Workstation> PCList = new ArrayList<Workstation>();
        String query = "SELECT * FROM pc;";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        while(rs.next()) {
            Workstation w = new Workstation(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                    rs.getString(6), rs.getString(7), rs.getDate(8), rs.getBoolean(9), rs.getString(10));
            PCList.add(w);
        }
        st.close();
        //connection.close();
        return PCList;

    }
	
	public void addWorkstation(Workstation workStation) throws Exception{
		
		
		String newPC = ("INSERT INTO pc (brand, model, tag, student_Name, student_Surname, course, date_Of_Borrow, cheque, return_Comment) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);");
		try
		{
		PreparedStatement ps = connection.prepareStatement(newPC);
		ps.setString(1, workStation.getBrand());
		ps.setString(2, workStation.getModel());
		ps.setString(3, workStation.getTag());
		ps.setString(4, workStation.getStudentName());
		ps.setString(5, workStation.getStudentSurname());
		ps.setString(6, workStation.getCourse());
		ps.setDate(7, (java.sql.Date) workStation.getDateOfBorrow());
		ps.setBoolean(8, workStation.isCheque());
		ps.setString(9, workStation.getReturnComment());
		
		ps.executeUpdate();
		} catch(SQLException exception) {
			System.out.println(exception.getMessage());
		}
//		ps.close();
//		connection.close();
		System.out.println(workStation);
	
	}
	
	public void deletePC(int id) throws Exception{
			
			String deletePC = ("DELETE FROM pc WHERE pc_id = ?;");
			
			PreparedStatement ps = connection.prepareStatement(deletePC);
			ps.setInt(1, id);
			ps.executeUpdate();
			
			if (ps.executeUpdate()== 1) {
				System.out.println("1 row affected");
			} else {
				System.out.println("0 rows affected");
			}
			//ps.close();
			//connection.close();
	}
 }
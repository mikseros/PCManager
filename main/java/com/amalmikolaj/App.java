package com.amalmikolaj;

import java.sql.Date;

import com.amalmikolaj.dao.*;
import com.amalmikolaj.model.*;

public class App {

	public static void main(String[] args) throws Exception {
		
		//java.sql.Date date = new java.sql.Date(0000-00-00);
		DaoFactory dao = new DaoFactory();
		//Workstation w = new Workstation(0,"hwdp", "hjk", "ZTY845", "", "", "", Date.valueOf("2021-08-05"), false, "");
		//dao.getWorkstationDao().addWorkstation(w);
		//dao.getWorkstationDao().deletePC(6);
		
		//System.out.println(dao.getWorkstationDao().showAllMachines());
		System.out.println(dao.getWorkstationDao().getWorkstationById(1));
		
		//java.sql.Date date = new java.sql.Date(0000-00-00);
		//User user = new User(2,"Camille","Bouhard",date.valueOf("1987-09-30"),"user","1238khh7");
		//dao.getUserDao().addUser(user);
		//System.out.println(dao.getUserDao().getUserById(6));

	}

}

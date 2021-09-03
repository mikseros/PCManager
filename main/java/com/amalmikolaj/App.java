package com.amalmikolaj;

import com.amalmikolaj.dao.*;
import com.amalmikolaj.model.*;

public class App {

	public static void main(String[] args) throws Exception {
		
		DaoFactory dao = new DaoFactory();
		
		//dao.getWorkstationDao().addWorkstation("hwdp", "hjk", "ZTY845", "", "", "", "", false, "");
		//dao.getWorkstationDao().deletePC(21);
		
		//System.out.println(dao.getWorkstationDao().showAllMachines());
		//System.out.println(dao.getWorkstationDao().getWorkstation(3));
		
		java.sql.Date date = new java.sql.Date(0000-00-00);
		User user = new User(2,"Camille","Bouhard",date.valueOf("1987-09-30"),"user","1238khh7");
		dao.getUserDao().addUser(user);
		dao.getUserDao().getUserById(2);

	}

}

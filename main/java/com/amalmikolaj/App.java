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
		dao.getUserDao().getUserById(2);

	}

}

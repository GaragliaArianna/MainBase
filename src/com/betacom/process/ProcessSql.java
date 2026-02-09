package com.betacom.process;

import com.betacom.interfaces.ProcessInterface;
import com.betacom.services.ServicesQuery;
import com.betacom.singleton.SQLConfiguration;

public class ProcessSql implements ProcessInterface {

	@Override
	public boolean execute() throws Exception {
		System.out.println("Begin process SQL");
		
		try {
			SQLConfiguration.getInstance().getConnection();
			System.out.println("Connection with DB OK");
			
			new ServicesQuery().executeQuery();
			
	
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		return false;
	}

}

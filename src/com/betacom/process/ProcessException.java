package com.betacom.process;

import com.betacom.exceptions.AcademyException;
import com.betacom.interfaces.ProcessInterface;
import com.betacom.objects.User;

public class ProcessException implements ProcessInterface { 
	
	public boolean execute() throws Exception, AcademyException { 
		System.out.println("Begin ProcessException");
		
		int p1=10;
		int p2=1;
		
		try {
			
			int res=p1/p2;
			
		} catch(ArithmeticException e) {
			System.out.println("Abbiamo avuto un errore"+e.getMessage());	
			e.printStackTrace();
		}
		
		User usr= new User();
		usr.setNome("Bruno");
		usr.setCognome("Rossi");
		//usr.setSesso(true);
		ValidationUser v=new ValidationUser();
		
		try {
			v.checkUser(usr);
		} catch (AcademyException e) {
			throw new AcademyException("errore nella validazione");
		}
		
		System.out.print("User validato correttamente");
		
		
		
		return true;
	}

}

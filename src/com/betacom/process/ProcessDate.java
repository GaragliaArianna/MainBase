package com.betacom.process;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.betacom.interfaces.ProcessInterface;
import com.betacom.objects.User;
import com.betacom.utils.Utilities;

public class ProcessDate implements ProcessInterface{
	
	private final static String PATTERN_DATA = "dd/MM/yyyy";
	private final static String PATTERN_DATA_ESTESO= "EEEE dd MMMM yyyy";
	private final static String PATTERN_DATA_ORA= "HH:mm:ss";
	private final static String PATTERN_DATA_ESTESO_GIORNO= "EEEE dd MMMM yyyy HH:mm:ss";
	//https://docs.fact-finder.com/docs/basic-settings/fields/date-format-patterns
	
	public boolean execute() throws Exception {
		System.out.println("Begin ProcessDate");
		
		//LocalDate adesso = LocalDate.now();
		LocalDateTime adesso = LocalDateTime.now();
		
		System.out.print("Adesso siamo al "+ Utilities.dateToString(PATTERN_DATA, adesso));
		
		System.out.print("Adesso siamo al "+ Utilities.dateToString(PATTERN_DATA_ESTESO, adesso));
		
		/*
		 * date in User
		 */
		
		LocalDate u=LocalDate.parse("1978-10-05");
		
		User usr=new User("Marco", "Verde", "M", u);
		System.out.println("usr");
		
		//usr2=new User("Anna", "Bianco", "F", 2000, 3, 10);
		//System.out.print(usr2);
		
		/*
		int plusGiorni = 25;
		usr.setDataNascita(usr.getDataNascita().plusDays(plusGiorni));
		System.out.println("Data di nascita: "+ Utilities.dateToString(PATTERN_DATA, usr.getDataNascita()));
		
		*/
		
		String dateParam="02/01/2026";
		
		usr.setDataCerticatMedico(Utilities.stringToDate(PATTERN_DATA, dateParam));
		usr.setMeseDiValidita(12);
		System.out.println(usr);
		
		/*
		 * controllo validità certificato medic
		 */
		LocalDate endDate=usr.getDataCerticatMedico().plusMonths(usr.getMeseDiValidita());
		System.out.println(Utilities.dateToString(PATTERN_DATA, endDate));
		
		if(LocalDate.now().isAfter(endDate) ){
			System.out.println("certificato medico scaduto "+usr.getDataCerticatMedico());
		}else {
			System.out.println("certificato medico valido "+usr.getDataCerticatMedico());
		}
	
		
		return false;
	}

}

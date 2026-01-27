package com.betacom.process;

import com.betacom.exceptions.AcademyException;
import com.betacom.objects.User;

public class ValidationUser {
	
	public void checkUser (User usr) throws AcademyException {
		if (usr.getNome() == null)	
			throw new AcademyException("Nome non caricato");
		
		if (usr.getCognome() == null)	
			throw new AcademyException("Cognome non caricato");
		
		if (usr.getSesso() == null)	
			throw new AcademyException("Sesso non caricato");
	}

}

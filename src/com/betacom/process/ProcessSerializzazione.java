package com.betacom.process;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.betacom.interfaces.ProcessInterface;
import com.betacom.objects.Address;

public class ProcessSerializzazione implements ProcessInterface{

	@Override
	public boolean execute() throws Exception {
		
		System.out.println("Begin processo serializzazione");
		
		//l'address deve essere comunicato da una JVM all'altra oppure a un'altra applicazione
		Address address= new Address ();
		
		address.setCity("Roma");
		address.setName("Vincenzo Rossi");
		address.setSesso(true);
		address.setStreet("Via Torino");
		
		try {
			
			FileOutputStream fout= new FileOutputStream("/Users/arian/Downloads/file.txt");
			ObjectOutputStream oos= new ObjectOutputStream (fout);
			oos.writeObject(address);
			oos.flush();
			oos.close();
			System.out.println("Object created");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}

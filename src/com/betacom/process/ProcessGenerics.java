package com.betacom.process;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.betacom.interfaces.ProcessInterface;
import com.betacom.objects.GenericResponse;
import com.betacom.objects.Impiegato;
import com.betacom.objects.ImpiegatoStream;
import com.betacom.objects.User;

public class ProcessGenerics implements ProcessInterface{

	@Override
	public boolean execute() throws Exception {
		
		System.out.println("Begin process generics");
		
		/*
		 * UN PARAMETRO T
		 */
		
		List <Impiegato> lI= Stream.of(
				new Impiegato ("Paolo", "Rossi", true, 2000.0),
				new Impiegato ("Pietro", "Verde", true, 1300.0),
				new Impiegato ("Anna", "Giallo", false, 1500.0),
				new Impiegato ("Giuseppe", "Nero", true, 1800.0),
				new Impiegato ("Alex", "Bianco", true, 1400.0),
				new Impiegato ("Cristina", "Grigio", false, 1600.0),
				new Impiegato ("Ugo", "Blu", true, 1200.0),
				new Impiegato ("Maria", "Pastello", false, 1900.0)
				).collect(Collectors.toList()); //se metto solo.toList() è immutabile
		
		/*
		GenericResponse <Impiegato>resp= new GenericResponse <Impiegato>();  //faccio generic response di impiegato
		resp.setRc(true);  //risposta a un servizio
		resp.setMsg("Operazione eseguita");
		resp.setData(lI);
		
		System.out.println(resp);*/
		
		//è IMMUTABILE
		//per renderla modificabile basta scrivere     List<String> result= new ArrayList <String> (List.of( ... ));
		List <User> lU=List.of(
				new User ("Paolo", "Berardo", "M", 2000, 2, 6),
				new User ("Anna", "Bella", "F", 2006, 5, 6),
				new User ("Gianni", "Laverdura", "M", 1998, 8, 14),
				new User ("Maria", "Angela", "F", 2001, 2, 1)
				
				);
		/*
		GenericResponse <User> resp1 =new GenericResponse <User>();  //faccio generic response di user
		resp1.setRc(true);  //risposta a un servizio
		resp1.setMsg("Operazione eseguita");
		resp1.setData(lU);
		System.out.println(resp1);*/
		
		/*
		 * DUE PARAMETRI T e U
		 */
		
		GenericResponse <Impiegato, String>resp= new GenericResponse <Impiegato, String>();  //faccio generic response di impiegato
		resp.setRc(true);  //risposta a un servizio
		resp.setMsg("Operazione eseguita");
		resp.setData(lI);
		
		System.out.println(resp);
		
		ImpiegatoStream inS=new ImpiegatoStream ("test1", "test2");
		
		/*
		GenericResponse <User, Integer> resp1 =new GenericResponse <User, Integer>();  //faccio generic response di user
		resp1.setRc(true);  //risposta a un servizio
		resp1.setMsg(28);
		resp1.setData(lU);
		System.out.println(resp1);*/
		
		GenericResponse <User, ImpiegatoStream> resp1 =new GenericResponse <User, ImpiegatoStream>();  //faccio generic response di user
		resp1.setRc(true);  //risposta a un servizio
		resp1.setMsg(inS);
		resp1.setData(lU);
		System.out.println(resp1);
		
		
		
		return false;
	}

}

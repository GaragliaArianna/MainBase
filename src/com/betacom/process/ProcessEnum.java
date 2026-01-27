package com.betacom.process;

import java.util.ArrayList;

import com.betacom.enums.Reparto;
import com.betacom.exceptions.AcademyException;
import com.betacom.interfaces.ProcessInterface;
import com.betacom.objects.Impiegato;

public class ProcessEnum implements ProcessInterface{
	public boolean execute() throws Exception {
		System.out.println("Begin process ENUM");
		
		String valore="PRODUZIONE";
		Reparto reparto=null;
		
		try {
			reparto= Reparto.valueOf(valore);
			System.out.println("Reparto: "+reparto.toString());
		} catch (IllegalArgumentException e) {
			throw new AcademyException(e.getMessage());
		}
		
		//fai un arraylist di impiegati con reparto inizializzato
		//definire un criterio di selezione, per esempio solo gli impiegati del reparto produzione
		//fare un loop per stampare tutti gli impiegati selezionati
		
		ArrayList <Impiegato> impiegati=new ArrayList <Impiegato> ();
		impiegati.add(new Impiegato ("Roberto", "Rossi", true, 1500.0, "IT"));
		//impiegati.add(new Impiegato ("Roberto", "Rossi", true, 1500.0, "vendite"));
		impiegati.add(new Impiegato ("Roberto", "Verdi", true, 1300.0, "PRODUzIONE"));
		impiegati.add(new Impiegato ("Anna", "Lorusso", false, 1500.0, "PRODUZIONE"));
		impiegati.add(new Impiegato ("Lucia", "Colonna", false, 1800.0, "It"));
		impiegati.add(new Impiegato ("Lorenzo", "Rossi", true, 1400.0, "logistica"));
		impiegati.add(new Impiegato ("Chiara", "Rossi", false, 1400.0, "LOGISTICA"));
		impiegati.add(new Impiegato ("Antonio", "Ragone", true, 1400.0, "PRodUZIONE"));
		
		System.out.println("\nIMPIEGATI REPARTO PRODUZIONE");
		
		String search="PRODUZIONE";
		
		for (Impiegato i: impiegati) {
			if (i.getReparto().toString().equalsIgnoreCase(search))
				System.out.println(i.toString());
		}

		
		return false;
	}

}

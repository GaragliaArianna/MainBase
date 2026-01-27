package com.betacom;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.betacom.exceptions.AcademyException;
import com.betacom.interfaces.ProcessInterface;
import com.betacom.process.ProcessCollection;
import com.betacom.process.ProcessDate;
import com.betacom.process.ProcessEnum;
import com.betacom.process.ProcessException;
import com.betacom.process.ProcessSequential;
import com.betacom.process.ProcessSingletone;
import com.betacom.process.Processnterface;
import com.betacom.process.StringProcess;
/*
 * Le eccezioni checked (controllate) devono essere gestite esplicitamente dal programmatore (con try-catch o throws) perché rappresentano condizioni recuperabili previste (es. file non trovato), mentre le eccezioni unchecked (non controllate, che derivano da RuntimeException) non richiedono gestione obbligatoria e segnalano solitamente errori di programmazione (es. NullPointerException), che il chiamante non può recuperare facilmente. La differenza chiave è che il compilatore Java impone la gestione delle checked, mentre per le unchecked la gestione è opzionale, 
 */
public class MainProcess {
	
	//deve gestire un programma interfaccia

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		//System.out.println("Scrivi un parametro: ");
		//String inp= sc.nextLine();
		String inp="sequential";
		Map <String, ProcessInterface> pr =new HashMap<String, ProcessInterface>();
		pr.put("string", new StringProcess());
		pr.put("exception", new ProcessException());
		pr.put("interface", new Processnterface());
		pr.put("date", new ProcessDate());
		pr.put("enum", new ProcessEnum());
		pr.put("collection", new ProcessCollection());
		pr.put("singletone", new ProcessSingletone());
		pr.put("sequential", new ProcessSequential());
		
		if(pr.containsKey(inp)) {
			ProcessInterface ex=pr.get(inp);
			try {
				ex.execute();
			} catch (AcademyException e) {
				System.out.println("Errore applicativo: "+e.getMessage());
			} catch (Exception e) {
				System.out.println("Abnormal end: "+e.getMessage());
				e.printStackTrace();
			}	
		}
		 else {	
			 System.out.println("Processo non previsto");
		}
		
		/* al posto dello switch usiamo la mappa
		 * ProcessInterface=null;
		switch(inp) {
			case "string": {
				pr=new StringProcess();
				break;
			}
			case "exception": {
				pr=new ProcessException();
				break;
			}

			case "interface": {
				pr=new Processnterface();
				break;
			}
			case "date": {
				pr=new ProcessDate();
				break;
			}
			case "enum": {
				pr=new ProcessEnum();
				break;
			}
			case "collection": {
				pr=new ProcessCollection();
				break;
			}
			case "singleton": {
				pr=new ProcessSingleton();
				break;
			}
			
			default:
				System.out.println("Processo non previsto");
				System.exit(9);
		}
		
		
		try {
			pr.execute();
			System.out.println("Normal end");
		} catch (AcademyException e) {
			System.out.println("Errore applicativo: "+e.getMessage());
		} catch (Exception e) {
			System.out.println("Abnormal end: "+e.getMessage());
			e.printStackTrace();
		}*/
		
		//if ("string".equalsIgnoreCase(inp)) pr=new StringProcess();
		//if ("exception".equalsIgnoreCase(inp)) pr=new ProcessException();
		
	}

}

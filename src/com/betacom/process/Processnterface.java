package com.betacom.process;

import java.util.ArrayList;
import java.util.Scanner;

import com.betacom.exceptions.AcademyException;
import com.betacom.interfaces.Preda;
import com.betacom.interfaces.Predatore;
import com.betacom.interfaces.ProcessInterface;
import com.betacom.interfaces.SampleInterface;
import com.betacom.interfaces.SampleInterface1;
import com.betacom.objects.ClassInterface;
import com.betacom.objects.ClassInterface1;
import com.betacom.objects.animali.Gazzella;
import com.betacom.objects.animali.Leone;
import com.betacom.objects.animali.PescePreda;
import com.betacom.objects.animali.PescePredaPredatore;
import com.betacom.objects.animali.PescePredatore;
import com.betacom.process.ProcessException;
import com.betacom.process.StringProcess;
/*
 * Le eccezioni checked (controllate) devono essere gestite esplicitamente dal programmatore (con try-catch o throws) perché rappresentano condizioni recuperabili previste (es. file non trovato), mentre le eccezioni unchecked (non controllate, che derivano da RuntimeException) non richiedono gestione obbligatoria e segnalano solitamente errori di programmazione (es. NullPointerException), che il chiamante non può recuperare facilmente. La differenza chiave è che il compilatore Java impone la gestione delle checked, mentre per le unchecked la gestione è opzionale, 
 */
public class Processnterface implements ProcessInterface{

	@Override
	public boolean execute() throws Exception {
		System.out.println("Main Interface");
		
		SampleInterface sI = new ClassInterface();
		
		sI.interface1("primo");
		sI.interface2("secondo");
		
		SampleInterface1 sI1= new ClassInterface1();
		sI1.test1("primo");
		sI1.test2("secondo");
		
		SampleInterface1 sII = new ClassInterface();
		sII.test1("pppp");
		sII.test2("zzzz");
		
		ClassInterface cl=new ClassInterface();
		cl.interface1("zzzz");
		cl.interface2("yyyy");
		cl.test1("tttt");
		cl.test2("zzz");
		
		ClassInterface1 cl1=new ClassInterface1();
		cl1.test1("tttt");
		cl1.test2("zzz");
		
		identificate(cl); 	//implementa entrambe
		identificate(cl1); 	//implementa SampleInterface1
		
		ArrayList<Object> lO = new ArrayList<Object>();
		lO.add(cl);
		lO.add(cl1);
		
		System.out.println("\nESEMPIO ARRAYLIST\n");
		
		for (Object obj: lO) {
			if (obj instanceof SampleInterface) {
				SampleInterface oo= (SampleInterface) obj;
				oo.interface1("Da loop");
				oo.interface2("Da loop");
			}
			
			if (obj instanceof SampleInterface1) {
				SampleInterface1 oo= (SampleInterface1) obj;
				oo.test1("Da loop");
				oo.test2("Da loop");
			}
			
		}
		
		System.out.println("\nESEMPIO ANIMALI\n");
		
		PescePredaPredatore p1= new PescePredaPredatore ("Pesce Tigre");
		Leone l1= new Leone();
		Gazzella g1=new Gazzella();
		PescePreda pesceRosso= new PescePreda("Pesce Rosso");
		PescePredatore orca= new PescePredatore("Orca");
		
		ArrayList<Object> animali= new ArrayList <Object> ();
		animali.add(p1);
		animali.add(l1);
		animali.add(g1);
		animali.add(pesceRosso);
		animali.add(orca);
		
		for (Object obj: animali) {
			if (obj instanceof Preda) {
				Preda preda= (Preda) obj;
				preda.sonoUnaPreda();
			}
			
			if (obj instanceof Predatore) {
				Predatore predatore= (Predatore) obj;
				predatore.sonoUnPredatore();
			}
		}
				
		
		return false;
		
		
		

	}
	

	private static void identificate (Object o) {
		if (o instanceof SampleInterface) {
			System.out.println("Object implementa SampleInterface");
		}
		
		if (o instanceof SampleInterface1) {
			System.out.println("Object implementa SampleInterface1 ");
		}
		
	}
}



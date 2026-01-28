package com.betacom.process;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.betacom.interfaces.Azione;
import com.betacom.interfaces.ProcessInterface;
import com.betacom.objects.Impiegato;

public class ProcessAnonima implements ProcessInterface {

	@Override
	public boolean execute() throws Exception {
		System.out.println("Begin ProcessAnonima");
		
		/* senza parametro
		Azione a=new Azione () {
			public void esegui() {
				System.out.println("Azione eseguita");
			}
		};
		
		a.esegui();*/
		
		
		Azione a=new Azione () {
			public void esegui(String param) {
				System.out.println("Azione eseguita " +param);
			}
		};
		
		a.esegui("mio parametro");
		

		
		//trasforma in lamda expression, se abbiamo due metodi nell'interfaccia non si può fare
		Azione l = (param) ->  System.out.println("Azione eseguita " +param);
		
		//più istruzioni
		Azione u = (param) ->  {
			System.out.println("Azione eseguita " +param);
			System.out.println("Seconda istruzione.. ");
		};
		u.esegui("parametro");
		
		//più istruzioni raggruppate in un metodo
		Azione x=(param) -> metodo (param);
		x.esegui("parametro");
		
		
		//interfaccia funzionale
		List <Impiegato> lI= Stream.of(
				new Impiegato("Paolo", "Rossi", true, 1500.0),
				new Impiegato("Lorenzo", "Verdi", true, 1300.0),
				new Impiegato("Francesco", "Lorusso", true, 1200.0),
				new Impiegato("Maura", "Colonna", false, 1500.0),
				new Impiegato("Arianna", "Garaglia", false, 1600.0),
				new Impiegato("Antonio", "Garaglia", true, 2100.0)
				).collect(Collectors.toList());  //lista modificabile
		
		lI.forEach(im -> System.out.println(im));
		
		System.out.println("\n");
		
		/*
		lI.sort(new Comparator<Impiegato>() {
			
			public int compare (Impiegato o1, Impiegato o2) {
				
				return Double.compare(o2.getSalary(), o1.getSalary());
			}
			
		});diventa cosi con le lamda expression: */
		
		lI.sort ((Impiegato o1, Impiegato o2) -> Double.compare(o2.getSalary(), o1.getSalary()));
		
		lI.forEach(im -> System.out.println(im));
		
		return false;
	}
	
	private void metodo (String param) {
		System.out.println("Azione eseguita con parametro: " +param);
		System.out.println("Seconda istruzione.. ");
	}

}

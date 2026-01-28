package com.betacom.process;

import java.util.ArrayList;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.betacom.interfaces.ProcessInterface;
import com.betacom.objects.Impiegato;
import com.betacom.objects.ImpiegatoStream;

public class ProcessStream implements ProcessInterface{

	@Override
	public boolean execute() throws Exception {
		System.out.println("Begin process stream");
		
		/*
		Stream <Impiegato> streamImpiegato=Stream.of(
				new Impiegato("Paolo", "Rossi", true, 1500.0),
				new Impiegato("Lorenzo", "Verdi", true, 1300.0),
				new Impiegato("Francesco", "Lorusso", true, 1200.0),
				new Impiegato("Maura", "Colonna", false, 1500.0),
				new Impiegato("Arianna", "Garaglia", false, 1600.0),
				new Impiegato("Antonio", "Garaglia", true, 1600.0)
				);
		
		System.out.println(streamImpiegato.count());*/
		
		//con la lista
		List <Impiegato> impiegati= Stream.of(
				new Impiegato("Paolo", "Rossi", true, 1500.0),
				new Impiegato("Lorenzo", "Verdi", true, 1300.0),
				new Impiegato("Francesco", "Lorusso", true, 1200.0),
				new Impiegato("Maura", "Colonna", false, 1500.0),
				new Impiegato("Arianna", "Garaglia", false, 1600.0),
				new Impiegato("Antonio", "Garaglia", true, 2100.0)
				).collect(Collectors.toList()); //oppure semplicemente .toList();
		
		System.out.println("Size della lista "+ impiegati.size());
		impiegati.forEach(imp -> System.out.println(imp));
		
		/*
		 * create stream with builder
		 */
		Stream <String> streamBuilder= Stream.<String> builder() 
				.add("lunedi")
				.add("martedi")
				.add("mercoledi")
				.add("giovedi")
				.add("venerdi")
				.add("sabato")
				.add("domenica")
				.build();
		
		//System.out.println("Stream builder lunghezza "+ streamBuilder.count());
		
		String [] giorni=streamBuilder.toArray(size -> new String [size]);
		
		System.out.println("Lunghezza array stringhe"+ giorni.length+ " giorno [4]="+giorni[4]);
		
		/*
		 * Creazione random
		 */
		
		Random ran=new Random();
		Stream <Integer> sR= Stream.generate(() -> ran.nextInt()).limit(10);
		sR.forEach(n -> System.out.println(n));
		
		/*
		 * generazione dati primitivi
		 */
		System.out.println("Generazione interi con range");
		IntStream intStream =IntStream.range(3, 15);
		intStream.forEach(i -> System.out.println(i));
		
		/*
		 * filtro usando stream, seleziono gli uomini
		 */
		impiegati.stream()
			.filter(im -> im.getSesso())
			.filter(im -> im.getSalary() >= 2000.0)
			.forEach(im -> System.out.println(im));
		
		/*
		 * map (contenente il nome e il cognome) degli impiegati maschi e con stipendio >=2000
		 */
		System.out.println("map");
		
		List <ImpiegatoStream> impiegatiStream = impiegati.stream()
				.filter(im -> im.getSesso())
				.filter(im -> im.getSalary() >= 2000.0)
				.map(imp -> new ImpiegatoStream (imp.getNome(), imp.getCognome()))
				.toList();
		
		impiegatiStream.forEach(i -> System.out.println(i));
		
		/*
		 * Count
		 */
		System.out.println("count");
		long count=impiegati.stream()
				.filter(im -> im.getSesso())
				.count();
		
		System.out.println("Numero di impiegati maschi: "+count);
		
		/*
		 * match
		 */
		boolean rc= impiegati.stream()
				.filter(im -> !im.getSesso())
				.anyMatch(im -> im.getNome().startsWith("A"));
		
		System.out.println("Risultato del match: "+rc);
		
		
		return false;
	}

}

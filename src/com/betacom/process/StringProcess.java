package com.betacom.process;

import java.util.StringTokenizer;

import com.betacom.interfaces.ProcessInterface;

public class StringProcess implements ProcessInterface{
	
	public boolean execute () throws Exception {
		System.out.println("Begin StringProcess");
		String nome = "Gerard";
		StringBuilder sb= new StringBuilder();
		/*
		 * build della stringa con append
		 */
		sb.append("Buongiorno");
		sb.append(", ");
		sb.append("sono ");
		sb.append(nome);
		
		String rS=sb.toString();
		System.out.println(rS);
		
		/*
		 * build della stringa con String format
		 */
		String n = "Francese";
		String r= String.format("Mio nome e' %s, e sono %s", nome, n);
		System.out.println(r);
		
		if (nome.equalsIgnoreCase("Gerard"))
			System.out.println("Found"+nome);
		
		if (rS.contains(","))
			System.out.println("Trovata virgola");
		else
			System.out.println("Non e' stata trovata una virgola");
		
		String test= "    ".trim();
		if (test.isEmpty())   //oppure isBlanck
			System.out.println("Stringa vuota");
		
		/*
		 * String compare
		 * confronta due oggetti (spesso stringhe, ma anche numeri) lessicograficamente (alfabeticamente) o numericamente, restituendo un intero: negativo se il primo è minore, zero se uguale, positivo se maggiore, basandosi sui valori Unicode dei caratteri o sui valori numerici
		 */
		
		String p1="Samsung";
		String p2="Samsunhhg";
		int result=p2.compareTo(p1);
		System.out.println("compare: "+result); //restituisce 0 se è uguale, diverso a 0 stringhe non uguali
		
		/*
		 * trasformazione da integer a stringa
		 */
		int numero=20;
		String numeroStr=String.valueOf(numero);
		System.out.println("Numero string: "+numero);
		
		/*
		 * Trasformazione da stringa e intero
		 */
		numeroStr="23456";
		int numero1=Integer.parseInt(numeroStr);
		numero1++;
		System.out.println("Valore di numero: "+ numero1);
		
		/*
		 * Trasformazione di una stringa in array
		 */
		String parametri="token1, token2, token3, token4 "; //mettere lo spazio dopo la virgola
		String[] tokens=parametri.split(",");
		for (String it:tokens) {
			System.out.println("<"+it+">");  //per togliere lo spazio usa it.trim()
		}
		
		/*
		 * StringTokenizer
		 */
		StringTokenizer st= new StringTokenizer (parametri, ",");
		
		while(st.hasMoreTokens()) {
			String txt=st.nextToken().trim();
			System.out.println("<"+txt+">");
		}
		
		System.out.println(r.substring(5)); //mostra dal quinto carattere in poi
		System.out.println(r.substring(11, 17));
		
		System.out.println(r.substring(r.indexOf("G"))); //parte da dove trova la prima G
		System.out.println(r.substring(r.indexOf("G"), r.indexOf(",")));
		
		String prova = "questo è un test per il linguaggio ££, Vediamo ££ il risultato";
		String provaR=prova.replace("££", "Java"); //esiste replaceFirst,replaceAll attenzione ai caratteri speciali come il dollaro
		
		System.out.println(provaR);
		
		
		
		
		
		return true;
	}

}

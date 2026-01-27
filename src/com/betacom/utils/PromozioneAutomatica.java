package com.betacom.utils;

public class PromozioneAutomatica {
	
	//definizione costante, con final la "variabile/costante" non può più essere modificata	
	private static final Integer MAX_USER=10;
	
	//static per rendere il metodo comune a tutte le classi
	//l'istanza viene fatta dalla java virtual machine
	
	//overload del metodo method
	public static void method (int i) {
		System.out.println("Sono un integer con il valore: "+i);
	}
	
	public static void method (double i) {
		System.out.println("Sono un double con il valore: "+i);
	}
	
	public static void method (Object i) {
		System.out.println("Sono un Object con il valore: "+i);
	}
	

}

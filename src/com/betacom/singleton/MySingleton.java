package com.betacom.singleton;

public class MySingleton {
	
	private static MySingleton instance = null;
	
	private Integer idx=0;
	
	//costruttore PRIVATO così non viene istanziato da altre classi 
	private MySingleton () {
		
	}
	
	//statico perchè ci deve essere solo una istanza di questa classe
	public static MySingleton getInstance ( ) {
		if (instance == null) {
			instance = new MySingleton();
		}
		return instance;
	}
	
	public Integer computeIndice() {
		return ++idx;
	}

}

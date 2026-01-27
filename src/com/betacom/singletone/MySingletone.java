package com.betacom.singletone;

public class MySingletone {
	
	private static MySingletone instance = null;
	
	private Integer idx=0;
	
	//costruttore PRIVATO così non viene istanziato da altre classi 
	private MySingletone () {
		
	}
	
	//statico perchè ci deve essere solo una istanza di questa classe
	public static MySingletone getInstance ( ) {
		if (instance == null) {
			instance = new MySingletone();
		}
		return instance;
	}
	
	public Integer computeIndice() {
		return ++idx;
	}

}

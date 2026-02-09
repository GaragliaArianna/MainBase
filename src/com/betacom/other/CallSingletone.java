package com.betacom.other;

import com.betacom.singleton.MySingleton;

public class CallSingletone {
	
	public void test () {
		Integer i=MySingleton.getInstance().computeIndice();
		System.out.println("Valore di indice dentro call singletone: "+i);
	}

}

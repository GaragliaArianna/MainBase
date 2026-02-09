package com.betacom.process;

import com.betacom.interfaces.ProcessInterface;
import com.betacom.other.CallSingletone;
import com.betacom.singleton.MySingleton;

public class ProcessSingletone implements ProcessInterface{

	@Override
	public boolean execute() throws Exception {
		System.out.println("Begin ProcessSingletone");
		
		// MySingletone aa= new MySingletone(); NON si fa!!  (il costruttore è privato)
		Integer idx = MySingleton.getInstance().computeIndice();
		System.out.println("Valore indice: "+idx);
		
		new CallSingletone().test();
		
		return false;
	}
	

}

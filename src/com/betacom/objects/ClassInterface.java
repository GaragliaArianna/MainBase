package com.betacom.objects;

import com.betacom.interfaces.SampleInterface;
import com.betacom.interfaces.SampleInterface1;

public class ClassInterface implements SampleInterface, SampleInterface1 {

	@Override
	public void interface1(String p) {

		System.out.println("Implementazione interfaccia 1 da ClassInterface  p: "+ p);
		
	}

	@Override
	public void interface2(String p) {
		
		System.out.println("Implementazione interfaccia 2 da ClassInterface  p: "+p);
		
	}
	
	@Override
	public void test1(String t1) {
		System.out.println("execute test 1 da ClassInterface p: "+t1);
		
	}

	@Override
	public void test2(String t2) {
		System.out.println("execute test 2 da ClassInterface p: "+t2);
		
	}

}

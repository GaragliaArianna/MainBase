package com.betacom.process;

import com.betacom.interfaces.ProcessInterface;

public class ProcessThread implements ProcessInterface{

	@Override
	public boolean execute() throws Exception {
		
		System.out.println("Begin process thred");	
		
		Thread t = new Thread (new MioRunnable ());
		
		MioSecondoRunnable r=new MioSecondoRunnable ();
		
		Thread t1 = new Thread (r);
		
	
		t.start();
		t1.start();
		
		System.out.println("Threads are started...");	
		
		Thread.sleep(3+1000);
		
		r.chiudi();
		
		return false;
	}




}

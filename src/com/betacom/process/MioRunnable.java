package com.betacom.process;

public class MioRunnable implements Runnable{

	@Override
	public void run() {

		for (int i=0; i<=10; i++) {
			System.out.println("Runnable in esecuzione" + i);
		}
		
		System.out.println("****fine del thread Mio runnavle");
	}

}

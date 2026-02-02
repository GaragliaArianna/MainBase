package com.betacom.process;

public class MioSecondoRunnable implements Runnable{
	
	private boolean attivo=true;
	public void chiudi () {
		attivo=false;
	}

	@Override
	public void run() {
		
		while (attivo) {
			
			System.out.println("Thread Mio secondo runnable in esecuzione");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				attivo=false;
			}
		}
		
		/*
		for (int i=0; i<=10; i++) {
			System.out.println("Mio secondo Runnable in esecuzione" + i);
		}
		
		try { 
			Thread.sleep(4+1000);   //lo faccio fermare per 2 secondi
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		
		for (int i=10; i<=15; i++) {
			System.out.println("Mio secondo Runnable in esecuzione" + i);
		}*/
		
		System.out.println("******Fine del mio secondo thread" );
		
	}

}

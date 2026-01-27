package com.betacom;

import com.betacom.objects.BMW;
import com.betacom.objects.Fiat500;

public class MainAbstract {
	
	public static void main (String [] args) {
		System.out.println("Begin MainAbstract");
		
		Fiat500 fiat=new Fiat500();
		fiat.setColor("Nero");
		fiat.setMaxSpeed(180);
		fiat.setModel("fiat 500");
		
		fiat.frena();
		fiat.accelera();
		
		System.out.println("Model : "+ fiat.getModel());
		
		BMW bmw=new BMW ();
		bmw.setColor("Bianca");
		bmw.setMaxSpeed(250);
		bmw.setModel("M3");
		
		bmw.frena();
		bmw.accelera();
		
		System.out.println("Model: "+bmw.getModel());
		
	}

}

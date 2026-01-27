package com.betacom.objects.animali;

import com.betacom.interfaces.Preda;
import com.betacom.interfaces.Predatore;

public class PescePredaPredatore extends Pesce implements Predatore, Preda{

	public PescePredaPredatore(String specie) {
		super(specie);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sonoUnaPreda() {
		System.out.println("Implementazione del metodo 'sono una preda' dalla classe PESCE, specie: "+super.getSpecie());
		
	}

	@Override
	public void sonoUnPredatore() {
		System.out.println("Implementazione del metodo 'sono un predatore' dalla classe PESCE, specie: "+super.getSpecie());
		
	}

}

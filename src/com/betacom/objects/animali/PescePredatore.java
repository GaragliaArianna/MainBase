package com.betacom.objects.animali;

import com.betacom.interfaces.Predatore;

public class PescePredatore extends Pesce implements Predatore{

	public PescePredatore(String specie) {
		super(specie);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sonoUnPredatore() {
		System.out.println("Implementazione del metodo 'sono un predatore' dalla classe PESCE, specie: "+super.getSpecie());
		
	}

}

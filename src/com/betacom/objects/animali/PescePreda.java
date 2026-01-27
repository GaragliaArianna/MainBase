package com.betacom.objects.animali;

import com.betacom.interfaces.Preda;

public class PescePreda extends Pesce implements Preda {

	public PescePreda(String specie) {
		super(specie);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sonoUnaPreda() {
		System.out.println("Implementazione del metodo 'sono una preda' dalla classe PESCE, specie: "+super.getSpecie());
		
	}

}

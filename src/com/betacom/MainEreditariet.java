package com.betacom;

import com.betacom.objects.Impiegato;

public class MainEreditariet {

	public static void main(String[] args) {
		System.out.println("Begin MainEreditariet");
		
		Impiegato imp=new Impiegato("Gianni", "Laverdura", true, 1500.0);
		
		System.out.println(imp); 
		
		imp=new Impiegato();
		imp.setCognome("Bianco");
		imp.setNome("Bruno");
		imp.setSesso(true);
		imp.setSalary(1300.00);
		
		System.out.println(imp); //esegue quello della classe derivata prima e poi quello della classe padre
		
		System.out.println(imp.getSesso());

	}

}

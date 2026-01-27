package com.betacom.objects;

import com.betacom.enums.Reparto;
import com.betacom.exceptions.AcademyException;

public class Impiegato extends User {
	
	private Double salary;
	private Reparto reparto;
	

	public Impiegato() {
		super();
	}

	public Impiegato(String nome, String cognome, Boolean sesso, Double salary) {
		super(nome, cognome, sesso);
		this.salary=salary;
	}
	
	public Impiegato(String nome, String cognome, Boolean sesso, Double salary, String reparto) throws AcademyException {
		super(nome, cognome, sesso);
		this.salary=salary;
		
		try {
			reparto=reparto.toUpperCase();
			Reparto repartoEnum= Reparto.valueOf(reparto);
			this.reparto=repartoEnum;
		} catch (IllegalArgumentException e) {
			throw new AcademyException(e.getMessage());
		}
	}
	

	public Reparto getReparto() {
		return reparto;
	}

	public void setReparto(Reparto reparto) {
		this.reparto = reparto;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	/*
	@Override
	public Boolean getSesso() {
		System.out.println("Il sesso e': "+ (super.getSesso() ? "Maschio": "Femmina"));
		return super.getSesso();
	}*/


	@Override
	public String toString() {
		String resp="Impiegato [salario="+getSalary();
		if (reparto != null) {
			//visualizzare reparto come stringa
			resp=resp + ", reparto="+getReparto().toString();
		}
		resp=resp+", getSesso()=" + getSesso() + ", getNome()=" + getNome()
		+ ", getCognome()=" + getCognome() + "]";
			
		return resp;
	}
	
	
	

}

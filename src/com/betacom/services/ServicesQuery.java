package com.betacom.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.betacom.dao.DipendentiDAO;
import com.betacom.exceptions.AcademyException;
import com.betacom.models.Dipendenti;
import com.betacom.singleton.SQLConfiguration;
import com.betacom.utils.SQLManager;

public class ServicesQuery {
	
	private SQLManager db= new SQLManager();
	private DipendentiDAO dao= new DipendentiDAO ();
	
	public void executeQuery() throws AcademyException {
		listTable();
		getAllDipendenti();
		getDipendentiWithParameters("impiegato");
		getDipendentiWithParameters("impiegato", 1);
		getDipendenteById(1);  //optional
		getCount("impiegato");  //count su una query		
	}
	private void listTable() throws AcademyException {
		List<String> lT=db.listOfTable("db_academy_01_2026");
		lT.forEach(t -> System.out.println(t));
	}
	
	private void getAllDipendenti() throws AcademyException {
		System.out.println("*****getAll Dipendenti");
		String query=SQLConfiguration.getInstance().getQuery("query.dipendenti");
		System.out.println(query);
		/*
		List<Map<String, Object>> res=db.list(query);
		
		System.out.println("Numero di righe: "+ res.size());
		
		for(Map<String, Object> it: res) {
			System.out.println(it.get("nome")+ " " + it.get("cognome") );

		}*/
		
		try {
			List <Dipendenti> lD=dao.findAll();
			lD.forEach(l -> System.out.println(l));
		} catch (Exception e) {
			System.out.println("Error found: "+e.getMessage());
		}
	}
		
	private void getDipendentiWithParameters(String param) {
		System.out.println("*****getAll Dipendenti con parametro");
		try {
			List <Dipendenti> lD=dao.findGeneric("query.dipendenti.mansione", new Object[] {
					param
			});
			lD.forEach(d -> System.out.println(d));
		} catch (Exception e) {
			System.out.println("Error found: "+e.getMessage());
		}
	}
	
	private void getDipendentiWithParameters(String param, Integer uff) {
		System.out.println("*****getAll Dipendenti con ufficio");
		try {
			List <Dipendenti> lD=dao.findGeneric("query.dipendenti.ufficio", new Object[] {
					param, uff
			});
			lD.forEach(d -> System.out.println(d));
		} catch (Exception e) {
			System.out.println("Error found: "+e.getMessage());
		}
	}
	
	private void getDipendenteById(Integer id) {
		System.out.println("*****get Dipendente by id");
		try {
			Optional <Dipendenti> dip=dao.findById(new Object[] {id});
			if (dip.isEmpty())  
				System.out.println("Dipendente non trovato: "+id);
			else
				System.out.println(dip.get());
		} catch (Exception e) {
			System.out.println("Error found: "+e.getMessage());
		}
	}
	
	private void getCount(String param) {
		System.out.println("*****getAll Dipendenti con parametro");
		try {
			Long c=dao.count("query.dipendenti.mansione", new Object[] {
					param
			});
			System.out.println("count  "+c);
		} catch (Exception e) {
			System.out.println("Error found: "+e.getMessage());
		}
	}
	
	
}

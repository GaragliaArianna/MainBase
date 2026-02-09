package com.betacom.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.betacom.models.Dipendenti;
import com.betacom.singleton.SQLConfiguration;
import com.betacom.utils.SQLManager;

public class DipendentiDAO {
	
	private SQLManager db=new SQLManager();
	
	public List<Dipendenti> findAll() throws Exception {
		
		String query=SQLConfiguration.getInstance().getQuery("query.dipendenti");
		System.out.println(query);
		List<Map<String, Object>> lD=db.list(query);
		
		return resultToObject(lD);
	}
	
	public List<Dipendenti> findGeneric(String qryName, Object [] params) throws Exception {
		String query=SQLConfiguration.getInstance().getQuery(qryName);
		System.out.println(query);
		
		List<Map<String, Object>> lD=db.list(query, params);
		
		return resultToObject(lD);
		

		
	}
	
	public Long count(String qryName, Object[] params) throws Exception {
		String query=SQLConfiguration.getInstance().getQuery(qryName);
		System.out.println(query);
		
		return db.count(query, params);
	}
	
	public Optional<Dipendenti> findById (Object[]params) throws Exception {
		String query=SQLConfiguration.getInstance().getQuery("query.dipendenti.byId");
		System.out.println(query);
 
		Map<String, Object> di=db.get(query, params);
		
		if(di == null) {
			return Optional.empty();
		}
		
		return Optional.ofNullable(new Dipendenti(
				 (Integer)di.get("id_dipendente"), 
				 (String)di.get("nome"), 
				 (String)di.get("cognome"), 
				 null, //LocalDate    dateToLocalDate(di.get("data_assunzione")),
				 (String)di.get("telefono"), 
				 (String)di.get("mansione"), 
				 ((BigDecimal)di.get("stipendio")).doubleValue(), 
				 (Integer)di.get("id_ufficio"), 
				 (String)di.get("code")
				 ));
		
	}

	private List<Dipendenti>  resultToObject(List<Map<String, Object>> lD) {
		return lD.stream()
				.map(row -> new Dipendenti(
						 (Integer)row.get("id_dipendente"), 
						 (String)row.get("nome"), 
						 (String)row.get("cognome"), 
						 null, //LocalDate
						 (String)row.get("telefono"), 
						 (String)row.get("mansione"), 
						 ((BigDecimal)row.get("stipendio")).doubleValue(), 
						 (Integer)row.get("id_ufficio"), 
						 (String)row.get("code")
						 )
					).collect(Collectors.toList());
	}

}

package com.betacom.process;

import com.betacom.exceptions.AcademyException;
import com.betacom.interfaces.ProcessInterface;
import com.betacom.objects.Impiegato;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ProcessCollection implements ProcessInterface {

	@Override
	public boolean execute() throws Exception {
		System.out.println("Begin processo collezioni");
		executeList();
		executeMap();
		mapTest();
		
		
		return false;
	}
	
	private void executeList() throws AcademyException {
		
		List<Impiegato> lI = new ArrayList<Impiegato>();
		
		lI.add(new Impiegato("Giancarlo", "Bolluci", true, 1500.0, "IT"));
		lI.add(new Impiegato("Marco", "Lavulla", true, 1600.0, "IT"));
		lI.add(new Impiegato("Gianni", "Danco", true, 1700.0, "PRODUZIONE"));
		lI.add(new Impiegato("Anna", "Bella", false, 1300.0, "LOGISTICA"));
		lI.add(new Impiegato("Beatice", "Bolluna", false, 1400.0, "PRODUZIONE"));
		lI.add(new Impiegato("Marco", "Grande", true, 2000.0, "IT"));
		lI.add(new Impiegato("Mirko", "Pulico", true, 1800.0, "PRODUZIONE"));
		lI.add(new Impiegato("Daniel", "Andorua", true, 1500.0, "LOGISTICA"));
		lI.add(new Impiegato("Nicolo", "Danke", true, 1400.0, "PRODUZIONE"));
		lI.add(new Impiegato("Daniela", "Ciamplu", false, 1900.0, "IT"));
		lI.add(new Impiegato("Angelina", "Billico", false, 2100.0, "LOGISTICA"));
		lI.add(new Impiegato("Eric", "Lapiero", true, 1100.0, "PRODUZIONE"));
		lI.add(new Impiegato("Piero", "Ponte", true, 1500.0, "IT"));
		lI.add(new Impiegato("Maria", "Filippo", false, 1600.0, "LOGISTICA"));
		
		
		listImpiegati(lI, "Dopo creazione");
		
		Impiegato save=removeFromImpiegato (5, lI);
		if (save == null) {
			System.out.println("Errore nella cancellazione");
		}
		listImpiegati(lI, "Dopo remove con pos");
		
		lI.add(save);
		listImpiegati(lI, "Dopo restore item cancellato");
		
		
		save=removeFromImpiegato("Billico", lI);
		listImpiegati(lI, "Dopo cancellazione Billico");
		
		if (save == null) {
			System.out.println("Errore nella cancellazione");
		}
		
		//aggiornamento stipendio * 1.5 di tutti gli impiegati che sono in it
		updateSalary ("IT", lI, 1.5);
		listImpiegati(lI, "Dopo l'aggiornamento dei salari");
		
		//ordinamento di un arraylist in base allo stipendio, dal  più alto al più basso
		lI.sort(new Comparator<Impiegato>() {
			
			public int compare (Impiegato o1, Impiegato o2) {
				
				return Double.compare(o2.getSalary(), o1.getSalary());
			}
			
		});
		
		listImpiegati(lI, "Dopo sort dei salari");
		//espressione lamda
		//lI.forEach(i -> System.out.println(i));
		
		
		
		
	}
	
	
	private void executeMap() {
		System.out.println("Map process.....");
		
		String value = null;
		String keySearch=null;
		
		Map<String, String> map = new HashMap <String, String> (); //è case sensitive
		map.put("k1", "v1");
		map.put("k2", "v2");
		map.put("k3", "v3");
		map.put("k4", "v4");
		map.put("k5", "v5");
		map.put("k6", "v6");
		map.put("k7", "v7");
		map.put("k8", "v8");
		map.put("k9", "v9");
		map.put("k10", "10");
		
		System.out.println("Numero elementi mappa: "+map.size());
		
		keySearch="k7";
		
		if (map.containsKey(keySearch)) {
			value=map.get(keySearch);
			System.out.println("Valore di: "+keySearch+ ": "+value); //se non esiste restituisce null
		}
		else {
			System.out.println("La chiave: "+keySearch+" non esiste");
		}
		
		value= "v5";

		if (map.containsValue(value)) {
			System.out.println("Valore: "+value+ " trovato"); 
		}
		else {
			System.out.println("Valore: "+value+ " non trovato"); 
		}
		
		map.put("k3", "k3 modificato");    //aggiornamento valore
		
		System.out.println("Valore di k3: "+map.get("k3"));
		
		
		//mostrare il contenuto della mappa
		
		System.out.println("List map with Entry");
		
		for (Entry<String, String> it: map.entrySet() ) {
			System.out.println("Key: "+ it.getKey()+ " Valore: "+ it.getValue());
			/*
			 * mostra in questo ordine 
			 * 		Key: k1 Valore: v1
					Key: k2 Valore: v2
					Key: k3 Valore: k3 modificato
					Key: k4 Valore: v4
					Key: k5 Valore: v5
					Key: k6 Valore: v6
					Key: k10 Valore: 10
					Key: k7 Valore: v7
					Key: k8 Valore: v8
					Key: k9 Valore: v9
			 */
		}
		
		System.out.println("List map with keySet"); //visualizzazione mappa a partire dalla chiave
		
		for (String it: map.keySet()) {
			System.out.println("key: "+it+ " valore: "+map.get(it));
		}
	
	}
	
	//trasformare stringa in mappa
	private void mapTest() {
		String params= "p1=aaa,p2=BBB,p3=26,p4=Paolo";  
		System.out.println("Valore di params: "+params);
		
		String[] p =params.split(","); //p contiene 4 elementi: p1=aaa p2=BBB p3=26 p4=Paolo
		Map<String, String> map=new HashMap<String, String>();
		
		
		for (String it: p) {  //alla prima iterazione, it ha valore p1=aaa, alla seconda iterazione vale p2=BBB, ecc..
			String [] elem=it.split("=");
			map.put(elem[0], elem[1]);
		}
		
		System.out.println("List map with keySet"); //visualizzazione mappa a partire dalla chiave
		
		for (String it: map.keySet()) {
			System.out.println("key: "+it+ " valore: "+map.get(it));
		}
		
		
		
		
		String riga1 = "p1=aaa,p2=BBB,p3=26,p4=Paolo";
		String riga2 = "par1=10,par2=param2,par3=20.0, par4 =SAS";
		String riga3 = "k1=Terzo,k2=50,k3=struttura,k4=50%,k5=aaa";
		String riga4 = "p1=22,p2= Quarto,p3 =ABC,p4=20.5";
		
		List<Map<String, String>> listaMappe=new ArrayList<>();
		Map<String, String> mappa;
		
		List <String> listaPar=new ArrayList<>();
		listaPar.add(riga1);
		listaPar.add(riga2);
		listaPar.add(riga3);
		listaPar.add(riga4);
		
		for (String riga:listaPar) {
			mappa=new HashMap<String, String>();
			createMap(riga,mappa);
			listaMappe.add(mappa);
		}
		
		//visualizzazione lista mappe
		int i=1;
		
		for (Map <String, String> m: listaMappe) {
			System.out.println("Visualizzazione mappa"+i);
			
			for (String it: m.keySet()) {
				System.out.println("key: "+it+ " valore: "+m.get(it));
			}
			
			i++;
		}

	}
	
	public void createMap (String riga , Map <String, String> mappa) {
		riga=riga.replace(" ","");
		
		String[] p =riga.split(","); 
		
		for (String it: p) {  
			String [] elem=it.split("=");
			mappa.put(elem[0], elem[1]);
		}
		
	}
	
	
	private void updateSalary (String criterio, List <Impiegato> lI, Double aumento) {
		for (Impiegato i: lI) {
			if (i.getReparto().toString().equals(criterio)) {
				i.setSalary(i.getSalary()*aumento);
			}
		}
	}
	
	private void listImpiegati(List <Impiegato> lI, String title) {
		System.out.println("******"+title+"*********");
		int pos=0;
		for (Impiegato it: lI) {
			System.out.println(pos+" "+it);
			pos++;
		}
	}
	
	//lista passata per riferimento
	private Impiegato removeFromImpiegato(int pos, List <Impiegato> lI) {
		if (pos > lI.size()) {
			System.out.println("Posizione "+pos+" invalida, la dimensione della lista e': "+lI.size());
			return null;
		}
		Impiegato res = lI.get(pos);
		lI.remove(pos);
		
		return res;
	}
	
	private Impiegato removeFromImpiegato(String cognome, List <Impiegato> lI) {
		int pos=0;
		
		for (Impiegato it: lI) {
			if (it.getCognome().equalsIgnoreCase(cognome)) {
				
				return removeFromImpiegato(pos, lI);
			}
			pos++;	
		}
		
		return null;
	}
	
	

}

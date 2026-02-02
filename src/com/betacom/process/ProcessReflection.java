package com.betacom.process;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

import com.betacom.enums.Reparto;
import com.betacom.interfaces.ProcessInterface;

public class ProcessReflection implements ProcessInterface{

	@Override
	public boolean execute() throws Exception {
		
		System.out.println("Begin process reflection");
		
		//gestioneMyClass();
		
		gestioneImpiegato();
		

			
		return false;
	}
	
	public void gestioneMyClass() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
		String packageName="com.betacom.objects";
		String className="MyClassReflection";
		Object myClass=null;
		
		//troviamo la classe
	
		try {
			Class cl=Class.forName(packageName+"."+className);
			System.out.println("Class "+className+" found");
			
			/*
			 * retrieve constructor for selected class
			 */
			Constructor [] ctore=cl.getConstructors();
			Constructor selectedConstructor=null;
			int constructorToSelect=0;
			
			
			System.out.println("Numero costruttori trovati: "+ctore.length);
			
			for (Constructor c:ctore) {
				/*
				 * trovare il numero di parametri per ogni costruttore
				 */
				System.out.println("Numero di parametri trovati: "+c.getParameterCount());
				
				if (c.getParameterCount()==constructorToSelect) {
					selectedConstructor = c;
				}
				
				Type [] type=c.getGenericParameterTypes();
				
				for (Type t: type) { //meglio il for che il for each
					System.out.println("Tipo del parametro: "+t);
					
				}
				
			}
			
			/*
			 * new instance 
			 */
			if (constructorToSelect == 0) {
				myClass=selectedConstructor.newInstance();
				System.out.println("Costruttore selezionato senza parametri");
			}
			
			if (constructorToSelect == 2) {
				myClass=selectedConstructor.newInstance(10, "descrizione");
				System.out.println("Costruttore selezionato con 2 parametri");
			}
			
			if (constructorToSelect == 3) {
				myClass=selectedConstructor.newInstance(10, "descrizione", 20);
				System.out.println("Costruttore selezionato con 3 parametri");
			}
			
			/*
			 * introspezione metodi
			 */
			Method [] methods=myClass.getClass().getMethods();
			for (Method method:methods) {
				System.out.println("Trovato metodo= "+method.getName()); //ereditiamo tutti i metodi di object
				
				if("setId".equals(method.getName())) {
					method.invoke(myClass, 99);
				}
				
				if("setDesc".equals(method.getName())) {
					method.invoke(myClass, "valore");
				}
				if("setP1".equals(method.getName())) {
					method.invoke(myClass, 100);
				}
				
			}
			String methodName="toString";
			Method metodo=myClass.getClass().getMethod(methodName);
			String msg=(String) metodo.invoke(myClass);
			
			System.out.println(msg);
			
			
		} catch (ClassNotFoundException e ) {
			
			System.out.println("Class not found "+e);
		}
		catch ( IllegalArgumentException e) {
					
			System.out.println("Parametro non valido "+e);
		}
	}
	
	public void gestioneImpiegato() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		String packageName="com.betacom.objects";
		String className="Impiegato";
		Object myClass=null;
		
		//troviamo la classe
	
		try {
			Class cl=Class.forName(packageName+"."+className);
			System.out.println("Class "+className+" found");
			
			/*
			 * retrieve constructor for selected class
			 */
			Constructor [] ctore=cl.getConstructors();
			Constructor selectedConstructor=null;
			int constructorToSelect=5;
			
			
			System.out.println("Numero costruttori trovati: "+ctore.length);
			
			for (Constructor c:ctore) {
				/*
				 * trovare il numero di parametri per ogni costruttore
				 */
				System.out.println("Numero di parametri trovati: "+c.getParameterCount());
				
				if (c.getParameterCount()==constructorToSelect) {
					selectedConstructor = c;
				}
				
				Type [] type=c.getGenericParameterTypes();
				
				for (Type t: type) { //meglio il for che il for each
					System.out.println("Tipo del parametro: "+t);
					
				}
				
			}
			
			/*
			 * new instance 
			 */
			if (constructorToSelect == 0) {
				myClass=selectedConstructor.newInstance();
				System.out.println("Costruttore selezionato senza parametri");
			}
			
			if (constructorToSelect == 4) {
				myClass=selectedConstructor.newInstance("Federico", "Basile", true, 1600.0);
				System.out.println("Costruttore selezionato con 4 parametri");
			}
			
			if (constructorToSelect == 5) {
				myClass=selectedConstructor.newInstance("Federico", "Basile", true, 1600.0, "LOGISTICA");
				System.out.println("Costruttore selezionato con 5 parametri");
			}
			
			/*
			 * introspezione metodi
			 */
			Method [] methods=myClass.getClass().getMethods();
			for (Method method:methods) {
				System.out.println("Trovato metodo= "+method.getName()); //ereditiamo tutti i metodi di object
				
				if("setSalary".equals(method.getName())) {
					method.invoke(myClass, 1600.0);
				}
				
				if("setReparto".equals(method.getName())) {
					method.invoke(myClass, Reparto.valueOf("LOGISTICA"));
				}
				
				if("setNome".equals(method.getName())) {
					method.invoke(myClass, "Federico");
				}
				
				if("setCognome".equals(method.getName())) {
					method.invoke(myClass, "Basile");
				}
				
				if("setSesso".equals(method.getName())) {
					method.invoke(myClass, true);
				}
				
			}
			
			String methodName="toString";
			Method metodo=myClass.getClass().getMethod(methodName);
			String msg=(String) metodo.invoke(myClass);
			
			System.out.println(msg);
			
			
		} catch (ClassNotFoundException e ) {
			
			System.out.println("Class not found "+e);
		}
		catch ( IllegalArgumentException e) {
					
			System.out.println("Parametro non valido "+e);
		}
	}
	

}

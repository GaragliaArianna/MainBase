package com.betacom;

import java.util.Scanner;

import com.betacom.objects.User;
import com.betacom.utils.PromozioneAutomatica;

import java.util.ArrayList;

public class MainBase {
		public static void main (String [] args) {
			/*
			 * primitivi
			 * nome		bit 	byte 	range valori		classe wrapper
			 * byte		8		1		-128	+127		Byte
			 * int		32		4		+p- 2*10 ^9			Integer
			 * short	16		2		-32768  +32767		Short
			 * long		64		4		+ o - 9*10^18		Long
			 * float 	32		4
			 * double	64		8	
			 * boolean										Boolean
			 * 
			 * char											Character
			 */
			byte b= 127;
			int i=2_000_000_000;
			short s=32767;
			long j=9_473_892_479_237L;
			char c='z';
			boolean bool= true;
			double d=123;
			
			/*
			 * reference
			 */
			
			String str="Ciao sono una stringa";
			System.out.print(str+"\n"+str);
			/*
			
			Scanner sc = new Scanner (System.in);
			System.out.println ("\nInserisci il nome: ");
			String nome= sc.nextLine();
			System.out.print("Nome: "+nome);*/
			
			/*
			 * Operatori logici
			 * && 	and
			 * || 	or
			 * < 	>  		<=  	>=
			 */
			
			char p3= 'z';
			int p1=30;
			int p2=16;
			boolean rc= (p1 > p2) && (p3 != 'p');
			System.out.print("\nValore di rc: "+rc);
			
			int eta=30;
			String result="";
			if (eta <30) {
				result="Sei un ragazzino";
			}
			else {
				result="Non sei un ragazzino";
			}
			System.out.print("\n"+result);
			
			/*
			 * opertori ternari
			 */
			
			result= (eta < 30) ? "Sei un ragazzino" : "Non sei un ragazzino";
			System.out.print("\n"+result);
			
			/*
			 * operatori aritmetici
			 * +		-		*		/		%
			 */
			
			i=20;
			i++;
			int jj=3;
			int res=i*jj;
			int div=res/2;
			int rim = res %2;
			
			System.out.println("Valore di i: "+ i 
					+"\ndiv:"+div
					+"\nrim"+rim);
			
			String param="123456";
			i=Integer.parseInt(param);
			System.out.print("Conversione to int:"+param);
			
			param="dwededwedwedkkkkdhihhh\n";
			System.out.print("Lunghezza stringa: "+param.length()
			+" parte della stringa: "+ param.substring(4, 6)
			);
			
			param= "       inizio   corso   java   ";
			System.out.print(param.trim());		
			
			String search="corso";
			if (search.contains("corso")) {
				System.out.print("\nLa stringa contiene corso");
			}
			else {
				System.out.print("\nLa stringa non contiene corso");
			}
			
			if ("CORSO".equals(search)) {
				System.out.print("\nVero1");	
			}
			
			if ("CORSO".equalsIgnoreCase(search)) {
				System.out.print("\nVero2");	
			}
			
			String [] array=new String [4];
			array[0]="primo";
			array[1]="secondo";
			array[2]="terzo";
			array[3]="quarto";
			
			for (int idx=0; idx <array.length; idx++) {
				System.out.print("\n"+array[idx]);
			}
			
			for (String it:array) {
				System.out.print("\n"+it);
			}
			/*
			 * Classi wrapper
			 */
			
			//int ii= null; dà errore
			Integer ii=null; //non dà errore perchè è una classe e ho tanti metodi disponibili
			
			//int [] numeri = {10, null, 20, 30};   errore
			Integer [] numeri = {10, null, 20, 30};
			for (Integer it:numeri) {
				System.out.print("\n"+it);
			}
			
			System.out.print("\nMATRICE A DUE DIMENSIONI\n");
			
			String [][] multi1= new String [3][4];
			
			for (int id=0; id<multi1.length; id++) {
				for (int jd=0; jd<multi1[id].length; jd++) {
					multi1 [id][jd]="prova_"+id+ " "+ jd;
					System.out.print("\nid: "+ id+ "jd: "+jd);
				}
			}
			
			System.out.print("\nMATRICE A TRE DIMENSIONI\n");
			
			String [][] [] multi= new String [3][4] [5];
			
			//matrice a tre dimensioni
			for (int id=0; id<multi.length; id++) {
				for (int jd=0; jd<multi[id].length; jd++) {
					for (int zd=0; zd<multi[id] [jd].length; zd++ ) {
						multi [id][jd] [zd]="prova_"+id+ " "+ jd+ " "+ zd;
						System.out.print("\nid: "+ id+ " jd: "+jd + " zd: "+zd);
					}

				}
			}
			
			/*
			 * ARRAY DINAMICI
			 */
			
			ArrayList <String> aL=new ArrayList <String>();
			aL.add("Pietro");
			aL.add("Pietro");
			aL.add("Pink");
			aL.add("Pallino");
			
			System.out.println("Lengh: "+ aL.size());
			
			for (String it:aL) {
				System.out.println(it);
				
			}
			
			System.out.print("al [4]: "+aL.get(3));
			aL.remove(3);
			
			/*
			 * VISIBILITà DELLE CLASSI
			 */
			
			User usr = new User("Pippo", "Grande", true);
			
			/*
			 * tutte le classi in Java derivano dalla classe Object che ha i supi metodi come toString, ecc
			 * per personalizzare i metodi si utilizza l'override
			 */
			System.out.println(usr.getNome()+" "+usr.getCognome());
			System.out.println(usr.toString());
			
			ArrayList <User> lU= new ArrayList <User> ();
			lU.add(new User ("Piero", "Ilgrande", "M"));
			lU.add(new User ("Paolo", "Rosso", true));
			lU.add(new User ("Anna", "Verde", false));
			lU.add(new User ("Gianluca", "Giallo", "M"));
			lU.add(new User ("Maria", "Nero", "F"));
			
			for (User it:lU) {
				System.out.println(it);
			}
			
			/*
			 * Scorrimento di una lista fino al raggiungimento del cognome "Verde"
			 */
			
			search="Verde";
			
			for (User it:lU) {
				System.out.println(it);
				if (search.equalsIgnoreCase(it.getCognome()))
					break;
			
			}
			/*
			 * OVERLOADING DEI METODI: metodo con stesso nome e parametri diversi
			 */
			
			//se method non è statico:
			//PromozioneAutomatica pro= new PromozioneAutomatica();
			//pro.method(10);
			//pro.method(10.0f);
			//pro.method("aaa");
			

			
			//il package è un contenitore che contiene classi o altri package che hanno una logica in comune
			
			//method è statico, si evita di istanziare la classe (lo fa la JVM)
			PromozioneAutomatica.method(10);
			PromozioneAutomatica.method(10.0f);
			PromozioneAutomatica.method("aaa");
		
			
		}
}

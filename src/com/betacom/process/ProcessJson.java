package com.betacom.process;

import java.lang.reflect.Type;
import java.util.List;

import com.betacom.interfaces.ProcessInterface;
import com.betacom.objects.ObjectJson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class ProcessJson implements ProcessInterface{

	@Override
	public boolean execute() throws Exception {

		System.out.println("Begin file json process");
		
		/*
		 * Object to Json
		 */
		
		ObjectJson usr = new  ObjectJson("Giuseppe", "Verdi", true);
		
		//Gson gson=new Gson(); 
		
		Gson gson=new GsonBuilder().setPrettyPrinting().create();
		
		String jsonString = gson.toJson(usr);
		
		System.out.println(jsonString);
		
		/*
		 * Json to Object
		 */
		
		Object newUsr= gson.fromJson(jsonString, ObjectJson.class);
		
		System.out.println("New object creato da Json"+newUsr);
		
		/*
		 * List to json
		 */
		
		
		List <ObjectJson> lUser=List.of(
				new ObjectJson("Giuseppe", "Verdi", true),
				new ObjectJson("Paolo", "Peluco", true),
				new ObjectJson("Anna", "Bella", false)
				);
		
		System.out.println("Lista json *****");
		
		
		jsonString=gson.toJson(lUser);
		
		System.out.println(jsonString);
		
		/*
		 * Json to list quando non sai il tipo della lista
		 */
		
		
		Type listType = new TypeToken<List<ObjectJson>>(){}.getType(); //retrieve correct type with reflections (type token restituisce le informazioni sull'oggetto)
		
		List <ObjectJson> lUser1=gson.fromJson(jsonString, listType); 
		
		lUser1.forEach(u -> System.out.println(u));
		
		return false;
	}

}

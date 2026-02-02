package com.betacom.objects;

import java.io.Serializable;

public class Address implements Serializable{
	
	//le due classi devono stare nello stesso path (package e nome) e  devono avere la stessa versione
	private static final long serialVersionUID= 1L;  //1la versione è 1. se aggiorni la classe devi mettere versione 2 ecc.. per non renderla più leggibile da app che hanno una versione obsoleta (gli manca qualche campo)
														//se l'altra app ha campi in più, questi verranno inizializzati con null
	private String street;
	private String city;
	private String name;
	private Boolean sesso;
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getSesso() {
		return sesso;
	}
	public void setSesso(Boolean sesso) {
		this.sesso = sesso;
	}
	public Address(String street, String city, String name, Boolean sesso) {
		super();
		this.street = street;
		this.city = city;
		this.name = name;
		this.sesso = sesso;
	}
	public Address() {
		super();
	}
	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", name=" + name + ", sesso=" + sesso + "]";
	}
	
	

}

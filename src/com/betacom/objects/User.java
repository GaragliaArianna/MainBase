package com.betacom.objects;

import java.time.LocalDate;

public class User {
	
	//mai attributi con visibilità public, usa getter e setter
	//le variabili protected sono visibili dalle classi figlie e dello stesso package
	//variabile default : visibile dalle classi dello stesso package
	private String nome;

	private String cognome;
	
	private Boolean sesso;
	
	private LocalDate dataNascita;
	private LocalDate dataCerticatMedico;
	private Integer meseDiValidita;
	
	//ho effettuato l'overloading del costruttore perchè ho 2 metodi
	
	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public LocalDate getDataCerticatMedico() {
		return dataCerticatMedico;
	}

	public void setDataCerticatMedico(LocalDate dataCerticatMedico) {
		this.dataCerticatMedico = dataCerticatMedico;
	}

	public Integer getMeseDiValidita() {
		return meseDiValidita;
	}

	public void setMeseDiValidita(Integer meseDiValidita) {
		this.meseDiValidita = meseDiValidita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public User(String nome, String cognome, Boolean sesso) {
		this.nome = nome;
		this.cognome = cognome;
		this.sesso=sesso;
	}
	
	public User(String nome, String cognome, Boolean sesso, LocalDate dataNascita) {
		this.nome = nome;
		this.cognome = cognome;
		this.sesso= ("M".equals(sesso)) ? true:false;
		this.dataNascita=dataNascita;
	}
	
	public User(String nome, String cognome, String sesso) {
		this.nome = nome;
		this.cognome = cognome;
		this.sesso=("M".equals(sesso)) ? true : false;  //nel caso di input di tipo diverso alla variabile in cui memorizzare il valore
	}
	

	public Boolean getSesso() {
		return sesso;
	}



	public void setSesso(Boolean sesso) {
		this.sesso = sesso;
	}



	public User () {
		super();
	}
	
	public User(String string, String string2, String string3, LocalDate u) {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	@Override
	public String toString() {
		return "User [nome=" + nome + ", cognome=" + cognome + ", sesso=" + sesso + ", dataNascita=" + dataNascita
				+ ", dataCerticatMedico=" + dataCerticatMedico + ", meseDiValidita=" + meseDiValidita + "]";
	}


	

}

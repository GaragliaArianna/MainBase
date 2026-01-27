package com.betacom.objects;

public abstract class Car {
	
	//non può essere istanziata
	
	private String model;
	
	private String color;
	
	private Integer maxSpeed;
	
	//i metodi astratti verranno implementati da altre classi
	public abstract void frena ();
	
	public abstract void accelera();

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(Integer maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	

}

package com.everis.alicante.courses.beca.java_.simple.garage.domain;

public class Camion extends Vehiculo implements Aparcable  {

	private String marca;
	private String color;

	public Camion(String matricula, String marca, String color) {
		super(matricula);
		this.color = color;
		this.marca = marca;
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public String aparcable() {
		return "No es aparcable";
	}

}

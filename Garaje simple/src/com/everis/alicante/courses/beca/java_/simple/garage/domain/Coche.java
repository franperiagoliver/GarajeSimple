package com.everis.alicante.courses.beca.java_.simple.garage.domain;

public class Coche extends Vehiculo implements Aparcable {

	private String marca;
	private String color;

	public Coche(String matricula, String marca, String color) {
		super(matricula);
		this.marca = marca;
		this.color = color;
	}

	public Coche() {
		// TODO Auto-generated constructor stub
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
	
	
	@Override
	public String toString() {
		return "Coche [marca=" + marca + ", color=" + color + "]";
	}

	public String aparcable() {
		return "Es aparcable";
	}

}

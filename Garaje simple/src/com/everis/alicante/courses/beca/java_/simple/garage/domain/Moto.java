package com.everis.alicante.courses.beca.java_.simple.garage.domain;

public class Moto extends Vehiculo implements Aparcable {

	private String marca;
	private String color;

	public Moto(String matricula, String marca, String color) {
		super(matricula);
		this.marca = marca;
		this.color = color;
	}

	public String getModelo() {
		return marca;
	}

	public void setModelo(String marca) {
		this.marca = marca;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String aparcable() {

		return "Es aparcable";
	}

}

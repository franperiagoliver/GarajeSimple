package com.everis.alicante.courses.beca.java_.simple.garage.domain;

public class Vehiculo {

	private String matricula;

	public Vehiculo(String matricula) {
		this.matricula = matricula;
	}

	public Vehiculo() {
		// TODO Auto-generated constructor stub
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + "]";
	}

	
}

package com.everis.alicante.courses.beca.java_.garage.domain;

public class Vehiculo {
	
	private String matricula;
	private String tipoVehiculo;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	
	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	@Override
	public String toString() {
		return "Veh�culo con n�mero de matr�cula = " + matricula ;
	}
	
	
	
}

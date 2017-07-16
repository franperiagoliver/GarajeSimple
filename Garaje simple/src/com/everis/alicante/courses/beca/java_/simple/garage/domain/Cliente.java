package com.everis.alicante.courses.beca.java_.simple.garage.domain;

public class Cliente {

	private String dni;
	private String nombre;
	public Vehiculo vehiculo;
	
	public Cliente(String dni, String nombre, Vehiculo vehiculo) {
		this.dni = dni;
		this.nombre = nombre;
		this.vehiculo = vehiculo;
	}
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nombre=" + nombre + ", vehiculo=" + vehiculo + "]";
	}

	
}
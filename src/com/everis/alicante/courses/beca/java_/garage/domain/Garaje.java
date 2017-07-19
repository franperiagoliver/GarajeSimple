package com.everis.alicante.courses.beca.java_.garage.domain;

import java.util.List;
import java.util.Map;

public class Garaje {
	
	// Modelo de datos
	private List<Plaza> plaza;
	
	//Información auxiliar útil
	private Map<String, Reserva> reservas;
	private Map<String, Cliente> vehiculos;
	private Map<String, Cliente> clientes;

	public List<Plaza> getPlaza() {
		return plaza;
	}

	public void setPlaza(List<Plaza> plaza) {
		this.plaza = plaza;
	}

	public Map<String, Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(Map<String, Reserva> reservas) {
		this.reservas = reservas;
	}

	public Map<String, Cliente> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(Map<String, Cliente> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public Map<String, Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Map<String, Cliente> clientes) {
		this.clientes = clientes;
	}	
	
}

package com.everis.alicante.courses.beca.java_.garage.domain;

import java.util.List;

public class Garaje {
	
	private List<Plaza> plaza;
	private List<Reserva> reservas;

	public List<Plaza> getPlaza() {
		return plaza;
	}

	public void setPlaza(List<Plaza> plaza) {
		this.plaza = plaza;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
	
	
}

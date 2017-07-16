package com.everis.alicante.courses.beca.java_.simple.garage.domain;

public class Plaza {

	private Cliente cliente;
	private double precio;

	public Plaza(Cliente cliente, double precio) {
		this.cliente = cliente;
		this.precio = precio;
	}

	public Plaza() {
		
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

}

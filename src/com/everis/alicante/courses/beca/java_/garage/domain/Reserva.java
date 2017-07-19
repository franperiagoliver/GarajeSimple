package com.everis.alicante.courses.beca.java_.garage.domain;

import java.util.Date;

public class Reserva {

	private final String GUION = "-";
	private String codigoReserva;
	private Plaza numeroPlaza;
	private Cliente cliente;
	private Date fechaReserva;
	private Date fechaInicio;
	private Date fechaFin;

	public Plaza getNumeroPlaza() {
		return numeroPlaza;
	}

	public void setNumeroPlaza(Plaza numeroPlaza) {
		this.numeroPlaza = numeroPlaza;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getCodigoReserva() {
		
		return codigoReserva;
	}
	

	public void setCodigoReserva(String codigoReserva) {
		this.codigoReserva = codigoReserva;
	}

	public String convierteAFormatoTxt() {
		
		String str = "";
		str = str.concat(String.valueOf(this.getCodigoReserva()));
		str = str.concat(";");
		str = str.concat(String.valueOf(this.numeroPlaza.getNumeroPlaza()));
		str = str.concat(";");
		str = str.concat(this.cliente.getNif());
		str = str.concat(";");
		str = str.concat(this.cliente.getVehiculo().getMatricula());
		str = str.concat(";");
		str = str.concat(this.fechaReserva.toString());

		return str;

	}

}

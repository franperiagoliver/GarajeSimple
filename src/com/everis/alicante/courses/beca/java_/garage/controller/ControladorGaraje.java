package com.everis.alicante.courses.beca.java_.garage.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import com.everis.alicante.courses.beca.java_.garage.domain.Plaza;


public interface ControladorGaraje {
	
	Map<Integer, Plaza> listarPlazasLibres() throws IOException;
	void listarPlazasOcupadas() throws IOException;
	boolean reservarPlaza() throws IOException;
	void listarClientes() throws IOException;
	void listarReservas() throws IOException;
	void listarVehiculos() throws IOException;
	void listarReservasByFecha(Date fechaInicio, Date fechaFin) throws IOException;
}

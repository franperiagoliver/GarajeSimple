package com.everis.alicante.courses.beca.java_.garage.domain.controller;

import java.io.IOException;
import java.util.List;

import com.everis.alicante.courses.beca.java_.garage.domain.Reserva;

public interface ControladorGaraje {
	
	void listarPlazasLibres();
	void listarPlazasOcupadas();
	boolean reservarPlaza() throws IOException;
	void listarClientes();
	void listarReservas() throws IOException;
}

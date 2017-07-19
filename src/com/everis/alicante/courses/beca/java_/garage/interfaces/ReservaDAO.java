package com.everis.alicante.courses.beca.java_.garage.interfaces;

import java.io.IOException;
import java.util.Map;

import com.everis.alicante.courses.beca.java_.garage.domain.Reserva;

public interface ReservaDAO {
	
	void createReserva(Reserva reserva) throws IOException;
	Map<String, Reserva> readReserva() throws IOException;
}

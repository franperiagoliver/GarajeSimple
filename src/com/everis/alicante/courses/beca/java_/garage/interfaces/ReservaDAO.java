package com.everis.alicante.courses.beca.java_.garage.interfaces;

import java.io.IOException;

import com.everis.alicante.courses.beca.java_.garage.domain.Reserva;

public interface ReservaDAO {
	
	void saveReserva(Reserva reserva) throws IOException;
	
}

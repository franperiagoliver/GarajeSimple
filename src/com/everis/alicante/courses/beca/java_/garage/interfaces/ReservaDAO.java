package com.everis.alicante.courses.beca.java_.garage.interfaces;

import java.io.IOException;
import java.util.List;

import com.everis.alicante.courses.beca.java_.garage.domain.Reserva;

public interface ReservaDAO {
	
	void saveReserva(Reserva reserva) throws IOException;
	List<Reserva> readReserva() throws IOException;
}

package com.everis.alicante.courses.beca.java_.garage.interfaces;

import java.io.IOException;
import java.util.List;

import com.everis.alicante.courses.beca.java_.garage.domain.Plaza;

public interface PlazaDAO {
	
	List<Plaza> readPlazas() throws IOException;
	
	void createPlazas(List<Plaza> plazas);
	
	Plaza readPlaza(int numeroPlaza) throws NumberFormatException, IOException;
	
	void deletePlaza(int numeroPlaza);
	
	// Falta el update.
	
}

package com.everis.alicante.courses.beca.java_.garage.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.everis.alicante.courses.beca.java_.garage.domain.Plaza;

public interface PlazaDAO {
	
	Plaza[] readPlaza() throws IOException;
	
	void write(Plaza[] plazas);
	
}

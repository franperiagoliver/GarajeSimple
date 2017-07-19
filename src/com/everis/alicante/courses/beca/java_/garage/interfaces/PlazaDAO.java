package com.everis.alicante.courses.beca.java_.garage.interfaces;

import java.io.IOException;
import java.util.List;

import com.everis.alicante.courses.beca.java_.garage.domain.Plaza;

public interface PlazaDAO {
	
	List<Plaza> readPlaza() throws IOException;
	
	void write(List<Plaza> plazas);
	
}

package com.everis.alicante.courses.beca.java_.garage.interfaces;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.everis.alicante.courses.beca.java_.garage.domain.Cliente;

public interface ClienteDAO {
	
	Map<String, Cliente> readCliente() throws IOException;
	
	void createCliente(Cliente cliente);
	
}

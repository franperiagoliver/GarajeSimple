package com.everis.alicante.courses.beca.java_.garage.interfaces.implementation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.everis.alicante.courses.beca.java_.garage.domain.Cliente;
import com.everis.alicante.courses.beca.java_.garage.interfaces.ClienteDAO;

public class ClienteDAOFileImp implements ClienteDAO {

	@Override
	public Map<String, Cliente> readCliente() throws IOException {

		Map<String, Cliente> clientes = new TreeMap<String, Cliente>();

		File file = new File("src/resources/Clientes.txt");
		FileReader reader = new FileReader(file);
		BufferedReader buffer = new BufferedReader(reader);

		String linea;

		while ((linea = buffer.readLine()) != null) {

			if (!linea.contains("NIF") || linea.isEmpty()) {

				Cliente clienteTemp = new Cliente();

				String[] temp = linea.split(";");

				clienteTemp.setNif(temp[0]);
				clienteTemp.setNombreCompleto(temp[1]);

				clientes.put(clienteTemp.getNif(), clienteTemp);

			}
		}

		reader.close();

		return clientes;

	}

	@Override
	public void createCliente(Cliente cliente) {
		// TODO Auto-generated method stub

	}

}

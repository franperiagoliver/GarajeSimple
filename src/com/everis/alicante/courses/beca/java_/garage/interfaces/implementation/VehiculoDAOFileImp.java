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

import com.everis.alicante.courses.beca.java_.garage.domain.Vehiculo;
import com.everis.alicante.courses.beca.java_.garage.interfaces.VehiculoDAO;

public class VehiculoDAOFileImp implements VehiculoDAO {

	@Override
	public Map<String, Vehiculo> readVehiculo() throws IOException {
		
		Map<String, Vehiculo> vehiculos = new TreeMap<String, Vehiculo>();

		File file = new File("src/resources/Vehiculos.txt");
		FileReader reader = new FileReader(file);
		BufferedReader buffer = new BufferedReader(reader);

		String linea;

		while ((linea = buffer.readLine()) != null) {

			if (!linea.contains("MATRICULA") || linea.isEmpty()) {

				Vehiculo vehiculoTemp = new Vehiculo();

				String[] temp = linea.split(";");

				vehiculoTemp.setMatricula(temp[0]);
				vehiculoTemp.setTipoVehiculo(temp[1]);
				
				vehiculos.put(vehiculoTemp.getMatricula(), vehiculoTemp);

			}
		}

		reader.close();

		return vehiculos;
		
	}

	@Override
	public void createVehiculo() {
		// TODO Auto-generated method stub
		
	}

}

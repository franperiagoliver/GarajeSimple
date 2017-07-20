package com.everis.alicante.courses.beca.java_.garage.interfaces.implementation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.everis.alicante.courses.beca.java_.garage.domain.Plaza;
import com.everis.alicante.courses.beca.java_.garage.interfaces.PlazaDAO;

public class PlazaDAOFileImp implements PlazaDAO {

	@Override
	public List<Plaza> readPlazas() throws IOException {
		// TODO Auto-generated method stub

		List<Plaza> plazas = new ArrayList<Plaza>();

		File file = new File("src/resources/Plazas.txt");
		FileReader reader = new FileReader(file);
		BufferedReader buffer = new BufferedReader(reader);

		String linea;

		while ((linea = buffer.readLine()) != null) {

			if (!linea.contains("NUMERO_PLAZA") || linea.isEmpty()) {

				Plaza plazaTemp = new Plaza();
				String numeroPlaza = linea.substring(0, linea.indexOf(";"));

				plazaTemp.setNumeroPlaza(Integer.parseInt(numeroPlaza));

				String[] temp = linea.split(";");

				plazaTemp.setNumeroPlaza(Integer.parseInt(temp[0]));
				plazaTemp.setPrecio(Double.parseDouble(temp[1]));

				plazas.add(plazaTemp);

			}
		}

		reader.close();

		return plazas;
	}

	public static void main(String[] args) throws IOException {

		PlazaDAO dao = new PlazaDAOFileImp();

		dao.readPlazas();

	}

	@Override
	public void createPlazas(List<Plaza> plazas) {
		// TODO Auto-generated method stub

	}

	@Override
	public Plaza readPlaza(int numeroPlaza) throws NumberFormatException, IOException {

		File file = new File("src/resources/Plazas.txt");
		FileReader reader = new FileReader(file);
		BufferedReader buffer = new BufferedReader(reader);

		String linea;
		
		Plaza plazaTemp = null;

		while ((linea = buffer.readLine()) != null) {

			if (!linea.contains("NUMERO_PLAZA") || linea.isEmpty()) {

				String[] temp = linea.split(";");

				plazaTemp.setNumeroPlaza(Integer.valueOf(numeroPlaza));

				if (numeroPlaza == Integer.valueOf(temp[0])) {
					
					plazaTemp = new Plaza();
					plazaTemp.setNumeroPlaza(Integer.parseInt(temp[0]));
					plazaTemp.setPrecio(Double.parseDouble(temp[1]));
				
				}
				
			}
		}

		reader.close();

		return plazaTemp;

	}

	@Override
	public void deletePlaza(int numeroPlaza) {
		// TODO Auto-generated method stub

	}

}

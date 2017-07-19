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
	public List<Plaza> readPlaza() throws IOException {
		// TODO Auto-generated method stub
		
		List<Plaza> plazas = new ArrayList<Plaza>();
		
		File file = new File("src/resources/Plazas.txt");
		FileReader reader = new FileReader(file);
		BufferedReader buffer = new BufferedReader(reader);
		
		String linea;
		
		while((linea=buffer.readLine()) != null) {
			
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

		dao.readPlaza();

	}

	@Override
	public void createPlaza(List<Plaza> plazas) {
		// TODO Auto-generated method stub
		
	}

	

}

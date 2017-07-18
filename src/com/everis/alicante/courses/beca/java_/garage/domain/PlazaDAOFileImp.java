package com.everis.alicante.courses.beca.java_.garage.domain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.everis.alicante.courses.beca.java_.garage.interfaces.PlazaDAO;

public class PlazaDAOFileImp implements PlazaDAO {

	@Override
	public Plaza[] readPlaza() throws IOException {
		// TODO Auto-generated method stub
		
		List data = new ArrayList<String>();
		
		File file = new File("src/resources/Plazas.txt");
		FileReader reader = new FileReader(file);
		BufferedReader buffer = new BufferedReader(reader);
		
		String linea;
		
		while((linea=buffer.readLine()) != null) {
			data.add(linea);
			System.out.println(linea);
		}
		
		return null;
	}

	public static void main(String[] args) throws IOException {

		PlazaDAO dao = new PlazaDAOFileImp();

		dao.readPlaza();

	}

	@Override
	public void write(Plaza[] plazas) {
		// TODO Auto-generated method stub

	}

}

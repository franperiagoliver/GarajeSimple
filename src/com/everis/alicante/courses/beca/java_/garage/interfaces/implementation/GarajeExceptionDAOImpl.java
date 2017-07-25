package com.everis.alicante.courses.beca.java_.garage.interfaces.implementation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import com.everis.alicante.courses.beca.java_.garage.domain.GarajeException;
import com.everis.alicante.courses.beca.java_.garage.interfaces.GarajeExceptionDAO;

public class GarajeExceptionDAOImpl implements GarajeExceptionDAO {

	@Override
	public void create(GarajeException ex) throws GarajeException {
		
		try {
		
		File file = new File("src/resources/Exceptions.txt");
		FileWriter writer = new FileWriter(file, true);
		BufferedWriter buffer = new BufferedWriter(writer);
		
		buffer.newLine();

		buffer.write(ex.adaptaAFormatoTxt());

		buffer.close();
		
		} catch (Exception e) {
			
			throw new GarajeException(e);
		}
	}
	

}

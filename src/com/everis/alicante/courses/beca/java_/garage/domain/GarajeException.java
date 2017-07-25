package com.everis.alicante.courses.beca.java_.garage.domain;

import java.io.IOException;
import java.text.ParseException;

import com.everis.alicante.courses.beca.java_.garage.GarageMain;

public class GarajeException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6687242452039688977L;

	@Override
	public void printStackTrace() {
		
		System.out.println("Ha ocurrido un error del tipo: " + super.getClass());
		System.out.println("Con el mensaje: " + super.getMessage());
		System.out.println("Por la causa: " + super.getClass());
		
		try {
			GarageMain.iniciarAplicacion();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GarajeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}

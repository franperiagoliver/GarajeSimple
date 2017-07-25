package com.everis.alicante.courses.beca.java_.garage.controller;

import java.io.IOException;
import java.text.ParseException;

import com.everis.alicante.courses.beca.java_.garage.GarageMain;
import com.everis.alicante.courses.beca.java_.garage.domain.GarajeException;

public class ControladorExcepcionesImpl implements ControladorExcepciones {

	public void gestionaExcepcion(GarajeException e) {
		
		gestionaExcepcion(e);
		
		try {
			GarageMain.iniciarAplicacion();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (GarajeException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}

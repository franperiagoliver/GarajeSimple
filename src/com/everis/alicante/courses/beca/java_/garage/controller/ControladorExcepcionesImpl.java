package com.everis.alicante.courses.beca.java_.garage.controller;

import com.everis.alicante.courses.beca.java_.garage.GarageMain;
import com.everis.alicante.courses.beca.java_.garage.domain.GarajeException;

public class ControladorExcepcionesImpl implements ControladorExcepciones{

	@Override
	public void gestionaExcepcion(GarajeException e) {		
		
		e.gestionaExcepcion();
		
		//guarda la excepcion entera en un fichero de excepciones
		
		
			GarageMain.iniciarAplicacion();
		
		
	}

}
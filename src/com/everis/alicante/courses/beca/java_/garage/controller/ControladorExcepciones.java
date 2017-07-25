package com.everis.alicante.courses.beca.java_.garage.controller;

import com.everis.alicante.courses.beca.java_.garage.GarageMain;
import com.everis.alicante.courses.beca.java_.garage.domain.GarajeException;
import com.everis.alicante.courses.beca.java_.garage.interfaces.GarajeExceptionDAO;
import com.everis.alicante.courses.beca.java_.garage.interfaces.implementation.GarajeExceptionDAOImpl;

public interface ControladorExcepciones {	
	
	default void gestionaExcepcion(GarajeException e) {
		
		e.gestionaExcepcion();
		
		GarajeExceptionDAO daoException = new GarajeExceptionDAOImpl();
		
		try {
			
			daoException.create(e);
			
		} catch (GarajeException e2) {
			
			System.out.println(e2.getStackTrace());
		}
	
		GarageMain.iniciarAplicacion();
	}
	
}
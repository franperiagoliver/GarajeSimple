package com.everis.alicante.courses.beca.java_.garage.domain;

import java.util.Calendar;

import com.everis.alicante.courses.beca.java_.garage.interfaces.implementation.GarajeExceptionDAOImpl;

public class GarajeException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6474336936597609781L;

	public void gestionaExcepcion() {

		System.out.println("Ha ocurrido una excepcion ; ");
		System.out.println("del tipo :" + super.getClass());
		System.out.println(" y con esta causa: " + super.getCause());

	}

	public GarajeException(Exception e) {
		super.initCause(e);
	}

	public String getMessage() {
		return super.getMessage();
	}

	public Throwable getCause() {
		return super.getCause();
	}


	public String adaptaAFormatoTxt() {
		
		String str = "";
		str = str.concat(String.valueOf(Calendar.getInstance().get(Calendar.DATE)));
		str = str.concat(";");
		str = str.concat(String.valueOf(super.getClass().getSimpleName()));
		str = str.concat(";");
		str = str.concat(String.valueOf(getCause()));

		return str;
		
	}

}

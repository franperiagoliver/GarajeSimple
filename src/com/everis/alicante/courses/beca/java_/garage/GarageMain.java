package com.everis.alicante.courses.beca.java_.garage;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import com.everis.alicante.courses.beca.java_.garage.controller.ControladorGaraje;
import com.everis.alicante.courses.beca.java_.garage.controller.ControladorGarajeImpl;
import com.everis.alicante.courses.beca.java_.garage.domain.Garaje;
import com.everis.alicante.courses.beca.java_.garage.domain.Plaza;

public class GarageMain {

	static Garaje garaje;

	static ControladorGaraje controlador;

	public static void main(String[] args) throws IOException {

		inicializarComponentes();

		// iniciar aplicacion o listar menu

		iniciarAplicacion();

	}

	@SuppressWarnings("resource")
	private static void iniciarAplicacion() throws IOException, ParseException {

		System.out.println("*******************************************************");

		System.out.println("Bienvenido a nuestro garaje, seleccione una opcion: ");
		System.out.println("1:Listar Plazas Garaje Libre ");
		System.out.println("2:Listar Plazas Garaje Ocupadas ");
		System.out.println("3:Reservar Plazas");
		System.out.println("4:Listar Clientes");
		System.out.println("5:Listar Reservas");
		System.out.println("6:Listar Vehiculos");
		System.out.println("7:Listar por fecha de reserva");

		Scanner in = new Scanner(System.in);
		Integer opcion = in.nextInt();
		boolean resultado = true;
		Map<Integer, Plaza> mapa = null;

		System.out.println("Ha elegido la opcion :" + opcion);

		Date fechaInicio = null;
		Date fechaFin = null;

		switch (opcion) {
		case 1:
			mapa = controlador.listarPlazasLibres();
			break;
		case 2:
			controlador.listarPlazasOcupadas();
			break;
		case 3:
			resultado = controlador.reservarPlaza();
			break;
		case 4:
			controlador.listarClientes();
			break;
		case 5:
			controlador.listarReservas();
			break;
		case 6:
			controlador.listarVehiculos();
			break;
		case 7:
			validarFechasEntrada(fechaInicio, fechaFin);
			controlador.listarReservasByFecha(fechaInicio, fechaFin);
			break;
		default:
			System.out.println("Error");
			break;
		}

		if (opcion == 1) {

			for (Iterator<Plaza> iterator = mapa.values().iterator(); iterator.hasNext();) {

				Plaza plaza = (Plaza) iterator.next();

				System.out.println("Plaza libre numero: " + plaza.getNumeroPlaza());

			}
		}

		if (opcion == 3 && resultado) {
			System.out.println("Se ha reservado su plaza");
		} else if (opcion == 3) {
			System.out.println("No hay plazas disponibles");
		}

		iniciarAplicacion();

	}

	public static void inicializarComponentes() throws IOException {

		garaje = new Garaje();
		controlador = new ControladorGarajeImpl();

	}

	public static void validarFechasEntrada(Date fechaInicio, Date fechaFin) throws ParseException {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyy");

		if (fechaInicio == null) {

			System.out.println("Introduce la fecha de inicio para la búsqueda en formato dd/MM/yyyy: ");
			Scanner in = new Scanner(System.in);
			String tmp = in.nextLine();

			try {

				fechaInicio = formatter.parse(tmp);
				System.out.println("Introduce la fecha de fin para la búsqueda en formato dd/MM/yyyy: ");
				in = new Scanner(System.in);
				tmp = in.nextLine();

				fechaFin = formatter.parse(tmp);

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("La fecha introducida no está en el formato correcto");
				validarFechasEntrada(fechaInicio, fechaFin);
			}
		}

		else if (fechaFin == null) {

			System.out.println("Introduce la fecha de fin para la búsqueda en formato dd/MM/yyyy: ");
			Scanner in = new Scanner(System.in);
			String tmp = in.nextLine();

			fechaFin = formatter.parse(tmp);
		}

	}

}

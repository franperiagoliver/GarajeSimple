package com.everis.alicante.courses.beca.java_.garage.domain.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.everis.alicante.courses.beca.java_.garage.GarageMain;
import com.everis.alicante.courses.beca.java_.garage.domain.Camion;
import com.everis.alicante.courses.beca.java_.garage.domain.Cliente;
import com.everis.alicante.courses.beca.java_.garage.domain.Coche;
import com.everis.alicante.courses.beca.java_.garage.domain.Garaje;
import com.everis.alicante.courses.beca.java_.garage.domain.Moto;
import com.everis.alicante.courses.beca.java_.garage.domain.Plaza;
import com.everis.alicante.courses.beca.java_.garage.domain.Reserva;
import com.everis.alicante.courses.beca.java_.garage.domain.Vehiculo;
import com.everis.alicante.courses.beca.java_.garage.interfaces.Aparcable;
import com.everis.alicante.courses.beca.java_.garage.interfaces.ClienteDAO;
import com.everis.alicante.courses.beca.java_.garage.interfaces.ReservaDAO;
import com.everis.alicante.courses.beca.java_.garage.interfaces.VehiculoDAO;
import com.everis.alicante.courses.beca.java_.garage.interfaces.implementation.ClienteDAOFileImp;
import com.everis.alicante.courses.beca.java_.garage.interfaces.implementation.ReservaDAOFileImp;
import com.everis.alicante.courses.beca.java_.garage.interfaces.implementation.VehiculoDAOFileImp;

public class ControladorGarajeImpl implements ControladorGaraje {

	public void listarPlazasLibres() {

		List<Plaza> plazasLibres = new ArrayList<Plaza>();

		List<Plaza> plazas = GarageMain.getGaraje().getPlaza();

		for (Plaza plaza : plazas) {

			if (plaza.getLibre()) {
				plazasLibres.add(plaza);
			}
		}

		for (Plaza plaza : plazasLibres) {
			System.out.println(plaza);
		}
	}

	public void listarPlazasOcupadas() {

		List<Plaza> plazasOcupadas = new ArrayList<Plaza>();

		List<Plaza> plazas = GarageMain.getGaraje().getPlaza();

		for (Plaza plaza : plazas) {

			if (!plaza.getLibre()) {
				plazasOcupadas.add(plaza);
			}
		}

		for (Plaza plaza : plazasOcupadas) {
			System.out.println(plaza);
		}
	}

	@Override
	public boolean reservarPlaza() throws IOException {

		ReservaDAO daoReserva = new ReservaDAOFileImp();
		ClienteDAO daoCliente = new ClienteDAOFileImp();
		VehiculoDAO daoVehiculo = new VehiculoDAOFileImp();

		Cliente cliente = new Cliente();
		Vehiculo vehiculoCliente = new Coche();

		System.out.println("Para reservar un plaza necesitamos tus datos");
		System.out.println("Escribe tu NIF");
		Scanner nifEntrada = new Scanner(System.in);
		String nif = nifEntrada.nextLine();
		cliente.setNif(nif);
		System.out.println("Ahora escribe tu nombre");
		Scanner nombreEntrada = new Scanner(System.in);
		String nombre = nombreEntrada.nextLine();
		cliente.setNombreCompleto(nombre);
		System.out.println("¿Cuál es tu tipo de vehículo? 1: Coche 2: Moto 3: Camión");
		Scanner tipoVehiculoEntrada = new Scanner(System.in);
		Integer tipoVehiculo = tipoVehiculoEntrada.nextInt();

		switch (tipoVehiculo) {
		case 1:
			vehiculoCliente = new Coche();
			break;
		case 2:
			vehiculoCliente = new Moto();
			break;
		case 3:
			vehiculoCliente = new Camion();
		default:
			break;
		}

		System.out.println("Escribe la matrícula");
		Scanner matriculaEntrada = new Scanner(System.in);
		String matricula = matriculaEntrada.nextLine();
		vehiculoCliente.setMatricula(matricula);
		vehiculoCliente.setTipoVehiculo(vehiculoCliente.getClass().getSimpleName());

		// if (vehiculoCliente instanceof Coche) {
		// vehiculoCliente.setTipoVehiculo("Coche");
		// }

		System.out.println("Dime la marca");
		Scanner marcaEntrada = new Scanner(System.in);
		String marca = matriculaEntrada.nextLine();

		if (vehiculoCliente instanceof Coche) {
			((Coche) (vehiculoCliente)).setMarca(marca);
		}

		cliente.setVehiculo(vehiculoCliente);

		System.out.println(cliente.toString());
		System.out.println(vehiculoCliente.toString());

		boolean hayPlaza = false;
		Garaje garaje = GarageMain.getGaraje();
		List<Plaza> plazas = garaje.getPlaza();

		for (Plaza plaza : plazas) {

			if (plaza.getLibre() && vehiculoCliente instanceof Aparcable) {

				plaza.setCliente(cliente);
				hayPlaza = true;

				Reserva reserva = new Reserva();
				reserva.setCliente(cliente);
				reserva.setNumeroPlaza(plaza);
				reserva.setFechaReserva(Calendar.getInstance().getTime());
				reserva.setCodigoReserva(String.valueOf(plaza.getNumeroPlaza()));
				daoReserva.createReserva(reserva);
				daoCliente.createCliente(cliente);
				daoVehiculo.createVehiculo(vehiculoCliente);

				return hayPlaza;
			}
		}

		return hayPlaza;
	}

	public void listarClientes() throws IOException {

		ClienteDAO daoCliente = new ClienteDAOFileImp();

		Map<String, Cliente> clientes = daoCliente.readCliente();

		Collection<Cliente> collection = clientes.values();

		for (Iterator iterator = collection.iterator(); iterator.hasNext();) {
			Cliente cliente = (Cliente) iterator.next();

			System.out.println(cliente.getNombreCompleto() + ";" + cliente.getNif());

		}
		// System.out.println(clientes.keySet());
		//
		// System.out.println("------------------------------------------------------");
		//
		// System.out.println(clientes.values());
		//
		// System.out.println("------------------------------------------------------");
		//
		// clientes.values().contains("PEPE");
		//
		// clientes.get("98523526");
		//
		// System.out.println(clientes);
	}

	@Override
	public void listarReservas() throws IOException {
		ReservaDAO reservaDAO = new ReservaDAOFileImp();
		Map<String, Reserva> reservas = reservaDAO.readReserva();

		Collection<Reserva> listaReservas = reservas.values();

		for (Reserva reserva : listaReservas) {
			System.out.println("Número de plaza reservada: " + reserva.getNumeroPlaza());
			System.out.println("Cliente: " + reserva.getCliente().getNombreCompleto());
			System.out.println("Vehiculo: " + reserva.getCliente().getVehiculo().getMatricula() + "-"
					+ reserva.getCliente().getVehiculo().getTipoVehiculo());
		}
	}

	@Override
	public void listarVehiculos() throws IOException {
		// TODO Auto-generated method stub

		VehiculoDAO daoVehiculo = new VehiculoDAOFileImp();

		Collection<Vehiculo> vehiculos = daoVehiculo.readVehiculo().values();

		for (Vehiculo vehiculo : vehiculos) {

			System.out.println(vehiculo.getMatricula() + "-" + vehiculo.getTipoVehiculo());
		}

	}
}

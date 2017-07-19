package com.everis.alicante.courses.beca.java_.garage;
import java.io.IOException;
import java.util.Scanner;

import com.everis.alicante.courses.beca.java_.garage.domain.Garaje;
import com.everis.alicante.courses.beca.java_.garage.domain.controller.ControladorGaraje;
import com.everis.alicante.courses.beca.java_.garage.domain.controller.ControladorGarajeImpl;
import com.everis.alicante.courses.beca.java_.garage.interfaces.ClienteDAO;
import com.everis.alicante.courses.beca.java_.garage.interfaces.PlazaDAO;
import com.everis.alicante.courses.beca.java_.garage.interfaces.ReservaDAO;
import com.everis.alicante.courses.beca.java_.garage.interfaces.VehiculoDAO;
import com.everis.alicante.courses.beca.java_.garage.interfaces.implementation.ClienteDAOFileImp;
import com.everis.alicante.courses.beca.java_.garage.interfaces.implementation.PlazaDAOFileImp;
import com.everis.alicante.courses.beca.java_.garage.interfaces.implementation.ReservaDAOFileImp;
import com.everis.alicante.courses.beca.java_.garage.interfaces.implementation.VehiculoDAOFileImp;

public class GarageMain {
	
	static Garaje garaje;
	
	public static Garaje getGaraje() {
		return garaje;
	}

	static ControladorGaraje controlador;
	
	public static void main(String[] args) throws IOException {
		
		// Inicializar los componentes de la aplicación.
		
		// 4 clientes.
		
		// 5 vehiculos.
		
		// 30 plazas de garaje.
		
		// 1 garaje.
		
		inicializarComponentes();
		
		// Iniciar aplicación (Listar menú por pantalla).
		
		iniciarAplicacion();

	}
	
	private static void iniciarAplicacion() throws IOException {
		
		System.out.println("***********************************************************");
		System.out.println("***********************************************************");
		System.out.println("Bienvenido a nuestro garaje, seleccione una opción: \n");
		System.out.println("1: Listar Plazas Garaje libres");
		System.out.println("2: Listar Plazas Garaje ocupadas");
		System.out.println("3: Reservar plazas");
		System.out.println("4: Listar clientes");
		System.out.println("5: Listar reservas");
		
		Scanner in = new Scanner(System.in);
		Integer opcion = in.nextInt();
		Boolean resultado = true;
		
		System.out.println("Ha elegido la opción: " + opcion);
		
		switch (opcion) {
		case 1:
			
			controlador.listarPlazasLibres();
			break;
			
		case 2:
			
			controlador.listarPlazasOcupadas();
			break;
		
		case 3:
			resultado=controlador.reservarPlaza();
			break;
			
		case 4:
			controlador.listarClientes();
			break;
			
		case 5:
			controlador.listarReservas();
			break;
			
		default:
			break;
		}
		
		if (opcion == 3 && resultado) {
			System.out.println("Se ha reservado tu plaza");
		}
		else if (opcion == 3){
			System.out.println("No hay plazas disponibles");
		}
		
		iniciarAplicacion();
		
	}

	public static void inicializarComponentes() throws IOException {
		
		garaje = new Garaje();
		
		PlazaDAO plazaDAO = new PlazaDAOFileImp();
		ReservaDAO reservaDAO = new ReservaDAOFileImp();
		ClienteDAO clienteDAO = new ClienteDAOFileImp();
		VehiculoDAO vehiculoDAO = new VehiculoDAOFileImp();
		
		garaje.setPlaza(plazaDAO.readPlaza());
		
		garaje.setClientes(clienteDAO.readCliente());
		
		garaje.setVehiculos(vehiculoDAO.readVehiculo());
		
		garaje.setReservas(reservaDAO.readReserva());
		
		controlador = new ControladorGarajeImpl();
		
	}
	
	
}


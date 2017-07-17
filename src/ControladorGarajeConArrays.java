import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ControladorGarajeConArrays implements ControladorGaraje {

	public void listarPlazasLibres() {
		
		List<Plaza> plazasLibres = new ArrayList<Plaza>();
		
		Plaza [] plazas= GarageMain.getGaraje().getPlaza();
		
		for (int i = 0; i < plazas.length; i++) {
			Plaza plaza = plazas[i];
			
			if (plaza.getLibre()) {
				plazasLibres.add(plaza);
			}
		}
		
		for (Plaza plaza : plazasLibres) {
			System.out.println(plaza);
		}
	}

	public Plaza[] listarPlazasOcupadas() {
		
		return null;
	}

	@Override
	public boolean reservarPlaza() {
		
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
		
		switch(tipoVehiculo) {
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
		System.out.println("Dime la marca");
		Scanner marcaEntrada = new Scanner(System.in);
		String marca = matriculaEntrada.nextLine();
		
		if (vehiculoCliente instanceof Coche) {
			((Coche)(vehiculoCliente)).setMarca(marca);
		}
		
		cliente.setVehiculo(vehiculoCliente);
		
		System.out.println(cliente.toString());
		System.out.println(vehiculoCliente.toString());
		
		boolean hayPlaza = false;
		Garaje garaje = GarageMain.getGaraje();
		Plaza [] plazas = garaje.getPlaza();
		
		for (int i = 0; i < plazas.length; i++) {
			
			Plaza plaza = plazas[i];
			
			if (plaza.getLibre() && vehiculoCliente instanceof Aparcable) {
				
				plaza.setCliente(cliente);
				hayPlaza = true;
				return hayPlaza;
				
			}
		}
		
		return hayPlaza;
	}
}

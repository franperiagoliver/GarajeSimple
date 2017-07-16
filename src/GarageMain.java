import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class GarageMain {

	public static void main(String[] args) {
		
		//4 clientes
		
		//5 vehiculos
		
		//30 plazas de garaje
		
		//1 garaje
		
		inicializarComponentes();

	}
	
	public static void inicializarComponentes() {
		
		List<Vehiculo> vehiculos = new ArrayList<>();
		List<Cliente> clientes = new ArrayList<>();
		List<Plaza> plazas = new ArrayList<>();
		Garaje garaje = new Garaje();
		
		//INICIALIZAR VEHICULOS
		for (int i = 0; i < 5; i++) {
			Random rn = new Random();
			int range = 9999 - 1000 + 1;
			int randomNum =  rn.nextInt(range) + 100;
			
			String matricula = String.valueOf(randomNum).concat("ALC");
			Vehiculo vehiculo = new Vehiculo();
			vehiculo.setMatricula(matricula);
			vehiculos.add(vehiculo);
		}
		
		//INICIALIZAR CLIENTES
		for (int i = 0; i < 4; i++) {
			Cliente cliente = new Cliente();
			Random rn = new Random();
			int range = 9999999 - 1000000 + 1;
			int randomNum =  rn.nextInt(range) + 100;
			
			String nif = String.valueOf(randomNum).concat("L");
			cliente.setNif(nif);
			String nombre = "Remedios Lopez";
			cliente.setNombreCompleto(nombre);
			cliente.setVehiculo(vehiculos.get(i));
			clientes.add(cliente);
		}
		
		//INICIALIZAR PLAZAS
		for (int i = 0; i < 30; i++) {
			Plaza plaza = new Plaza();
			plaza.setPrecio(125.00);
			plazas.add(plaza);
		}
		
		for (int j = 0; j < clientes.size(); j++) {
			Plaza plaza = plazas.get(j);
			plaza.setCliente(clientes.get(j));
		}
		
		//INICIALIZAR GARAJE
		for (int i = 0; i < 1; i++) {
			garaje.setPlazas(plazas);
		}
		System.out.println(garaje);
		
//		System.out.println(vehiculos);
//		System.out.println(clientes);
//		System.out.println(plazas);
	}

}

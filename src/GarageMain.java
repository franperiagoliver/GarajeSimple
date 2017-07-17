import java.util.Scanner;

public class GarageMain {
	
	static Garaje garaje;
	
	static ControladorGaraje controlador;
	
	public static void main(String[] args) {
		
		// Inicializar los componentes de la aplicación.
		
		// 4 clientes.
		
		// 5 vehiculos.
		
		// 30 plazas de garaje.
		
		// 1 garaje.
		
		inicializarComponentes();
		
		// Iniciar aplicación (Listar menú por pantalla).
		
		iniciarAplicacion();

	}
	
	private static void iniciarAplicacion() {
		
		System.out.println("Bienvenido a nuestro garaje, seleccione una opción: \n");
		System.out.println("1: Listar Plazas Garaje libres");
		System.out.println("2: Listar Plazas Garaje ocupadas");
		System.out.println("3: Calcular ingresos mensuales");
		
		Scanner in = new Scanner(System.in);
		Integer opcion = in.nextInt();
		
		System.out.println("Ha elegido la opción: " + opcion);
		
		switch (opcion) {
		case 1:
			
			controlador.listarPlazasLibres();
			break;
			
		case 2:
			
			controlador.listarPlazasOcupadas();
			break;
			
		default:
			
			System.out.println("Error");
			break;
		}
		
		in.close();
		
	}

	public static void inicializarComponentes() {
		
		garaje = new Garaje();
		
		Plaza [] plazas = new Plaza[30];
		
		for (int i = 0; i < plazas.length; i++) {
			
			Plaza plazaTemp = new Plaza();
			plazaTemp.setNumeroPlaza(i+1);
			
			if (i < 10) {
				
				plazaTemp.setPrecio(50);
				
			} else if (i < 20) {
				
				plazaTemp.setPrecio(75);
				
			} else {
				
				plazaTemp.setPrecio(100);
				
			}
			
			plazas[i] = plazaTemp;
			
		}
		
		garaje.setPlaza(plazas);
		
		controlador = new ControladorGarajeConArrays();
		
	}
	
	
}


package com.everis.alicante.courses.beca.java_.simple.garage.manager;

import java.util.ArrayList;
import java.util.List;

import com.everis.alicante.courses.beca.java_.simple.garage.domain.Cliente;
import com.everis.alicante.courses.beca.java_.simple.garage.domain.Coche;
import com.everis.alicante.courses.beca.java_.simple.garage.domain.Garaje;
import com.everis.alicante.courses.beca.java_.simple.garage.domain.Plaza;
import com.everis.alicante.courses.beca.java_.simple.garage.domain.Vehiculo;

public class GarajeRunner {

	public static void main(String[] args) {
		
		List<Cliente> clientes = new ArrayList();
		List<Vehiculo> vehiculos = new ArrayList();
		List<Coche> coches = new ArrayList();
		
		// 4 clientes:
		
		for (int i = 0; i < 4; i++) {
			
			Cliente cliente = new Cliente();
			
			cliente.setDni("25664778A" + i);
			cliente.setNombre("Antonio" + i);
			
		}
		
		// 5 coches:
		
		for (int j = 0; j < args.length; j++) {
			
			Coche coche = new Coche();
			Vehiculo vehiculo = new Vehiculo();
				
			
			coche.setMatricula("4552X" + j);
			coche.aparcable();
			coche.setColor("Rojo");
			coche.setMarca("Seat");
			vehiculo.add(coche);
			cliente.setVehiculo(coche);
			

		}
			
		// 30 plazas:
		
		
				
		// 1 garage.
		
		Garaje garaje1 = new Garaje();
		
		}


}
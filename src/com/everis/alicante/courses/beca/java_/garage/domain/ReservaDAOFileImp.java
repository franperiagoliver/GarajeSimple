package com.everis.alicante.courses.beca.java_.garage.domain;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

import com.everis.alicante.courses.beca.java_.garage.interfaces.ReservaDAO;

public class ReservaDAOFileImp implements ReservaDAO {

	@Override
	public void saveReserva(Reserva reserva) throws IOException {
		// TODO Auto-generated method stub
		
		File file = new File("src/resources/Reservas.txt");
		FileWriter writer = new FileWriter(file, true);
		BufferedWriter buffer = new BufferedWriter(writer);
		
		buffer.newLine();
		
		buffer.write(reserva.convierteAFormatoTxt());

		buffer.close();
		
		
		}
	
	public static void main (String [] args) throws IOException {
	
		Reserva reserva = new Reserva();
		
		Cliente cliente = new Cliente();
		cliente.setNif("23299056X");
		
		Plaza plaza = new Plaza();
		plaza.setNumeroPlaza(1);
		
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setMatricula("9541JLF");
		
		cliente.setVehiculo(vehiculo);
		reserva.setCliente(cliente);
		reserva.setNumeroPlaza(plaza);
		reserva.setFechaReserva(Calendar.getInstance().getTime());
		
		ReservaDAO dao = new ReservaDAOFileImp();
		
		dao.saveReserva(reserva);
			
		
	}
}
	

	


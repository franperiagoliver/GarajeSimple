package com.everis.alicante.courses.beca.java_.garage.domain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.everis.alicante.courses.beca.java_.garage.GarageMain;
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

	public List<Reserva> readReserva() throws IOException {
			
			List<Reserva> reservas = new ArrayList<Reserva>();
			
			File file = new File("src/resources/Reservas.txt");
			FileReader reader = new FileReader(file);
			BufferedReader buffer = new BufferedReader(reader);
			
			String linea;
			
			while((linea=buffer.readLine()) != null) {
				
				if (!linea.contains("CODIGO_RESERVA") || linea.isEmpty()) {
					
				Reserva reserva = new Reserva();
				
				String[] temp = linea.split(";");
				
				reserva.setCodigoReserva(temp[0]);
				
				Plaza plaza = GarageMain.getGaraje().getPlaza().get(Integer.parseInt(temp[1]));
				
				reserva.setNumeroPlaza(plaza);
				
				reservas.add(reserva);
				
				}
			}
			
			reader.close();
			
			return reservas;
		}
		
}
	
	

	

	


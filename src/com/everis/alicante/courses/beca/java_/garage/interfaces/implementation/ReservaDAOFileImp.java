package com.everis.alicante.courses.beca.java_.garage.interfaces.implementation;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.TreeMap;

import com.everis.alicante.courses.beca.java_.garage.domain.Reserva;
import com.everis.alicante.courses.beca.java_.garage.interfaces.ClienteDAO;
import com.everis.alicante.courses.beca.java_.garage.interfaces.PlazaDAO;
import com.everis.alicante.courses.beca.java_.garage.interfaces.ReservaDAO;
import com.everis.alicante.courses.beca.java_.garage.interfaces.VehiculoDAO;

public class ReservaDAOFileImp implements ReservaDAO {

	@Override
	public void createReserva(Reserva reserva) throws IOException {
		
		 
		 File file= new File("src/resources/Reservas.txt");
		 FileWriter writer= new FileWriter(file,true);
		 BufferedWriter  buffer= new BufferedWriter(writer);
		
		 buffer.newLine();		 
		 
		 buffer.write(reserva.convierteAFormatoTxt());		
		
		 buffer.close();
		

	}
	
	
	@Override
	public Map<String,Reserva> readReservas() throws IOException {
						
		 Map<String,Reserva> reservas= new TreeMap<String,Reserva>();
		 
		 PlazaDAO daoPlaza= new PlazaDAOFileImp();
		 ClienteDAO daocliente= new ClienteDAOFileImpl();
		 VehiculoDAO daoVehiculo= new VehiculoDAOFileImpl();
		 
		 String linea;
		 
		 File file= new File("src/resources/Reservas.txt");
		 FileReader reader= new FileReader(file);
		 BufferedReader  buffer= new BufferedReader(reader);
		 		 
		 while((linea=buffer.readLine())!=null){				  
			
			if(!linea.contains("CODIGO_RESERVA")||linea.isEmpty()){
				
				Reserva reserva= new Reserva();			
				
				String[] temp= linea.split(";");
				
				reserva.setCodigoReserva(temp[0]);		
								
				reserva.setNumeroPlaza(daoPlaza.readPlaza(Integer.parseInt(temp[1])));	
				
				reserva.setCliente(daocliente.readCliente(temp[2]));
								
				reserva.getCliente().setVehiculo(daoVehiculo.readVehiculo(temp[3]));
				
				String fecha = temp[4];
				
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyy");
				
				reserva.setFechaReserva(temp[4]);;
				
				reservas.put(reserva.getCodigoReserva(),reserva);	
			
			}
			
		 }
			 
		 reader.close();		
		 	  	
		return  reservas;
	}

}

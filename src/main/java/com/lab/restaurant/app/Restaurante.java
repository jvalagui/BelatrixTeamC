package main.java.com.lab.restaurant.app;

import java.util.List;

import main.java.com.lab.restaurant.model.Comedor;
import main.java.com.lab.restaurant.model.Mesa;
import main.java.com.lab.restaurant.model.Mesero;
import main.java.com.lab.restaurant.model.Visita;
import main.java.com.lab.restaurant.transaction.Recepcion;
import main.java.com.lab.restaurant.utils.InicializationHelper;

public class Restaurante {

	
	public static void main(String[] args){
		
		InicializationHelper inicializador = new InicializationHelper();
		
		Recepcion recepcion = new Recepcion();

		for(int i = 0; i<15; i++){
			recepcion.generarVisita(i+1, "CLIENTE"+String.format("%02", i+1));
		}
		
		for(Visita visita : Visita.read()){
			List<Mesa> listaMesasDesocupadas = recepcion.mesasDisponibles();
			recepcion.asignarMesa(listaMesasDesocupadas.get(0).getId());
		}
		
		
		
	}
}

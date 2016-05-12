package main.java.com.lab.restaurant.model;

import java.util.ArrayList;
import java.util.List;

public class Comedor{

	private static List<Mesa> listaMesas = Mesa.read();
	private static List<Mesero> listaMeseros = Mesero.read();
	
	public static List<Mesa> getMesasDisponibles(){
		List<Mesa> disponibles = new ArrayList<>();
		for(Mesa m : listaMesas){
			if(!m.isUsada()){
				disponibles.add(m);
			}	
		}
		return disponibles;
	}
	
	
	public static List<Mesero> getMeserosDisponibles(){
		
		List<Mesero> disponibles = new ArrayList<>();
		
		for(Mesero m : listaMeseros){
			if(!m.isDisponible()){
				disponibles.add(m);
			}
		}
		
		return disponibles;
	}
	
	public static void asignarMesa(int idMesa, Visita visita){
		Mesa mesa = Mesa.read(idMesa);
		mesa.setUsada(true);
		visita.setIdMesa(idMesa);
	}
	
	public static boolean asignarMesero(int idMesero, int idMesa){
		if(Mesa.cantidadAtendidasPorMesero(idMesero) <= Mesero.limiteMesas){
			Mesa mesa = Mesa.read(idMesa);
			mesa.setIdMesero(idMesero);
			return true;
		}else{
			System.out.println("El mesero ya llegó a su límite de mesas");
			return false;
		}
		
	}
	
	
	
	//public static void ingresarCola(Visita visita){
	//	queue.insert(visita);
	//}
	
	public static void despedirVisita(Visita visita){
		Mesa mesa = Mesa.read(visita.getIdMesa());
		mesa.setIdMesero(-1);
		mesa.setUsada(false);
	}
	
}

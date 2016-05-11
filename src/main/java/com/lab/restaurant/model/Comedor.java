package main.java.com.lab.restaurant.model;

import java.util.ArrayList;
import java.util.List;

public class Comedor{

	private static List<Mesa> listaMesas = Mesa.read();
	private static List<Mesero> listaMeseros = Mesero.read();
	public static Queue queue2sillas = new Queue();
	public static Queue queue4sillas = new Queue();
	public static Queue queue6sillas = new Queue();
	
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
	
	public static boolean mesaDisponible(int capacidad){
		boolean disponible = false;
		for(Mesa m : getMesasDisponibles()){
			if(m.getCapacidad() == capacidad){
				disponible = true;
			}
		}
		return disponible;
	}
	
	public static void asignarMesa(int idMesa, Visita visita){
		Mesa mesa = Mesa.read(idMesa);
		mesa.setUsada(true);
		visita.getIdMesas().add(idMesa);
	}
	
	public static void asignarMesero(int idMesero, int idMesa){
		Mesa mesa = Mesa.read(idMesa);
		mesa.setIdMesero(idMesero);
		Mesero mesero = Mesero.read(idMesero);
		mesero.setMesasAtendidas(mesero.getMesasAtendidas()+1);
	}
	
	public static void despedirVisita(Visita visita){
		liberarMesasyMeseros(visita);
		Visita.delete(visita);
	}
	
	public static void liberarMesasyMeseros(Visita visita){
		for(int x : visita.getIdMesas()){
			Mesa mesa = Mesa.read(x);
			Mesero mesero = Mesero.read(mesa.getIdMesero());
			mesero.setMesasAtendidas(mesero.getMesasAtendidas()-1);
			mesa.setIdMesero(-1);
			mesa.setUsada(false);
		}
	}
	
}

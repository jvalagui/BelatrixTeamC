package main.java.com.lab.restaurant.model;

import java.util.ArrayList;
import java.util.List;

public class Comedor{

	private List<Mesa> listaMesas = Mesa.read();
	private List<Mesero> listaMeseros = Mesero.read();
	
	public boolean lleno(){
		boolean lleno = true;
		for(Mesa mesa : listaMesas){
			if(mesa.isUsada()==false){ lleno = false;}
		}
		return lleno;
	}
	
	public List<Mesa> getMesasDisponibles(){
		return Mesa.getMesasDisponibles();
	}
	
	public Mesa obtenerMesaDisponible(){
		return Mesa.obtenerMesaDisponible();
	}
	
	
	public List<Mesero> getMeserosDisponibles(){
		
		List<Mesero> disponibles = new ArrayList<>();
		
		for(Mesero mesero : listaMeseros){
			if(!mesero.isDisponible()){
				disponibles.add(mesero);
			}
		}
		
		return disponibles;
	}
	
	public void asignarMesa(int idMesa, Visita visita){
		Mesa mesa = Mesa.read(idMesa);
		mesa.setUsada(true);
		visita.setIdMesa(idMesa);
	}
	
	public boolean asignarMesero(int idMesero, int idMesa){
		if(Mesa.cantidadAtendidasPorMesero(idMesero) <= Mesero.LIMITE_MESAS){
			Mesa mesa = Mesa.read(idMesa);
			mesa.setIdMesero(idMesero);
			return true;
		}else{
			System.out.println("El mesero ya llegó a su límite de mesas");
			return false;
		}
		
	}
			
	public void despedirVisita(Visita visita){
		Mesa mesa = Mesa.read(visita.getIdMesa());
		mesa.setIdMesero(-1);
		mesa.setUsada(false);
	}
	
}

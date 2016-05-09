package main.java.com.lab.restaurant.model;

import java.util.ArrayList;
import java.util.List;

public class Comedor {

	private List<Mesa> listaMesas = Mesa.read();
	private List<Mesero> listaMeseros; //TODO
	
	
	public List<Integer> getIdMesasDisponibles(){
		
		List<Integer> disponibles = new ArrayList<>();
		
		for(Mesa m : listaMesas){
			
			if(!m.isUsada()){
				disponibles.add(m.getId());
			}
			
		}
		
		return disponibles;
	}
	
	
	public List<Integer> getIdMeserosDisponibles(){
		
		List<Integer> disponibles = new ArrayList<>();
		
		/* 
		 * TODO
		 * 
		for(Mesero m : listaMesas){
			
			if(!m.isUsada()){
				disponibles.add(m.getId());
			}
			
		}
		*/
		
		return disponibles;
	}
	
	
}

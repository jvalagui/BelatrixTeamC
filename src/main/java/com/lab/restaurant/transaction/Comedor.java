package main.java.com.lab.restaurant.transaction;

import java.util.ArrayList;
import java.util.List;

import main.java.com.lab.restaurant.model.Mesa;
import main.java.com.lab.restaurant.model.Mesero;
import main.java.com.lab.restaurant.model.Visita;
import main.java.com.lab.restaurant.transaction.services.MesaService;
import main.java.com.lab.restaurant.transaction.services.MeseroService;
import main.java.com.lab.restaurant.transaction.services.VisitaService;

public class Comedor{
	MesaService mesaService = new MesaService();
	MeseroService meseroService = new MeseroService();
	VisitaService visitaService = new VisitaService();

	private List<Mesa> listaMesas = mesaService.read();
	private List<Mesero> listaMeseros = meseroService.read();
	
	public boolean lleno(){
		boolean lleno = true;
		for(Mesa mesa : listaMesas){
			if(mesa.isUsada()==false){ lleno = false;}
		}
		return lleno;
	}
	
	public List<Mesa> getMesasDisponibles(){
		return mesaService.getMesasDisponibles();
	}
	
	public Mesa obtenerMesaDisponible(){
		return mesaService.obtenerMesaDisponible();
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
	
	public Mesa asignarMesa(Visita visita){
		
		if(mesaService.obtenerMesaDisponible()==null){
			return null;
		}
		
		int idMesa = mesaService.obtenerMesaDisponible().getId();
		
		Mesa mesa = mesaService.read(idMesa);
		mesa.setUsada(true);
		visita.setIdMesa(idMesa);
		
		return mesa;
	}
	
	public boolean asignarMesero(int idMesero, int idMesa){
		if(mesaService.cantidadAtendidasPorMesero(idMesero) < Mesero.LIMITE_MESAS){
			Mesa mesa = mesaService.read(idMesa);
			mesa.setIdMesero(idMesero);
			return true;
		}else{
			System.out.println("El mesero ya llegó a su límite de mesas");
			return false;
		}
		
	}
			
	public void despedirVisita(Visita visita){
		Mesa mesa = mesaService.read(visita.getIdMesa());
		mesa.setIdMesero(-1);
		mesa.setUsada(false);
	}
	
}

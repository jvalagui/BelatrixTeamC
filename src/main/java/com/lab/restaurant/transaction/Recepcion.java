package main.java.com.lab.restaurant.transaction;


import java.util.List;

import main.java.com.lab.restaurant.model.Cliente;
import main.java.com.lab.restaurant.model.Mesa;
import main.java.com.lab.restaurant.model.Mesero;
import main.java.com.lab.restaurant.model.Visita;
import main.java.com.lab.restaurant.transaction.services.ClienteService;
import main.java.com.lab.restaurant.transaction.services.VisitaService;
import main.java.com.lab.restaurant.utils.Queue;



public class Recepcion {
	ClienteService clienteService = new ClienteService();
	VisitaService visitaService = new VisitaService();
	
	private Queue salaDeEspera = new Queue();
	private Cliente cliente = null;
	private Visita visita = null;
	private Comedor comedor = new Comedor();
	
	
	// Cliente nuevo
	public void generarVisita(int idCliente, String nombreCliente){
		cliente = new Cliente(idCliente, nombreCliente);
		clienteService.create(cliente);
		visita = new Visita(idCliente,cliente.getId());
		visitaService.create(visita);
	}
	
	// Cliente antiguo
	public void generarVisita(int idCliente){
		visita = new Visita(idCliente,idCliente);
		visitaService.create(visita);
	}
	
	public String asignarMesa(int idVisita){
		String msg = "";
		Visita visita = visitaService.read(idVisita);
		Mesa mesa = comedor.obtenerMesaDisponible();
		
		if(!comedor.lleno()){
			if(mesa.isUsada() == false ){
				comedor.asignarMesa(mesa.getId(), visita);
				comedor.asignarMesero(Mesero.obtenerMeseroDesocupado().getId(), mesa.getId());
				msg = "Mesa asignada";
			}else{
				msg = "La mesa se encuentra ocupada";
			}
		}else{
			salaDeEspera.insert(visita);
			msg = "Visita ingresada a la sala de espera";
		}
		
		return msg;
	}
	
	public void asignarSalaAlDespedirVisita(int idMesa){
		if(!salaDeEspera.isEmpty()){
			visita = salaDeEspera.peek();
			comedor.asignarMesa(idMesa, visita);
			comedor.asignarMesero(Mesero.obtenerMeseroDesocupado().getId(), idMesa);
			salaDeEspera.remove();
		}
	}
	
	public void despedirVisita(Visita visita){
		comedor.despedirVisita(visita);
		
		asignarSalaAlDespedirVisita(visita.getIdMesa());
	}
	
	
	public List<Mesa> mesasDisponibles(){
		return comedor.getMesasDisponibles();
	}
	
	
}

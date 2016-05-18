package main.java.com.lab.restaurant.transaction;


import java.util.List;

import main.java.com.lab.restaurant.constantes.VisitaEstados;
import main.java.com.lab.restaurant.model.Cliente;
import main.java.com.lab.restaurant.model.Mesa;
import main.java.com.lab.restaurant.model.Visita;
import main.java.com.lab.restaurant.transaction.services.ClienteService;
import main.java.com.lab.restaurant.transaction.services.MesaService;
import main.java.com.lab.restaurant.transaction.services.MeseroService;
import main.java.com.lab.restaurant.transaction.services.VisitaService;
import main.java.com.lab.restaurant.utils.Queue;



public class Recepcion {
	ClienteService clienteService = new ClienteService();
	MeseroService meseroService = new MeseroService();
	VisitaService visitaService = new VisitaService();
	MesaService mesaService = new MesaService();
	
	private Queue salaDeEspera = new Queue();
	private Cliente cliente = null;
	private Visita visita = null;
	private Comedor comedor = new Comedor();
	
	
	// Cliente nuevo
	public void generarVisita(int idVisita, int idCliente, String nombreCliente){
		cliente = new Cliente(idCliente, nombreCliente);
		clienteService.create(cliente);
		
		visita = new Visita(idVisita,cliente.getId());
		visita.setEstado(VisitaEstados.EN_RECEPCION);
		visitaService.create(visita);
	}
	
	// Cliente antiguo
	public void generarVisita(int idVisita, int idCliente){
		visita = new Visita(idVisita,idCliente);
		visita.setEstado(VisitaEstados.EN_RECEPCION);
		visitaService.create(visita);
	}
	
	public String asignarMesa(int idVisita){
		String msg = "";
		Visita visita = visitaService.read(idVisita);
		
		if(!comedor.lleno() && meseroService.hayDesocupados()){
			
			setEstadoVisita(visita, VisitaEstados.EN_COMEDOR);
			
			Mesa mesa = comedor.asignarMesa(visita);
			comedor.asignarMesero(meseroService.obtenerMeseroMenosOcupado().getId(), mesa.getId());
			msg = "Mesa asignada";				
				
			
		}else{
			agregarASalaDeEspera(visita);
			msg = "Visita ingresada a la sala de espera";
		}
		
		return msg;
	}
	
	public void asignarMesaAlDespedirVisita(){
		
		if(!salaDeEspera.isEmpty() && meseroService.hayDesocupados()){
			
			visita = salaDeEspera.peek();
			
			setEstadoVisita(visita, VisitaEstados.EN_COMEDOR);
			
			Mesa mesa = comedor.asignarMesa(visita);
			
			comedor.asignarMesero(meseroService.obtenerMeseroMenosOcupado().getId(), mesa.getId());
			salaDeEspera.remove();
			
		}
		
	}
	
	public boolean despedirVisita(int idVisita){
		
		Visita visita = visitaService.read(idVisita);
		
		if(visita==null){
			return false;
		}
		
		if(visita.getEstado()==VisitaEstados.CERRADO){
			return false;
		}
		
		setEstadoVisita(visita, VisitaEstados.CERRADO);
		
		comedor.despedirVisita(visita);
		asignarMesaAlDespedirVisita();
		
		return true;
	}
	
	
	public List<Mesa> mesasDisponibles(){
		return comedor.getMesasDisponibles();
	}
	
	public void agregarASalaDeEspera(Visita visita){
		setEstadoVisita(visita, VisitaEstados.EN_ESPERA);
		salaDeEspera.insert(visita);
	}
	
	public Queue getSalaDeEspera(){
		return salaDeEspera;
	}
	
	public void setEstadoVisita(Visita visita, int estado){
		visita.setEstado(estado);
		visitaService.update(visita);
	}
}

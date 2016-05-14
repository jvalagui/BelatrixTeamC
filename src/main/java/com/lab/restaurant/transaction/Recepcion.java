package main.java.com.lab.restaurant.transaction;


import main.java.com.lab.restaurant.model.Cliente;
import main.java.com.lab.restaurant.model.Comedor;
import main.java.com.lab.restaurant.model.Mesa;
import main.java.com.lab.restaurant.model.Mesero;
import main.java.com.lab.restaurant.model.Queue;
import main.java.com.lab.restaurant.model.Visita;



public class Recepcion {
	
	public static Queue salaDeEspera = new Queue();
	public Cliente cliente = null;
	public Visita visita = null;
	
	
	// Cliente nuevo
	public void generarVisita(int idCliente, String nombreCliente){
		cliente = new Cliente(idCliente, nombreCliente);
		Cliente.create(cliente);
		visita = new Visita(cliente.getId());
		Visita.create(visita);
	}
	
	// Cliente antiguo
	public void generarVisita(int idCliente){
		visita = new Visita(idCliente);
		Visita.create(visita);
	}
	
	public String asignarMesa(int idMesa){
		String msg = "";
		Mesa mesa = Mesa.read(idMesa);
		if(!Comedor.lleno()){
			if(mesa.isUsada() == false ){
				Comedor.asignarMesa(idMesa, visita);
				Comedor.asignarMesero(Mesero.obtenerMesero().getId(), idMesa);
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
	
	public void asignarDeSala(int idMesa){
		visita = salaDeEspera.peek();
		Comedor.asignarMesa(idMesa, visita);
		Comedor.asignarMesero(Mesero.obtenerMesero().getId(), idMesa);
		salaDeEspera.remove();
	}
	
	
}

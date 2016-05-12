package main.java.com.lab.restaurant.transaction;

import java.util.List;

import main.java.com.lab.restaurant.model.Cliente;
import main.java.com.lab.restaurant.model.Comedor;
import main.java.com.lab.restaurant.model.Mesa;
import main.java.com.lab.restaurant.model.Mesero;
import main.java.com.lab.restaurant.model.Queue;
import main.java.com.lab.restaurant.model.Visita;

public class Recepcion {
	
	public static Queue salaDeEspera = new Queue();
	public Visita visita = new Visita();
	public Mesa mesa = new Mesa();
	public Mesero mesero = new Mesero();
	
	private static List<Visita> listaVisitas = Visita.read();
	private static List<Mesa> listaMesas = Mesa.read();
	
	void generarVisita(Visita reg){
		Visita.create(reg);
	}
	
	void registrarCliente(Cliente reg){
		Cliente.create(reg);
	}
	
	void asignarMesa(){
		if(!Comedor.lleno()){
			if(mesa.isUsada() == false ){
				Comedor.asignarMesa(mesa.getId(), visita);
				Comedor.asignarMesero(mesa.getIdMesero(), mesa.getId());
			}
		}else{
			salaDeEspera.insert(visita);
		}
	}
	
	void asignarDeSala(){
		visita = salaDeEspera.peek();
		Comedor.asignarMesa(mesa.getId(), visita);
		Comedor.asignarMesero(mesa.getIdMesero(), mesa.getId());
		salaDeEspera.remove();
	}
	
	//public static void ingresarCola(Visita visita){
	//	salaDeEspera.insert(visita);
	//}
}

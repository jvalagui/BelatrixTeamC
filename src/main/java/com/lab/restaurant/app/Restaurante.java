package main.java.com.lab.restaurant.app;

import main.java.com.lab.restaurant.transaction.Recepcion;
import main.java.com.lab.restaurant.transaction.services.ClienteService;
import main.java.com.lab.restaurant.transaction.services.MesaService;
import main.java.com.lab.restaurant.transaction.services.VisitaService;
import main.test.Inicializador;

public class Restaurante {

	ClienteService clienteService = new ClienteService();
	VisitaService visitaService = new VisitaService();
	MesaService mesaService = new MesaService();
	
	public static void main(String[] args){
		Restaurante restaurante = new Restaurante();
	}
	public Restaurante(){
		System.out.println("HOLA!");
		Inicializador inicializador = new Inicializador();
		
		inicializador.inicializar();
		
		Recepcion recepcion = new Recepcion();
		
		for(int i = 0; i<10; i++){
			recepcion.generarVisita(i+1, "Cliente "+String.format("%02d", i+1));
		}
		
		clienteService.read().forEach(System.out::println);
		visitaService.read().forEach(System.out::println);
		
		visitaService.read().forEach(visita -> System.out.println(recepcion.asignarMesa(visita.getId())));

		visitaService.read().forEach(System.out::println);
		mesaService.read().forEach(System.out::println);
		
		System.out.println("CHAU!");

	}
}

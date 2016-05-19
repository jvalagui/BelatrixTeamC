package main.test;

import main.java.com.lab.restaurant.model.Mesa;
import main.java.com.lab.restaurant.model.Mesero;
import main.java.com.lab.restaurant.transaction.services.MesaService;
import main.java.com.lab.restaurant.transaction.services.MeseroService;

public class Inicializador {
	MesaService mesaService = new MesaService();
	MeseroService meseroService = new MeseroService();

	public void inicializar(){

		meseroService.create(new Mesero(1,"12345678", "John", "Gates", "Job"));
		meseroService.create(new Mesero(2,"87654321", "Brian", "Gates", "Job"));/*
		meseroService.create(new Mesero(1,"12345678", "Daniel", "Gates", "Job"));
		meseroService.create(new Mesero(4,"Josset"));
		meseroService.create(new Mesero(5,"Javier"));*/
		
		for(int i = 0; i<7;i++){
			mesaService.create(new Mesa(i+1, false));
		}
	}
}


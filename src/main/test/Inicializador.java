package main.test;

import main.java.com.lab.restaurant.model.Mesa;
import main.java.com.lab.restaurant.model.Mesero;

public class Inicializador {

	public static void inicializar(){
		
		Mesero.create(new Mesero("John"));
		Mesero.create(new Mesero("Brian"));
		Mesero.create(new Mesero("Daniel"));
		Mesero.create(new Mesero("Josset"));
		Mesero.create(new Mesero("Javier"));
		
		for(int i = 0; i<10;i++){
			Mesa.create(new Mesa());
		}
	}
}


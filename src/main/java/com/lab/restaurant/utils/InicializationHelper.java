package main.java.com.lab.restaurant.utils;

import main.java.com.lab.restaurant.model.Mesa;
import main.java.com.lab.restaurant.model.Mesero;

public class InicializationHelper {
	public InicializationHelper(){
		Mesero.create(new Mesero("John"));
		Mesero.create(new Mesero("Brian"));
		Mesero.create(new Mesero("Daniel"));
		Mesero.create(new Mesero("Josset"));
		Mesero.create(new Mesero("Javier"));
		
		Mesa.create(new Mesa());
		Mesa.create(new Mesa());
		Mesa.create(new Mesa());
		Mesa.create(new Mesa());
		Mesa.create(new Mesa());
		Mesa.create(new Mesa());
		Mesa.create(new Mesa());
		Mesa.create(new Mesa());
		Mesa.create(new Mesa());
		Mesa.create(new Mesa());
	}
}

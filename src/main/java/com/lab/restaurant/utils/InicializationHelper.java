package main.java.com.lab.restaurant.utils;

import main.java.com.lab.restaurant.model.Mesa;
import main.java.com.lab.restaurant.model.Mesero;

public class InicializationHelper {
	public InicializationHelper(){
		Mesero.create(new Mesero(1,"John"));
		Mesero.create(new Mesero(2,"Brian"));
		Mesero.create(new Mesero(3,"Daniel"));
		Mesero.create(new Mesero(4,"Josset"));
		Mesero.create(new Mesero(5,"Javier"));
		
		for(int i = 0; i<10;i++){
			Mesa.create(new Mesa(i+1));
		}
	}
}

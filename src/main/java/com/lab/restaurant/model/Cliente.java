package main.java.com.lab.restaurant.model;

public class Cliente extends Persona{
	public Cliente(){
		
	}
	
	public Cliente(int id,String nombre) {
		super(id,nombre);
	}

	@Override
	public String toString() {
		return "Cliente [getId()=" + getId() + ", getNombre()=" + getNombre()
				+ "]";
	}
}
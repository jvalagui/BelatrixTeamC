package main.java.com.lab.restaurant.model;

public class Cliente extends Persona{
	public Cliente(){
		
	}
	
	public Cliente(int id,String dni, String nombre, String apellidoPaterno, String apellidoMaterno) {
		super(id,dni,nombre,apellidoPaterno,apellidoMaterno);
	}

	@Override
	public String toString() {
		return "Cliente [getId()=" + getId() + ", getDni()=" + getDni() + ", getNombre()=" + getNombre()
				+ ", getApellidoPaterno()=" + getApellidoPaterno() + ", getApellidoMaterno()=" + getApellidoMaterno()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	
	
}
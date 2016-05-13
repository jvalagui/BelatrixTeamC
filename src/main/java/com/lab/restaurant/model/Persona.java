package main.java.com.lab.restaurant.model;

class Persona {
	private static int identityid;
	private int id;
	private String nombre;
	
	static{
		identityid = 0;
	}
	
	{
		identityid++;
		id = identityid;
	}
	
	public Persona(){};
	
	public Persona(String nombre) {
		this.nombre = nombre;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}

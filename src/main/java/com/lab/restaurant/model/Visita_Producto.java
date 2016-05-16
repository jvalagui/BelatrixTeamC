package main.java.com.lab.restaurant.model;

public class Visita_Producto {
	private int id;
	private int idVisita;
	private int idProducto;
	private int cantidad;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdVisita() {
		return idVisita;
	}

	public void setIdVisita(int idVisita) {
		this.idVisita = idVisita;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Visita_Producto(int id, int idVisita, int idProducto, int cantidad) {
		this.id = id;
		this.idVisita = idVisita;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
	}


	
	
}

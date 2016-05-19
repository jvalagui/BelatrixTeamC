package main.java.com.lab.restaurant.model;

/**
 * Created by daniel on 5/14/16.
 */
public class Producto {
    private int id;
    private String nombre;
    private int tipo;
    private int categoria;
    private double costo;

    private double precio;
    private int stock;

	public Producto(int id, String nombre, int tipo, int categoria, double costo, double precio, int stock) {

		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.categoria = categoria;
		this.costo = costo;
		this.precio = precio;
		this.stock = stock;
	}
	
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public double getCosto() {
		return costo;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}

}

package main.java.com.lab.restaurant.model;

/**
 * Created by daniel on 5/14/16.
 */
public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private double costo;
    private CategoriaProducto categoria;
    private TipoProducto tipo;
    
    
    
    
	public Producto(int id, String nombre, double precio, double costo,
			CategoriaProducto categoria, TipoProducto tipo) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.costo = costo;
		this.categoria = categoria;
		this.tipo = tipo;
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
	public CategoriaProducto getCategoria() {
		return categoria;
	}
	public TipoProducto getTipo() {
		return tipo;
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
	public void setCategoria(CategoriaProducto categoria) {
		this.categoria = categoria;
	}
	public void setTipo(TipoProducto tipo) {
		this.tipo = tipo;
	}
    

}

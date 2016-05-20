package main.java.com.lab.restaurant.model;

public class Venta_Detalle {
	private int idVenta;
	private int idProducto;
	private int cantidad;
	
	public Venta_Detalle(int idVenta, int idProducto, int cantidad) {
		this.idVenta = idVenta;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
	}

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
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

	@Override
	public String toString() {
		return "Venta_Detalle [idVenta=" + idVenta + ", idProducto="
				+ idProducto + ", cantidad=" + cantidad + "]";
	}
	
	
}

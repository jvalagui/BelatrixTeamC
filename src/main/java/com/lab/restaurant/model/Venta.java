package main.java.com.lab.restaurant.model;

import java.sql.Timestamp;

public class Venta {
	private int idVenta;
	private String numeroVenta;
	private Timestamp fechaVenta;
	private double totalVenta;
	private int idVisita;

	public Venta(int idVenta, String numeroVenta, Timestamp fechaVenta,
			double totalVenta, int idVisita) {
		this.idVenta = idVenta;
		this.numeroVenta = numeroVenta;
		this.fechaVenta = fechaVenta;
		this.totalVenta = totalVenta;
		this.idVisita = idVisita;
	}

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public String getNumeroVenta() {
		return numeroVenta;
	}

	public void setNumeroVenta(String numeroVenta) {
		this.numeroVenta = numeroVenta;
	}

	public Timestamp getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Timestamp fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public double getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(double totalVenta) {
		this.totalVenta = totalVenta;
	}

	public int getIdVisita() {
		return idVisita;
	}

	public void setIdVisita(int idVisita) {
		this.idVisita = idVisita;
	}

	@Override
	public String toString() {
		return "Venta [idVenta=" + idVenta + ", numeroVenta=" + numeroVenta
				+ ", fechaVenta=" + fechaVenta + ", totalVenta=" + totalVenta
				+ ", idVisita=" + idVisita + "]";
	}

	
}

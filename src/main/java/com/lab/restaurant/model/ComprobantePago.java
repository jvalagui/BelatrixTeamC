package main.java.com.lab.restaurant.model;

import java.sql.Timestamp;

public class ComprobantePago {
	private int idVisita;
	private int id;	
	private Timestamp fecha;
	
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
	public Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public ComprobantePago(int id, int idVisita, Timestamp fecha) {
		this.id = id;
		this.idVisita = idVisita;
		this.fecha = fecha;
	}
	
	
}

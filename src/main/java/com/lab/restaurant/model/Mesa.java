package main.java.com.lab.restaurant.model;

import java.util.ArrayList;
import java.util.List;

public class Mesa {
		
	private int id;
	private int idMesero;
	private boolean usada;
	
	{
		usada = false;
	}
	
	public Mesa(){}
	
	public Mesa(int id){
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public int getIdMesero() {
		return idMesero;
	}

	public void setIdMesero(int idMesero) {
		this.idMesero = idMesero;
	}

	public boolean isUsada() {
		return usada;
	}
	public void setUsada(boolean usada) {
		this.usada = usada;
	}
	
	
	@Override
	public String toString() {
		return "Mesa [id=" + id + ", usada=" + usada + "]";
	}
	
	
}

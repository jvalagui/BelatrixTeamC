package main.java.com.lab.restaurant.model;

import java.util.ArrayList;
import java.util.List;

public class Mesero extends Persona {

	private static List<Mesero> lista = new ArrayList<Mesero>();
	public static final int LIMITE_MESAS = 5;
	private boolean disponible;

	public Mesero() {
	}

	public Mesero(int id, String nombre) {
		super(id, nombre);
		disponible = true;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	@Override
	public String toString() {
		return "Mesero [getId()=" + getId() + ", getNombre()=" + getNombre()
				+ ", estado=" + disponible + "]";
	}

}
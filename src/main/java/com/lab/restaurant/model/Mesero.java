package main.java.com.lab.restaurant.model;

public class Mesero extends Persona {

	public static final int LIMITE_MESAS = 3;
	private boolean disponible;

	public Mesero() {
	}

	public Mesero(int id,String dni, String nombre, String apellidoPaterno, String apellidoMaterno) {
		super(id,dni,nombre,apellidoPaterno,apellidoMaterno);
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
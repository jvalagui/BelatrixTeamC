
package main.java.com.lab.restaurant.model;

import java.util.ArrayList;
import java.util.List;

public class Mesero extends Persona{
	
	private static List<Mesero> lista = new ArrayList<Mesero>();
	public static final int LIMITE_MESAS = 5;
	private boolean disponible;

	public Mesero(){}
	
	public Mesero(int id, String nombre) {
		super(id,nombre);
		disponible = true;
	}
	
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	
	// Retorna uno de los meseros menos ocupados
	 public static Mesero obtenerMeseroDesocupado(){
		 List<Mesero> meseros = new ArrayList<Mesero>();
		 meseros.add(lista.get(0));
	 	 for(Mesero reg : lista){
			int mesasM = Mesa.cantidadAtendidasPorMesero(meseros.get(0).getId());
			int mesasX = Mesa.cantidadAtendidasPorMesero(reg.getId());
			if (mesasX < mesasM) {
				meseros.set(0, reg);
			}
	 	 }
	 	 return meseros.get(0);
	 }
	
	@Override
	public String toString() {
		return "Mesero [getId()=" + getId() + ", getNombre()=" + getNombre() + ", estado=" + disponible + "]";
	}

	
}
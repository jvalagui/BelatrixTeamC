
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

	public static int create(Mesero mesero){
		int result = 0;
		try{
			lista.add(mesero);
			result = 1;
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public static List<Mesero> read(){
		return lista;
	}
	
	public static Mesero read(int id){
		Mesero mesero = null;
		for(Mesero reg : lista){
			if(reg.getId() == id){
				mesero = reg;
			}
		}
		return mesero;
	}
	
	public static int update(Mesero mesero){
		int result = 0;
		try{
			for(Mesero reg : lista){
				if(reg.getId() == mesero.getId()){
					lista.set(lista.indexOf(reg), mesero);
				}
			}
			result = 1;
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public static int delete(int id){
		int result = 0;
		try{
			for(Mesero reg : lista){
				if(reg.getId() == id){
					lista.remove(reg);
					result = 1;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	// Retorna uno de los meseros menos ocupados
	 public static Mesero obtenerMesero(){
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

package main.java.com.lab.restaurant.model;

import java.util.ArrayList;
import java.util.List;

public class Mesero extends Persona{
	
	private static List<Mesero> lista;
	private boolean estado;
	
	public Mesero(){}

	static{
		lista = new ArrayList<>();
	}
	
	public Mesero(int id, String nombre, boolean estado) {
		super(id, nombre);
		this.estado = estado;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	

	public static int create(Mesero reg){
		int result = 0;
		try{
			lista.add(reg);
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
		Mesero reg = null;
		for(Mesero x : read()){
			if(x.getId() == id){
				reg = x;
			}
		}
		return reg;
	}
	
	public static int update(Mesero reg){
		int result = 0;
		try{
			for(Mesero x : read()){
				if(x.getId() == reg.getId()){
					lista.set(lista.indexOf(x), reg);
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
			for(Mesero x : read()){
				if(x.getId() == id){
					read().remove(x);
					result = 1;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public String toString() {
		return "Mesero [getId()=" + getId() + ", getNombre()=" + getNombre() + ", estado=" + estado + "]";
	}

	
}
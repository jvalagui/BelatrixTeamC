
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

	

	public int create(Mesero reg){
		int result = 0;
		try{
			lista.add(reg);
			result = 1;
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Mesero> read(){
		return lista;
	}
	
	public Mesero read(int id){
		Mesero reg = null;
		for(Mesero x : read()){
			if(x.getId() == id){
				reg = x;
			}
		}
		return reg;
	}
	
	public int update(Mesero reg){
		int result = 0;
		try{
			for(Mesero x : read()){
				if(x.getId() == reg.getId()){
					x.setNombre(reg.getNombre());
				}
			}
			result = 1;
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public int delete(int id){
		int result = 0;
		try{
			for(Mesero x : read()){
				if(x.getId() == id){
					read().remove(x);
				}
			}
			result = 1;
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

}
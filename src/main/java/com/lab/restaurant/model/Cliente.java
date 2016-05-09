package main.java.com.lab.restaurant.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona{

	
private static List<Cliente> lista;
	
	
	static{
		lista = new ArrayList<>();
	}
	
	public Cliente(){}
	
	public Cliente(int id, String nombre) {
		super(id, nombre);
	}

	public int create(Cliente reg){
		int result = 0;
		try{
			lista.add(reg);
			result = 1;
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Cliente> read(){
		return lista;
	}
	
	public Cliente read(int id){
		Cliente reg = null;
		for(Cliente x : read()){
			if(x.getId() == id){
				reg = x;
			}
		}
		return reg;
	}
	
	public int update(Cliente reg){
		int result = 0;
		try{
			for(Cliente x : read()){
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
			for(Cliente x : read()){
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
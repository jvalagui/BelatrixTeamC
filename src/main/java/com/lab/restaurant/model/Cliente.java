package main.java.com.lab.restaurant.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona{

	private static int identityid;
	private static List<Cliente> lista;
	
	static{
		identityid = 0;
		lista = new ArrayList<>();
	}
	{
		identityid++;
		setId(identityid);
	}
	
	public Cliente(){
		
	}
	
	public Cliente(String nombre) {
		super(nombre);
	}

	public static int create(Cliente reg){
		int result = 0;
		try{
			lista.add(reg);
			result = 1;
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public static List<Cliente> read(){
		return lista;
	}
	
	public static Cliente read(int id){
		Cliente reg = null;
		for(Cliente x : read()){
			if(x.getId() == id){
				reg = x;
			}
		}
		return reg;
	}
	
	public static int update(Cliente reg){
		int result = 0;
		try{
			for(Cliente x : read()){
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
			for(Cliente x : read()){
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
		return "Cliente [getId()=" + getId() + ", getNombre()=" + getNombre() + "]\n";
	}

}
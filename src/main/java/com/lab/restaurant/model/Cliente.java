package main.java.com.lab.restaurant.model;

import java.util.List;

public class Cliente extends Persona{

	private static List<Cliente> lista;
	
	public Cliente(){
		
	}
	
	public Cliente(int id,String nombre) {
		super(id,nombre);
	}

	public static int create(Cliente cliente){
		int result = 0;

		lista.add(cliente);
		result = 1;

		return result;
	}
	
	public static List<Cliente> read(){
		return lista;
	}
	
	public static Cliente read(int id){
		Cliente cliente = null;
		
		for(Cliente reg: lista){
			if(reg.getId() == id){
				cliente = reg;
			}
		}
		
		return cliente;
	}
	
	public static int update(Cliente cliente){
		int result = 0;
	
		for(Cliente reg: lista){
			if(reg.getId() == cliente.getId()){
				lista.set(lista.indexOf(reg), cliente);
				result = 1;
			}
		}
		
		
		return result;
	}
	
	public static int delete(int id){
		int result = 0;
	
		for(Cliente reg: lista){
			if(reg.getId() == id){
				lista.remove(reg);
				result = 1;
			}
		}
		
		return result;
	}

	@Override
	public String toString() {
		return "Cliente [getId()=" + getId() + ", getNombre()=" + getNombre()
				+ "]";
	}
	


}
package main.java.com.lab.restaurant.model;

import java.util.ArrayList;
import java.util.List;

public class Mesa {
		
	private int id;
	private int idMesero;
	private boolean usada;
	
	private static List<Mesa> lista = new ArrayList<Mesa>();

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

	
	public static int create(Mesa mesa){
		int result = 0;
		try{
			lista.add(mesa);
			result = 1;
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public static List<Mesa> read(){
		return lista;
	}
	
	public static Mesa read(int id){
		Mesa mesa = null;
		for(Mesa reg : lista){
			if(reg.getId() == id){
				mesa = reg;
			}
		}
		return mesa;
	}
	
	public static int update(Mesa mesa){
		int result = 0;
		
		for(Mesa reg : lista){
			if(reg.getId() == mesa.getId()){
				lista.set(lista.indexOf(reg), mesa);
				result = 1;
			}
		}
		
		return result;
	}
	
	public static int delete(int id){
		int result = 0;
		
		for(Mesa reg : lista){
			if(reg.getId() == id){
				lista.remove(reg);
				result = 1;
			}
		}
		
		return result;
	}
	
	public static int cantidadAtendidasPorMesero(int idMesero){
		int c = 0;
		for(Mesa reg : lista){
			if(reg.getIdMesero() == idMesero){ c++; }
		}
		return c;
	}
	
	
	@Override
	public String toString() {
		return "Mesa [id=" + id + ", usada=" + usada + "]";
	}
	
	
}

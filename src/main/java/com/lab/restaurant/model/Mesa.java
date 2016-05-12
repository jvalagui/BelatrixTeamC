package main.java.com.lab.restaurant.model;

import java.util.ArrayList;
import java.util.List;

public class Mesa {
	
	private static int identityId;
	
	private int id;
	private int idMesero;
	private boolean usada;
	
	private static List<Mesa> lista;
	
	static{
		identityId = 0;
		lista = new ArrayList<>();
	}

	{
		identityId++;
		id = identityId;
		setUsada(false);
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

	
	public static int create(Mesa reg){
		int result = 0;
		try{
			lista.add(reg);
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
		Mesa reg = null;
		for(Mesa x : read()){
			if(x.getId() == id){
				reg = x;
			}
		}
		return reg;
	}
	
	public static int update(Mesa reg){
		int result = 0;
		
		for(Mesa x : read()){
			if(x.getId() == reg.getId()){
				lista.set(lista.indexOf(x), reg);
				result = 1;
			}
		}
		
		return result;
	}
	
	public static int delete(int id){
		int result = 0;
		
		for(Mesa x : read()){
			if(x.getId() == id){
				read().remove(x);
				result = 1;
			}
		}
		
		return result;
	}
	
	public static int cantidadAtendidasPorMesero(int idMesero){
		int c = 0;
		for(Mesa x : lista){
			if(x.getIdMesero() == idMesero){ c++; }
		}
		return c;
	}
	
	
	@Override
	public String toString() {
		return "Mesa [id=" + id + ", usada=" + usada + "]";
	}
	
	
}

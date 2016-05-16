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
	
	public static int cantidadAtendidasPorMesero(int idMesero){
		int c = 0;
		for(Mesa reg : lista){
			if(reg.getIdMesero() == idMesero){ c++; }
		}
		return c;
	}
	
	public static List<Mesa> getMesasDisponibles(){
		List<Mesa> disponibles = new ArrayList<>();
		for(Mesa m : lista){
			if(!m.isUsada()){
				disponibles.add(m);
			}	
		}
		return disponibles;
	}
	
	public static Mesa obtenerMesaDisponible(){
		return lista.get(((int)Math.random()*getMesasDisponibles().size()));
	}
	
	@Override
	public String toString() {
		return "Mesa [id=" + id + ", usada=" + usada + "]";
	}
	
	
}

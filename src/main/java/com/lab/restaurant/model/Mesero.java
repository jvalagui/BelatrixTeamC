
package main.java.com.lab.restaurant.model;

import java.util.ArrayList;
import java.util.List;

public class Mesero extends Persona{
	
	private static int identityId;
	private static List<Mesero> lista;
	public static final int limiteMesas = 5;
	private boolean disponible;
	
	public Mesero(){}

	static{
		identityId = 0;
		lista = new ArrayList<>();
	}
	{
		identityId++;
		setId(identityId);
		setDisponible(true);
	}
	
	public Mesero(String nombre) {
		super(nombre);
	}
	
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
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
	
	// Retorna uno de los meseros menos ocupados
	 public static Mesero obtenerMesero(){
		 List<Mesero> meseros = new ArrayList<Mesero>();
		 meseros.add(Mesero.read(0));
	 	 for(Mesero x : lista){
		   int mesasM = Mesa.cantidadAtendidasPorMesero(meseros.get(0).getId());
		   int mesasX = Mesa.cantidadAtendidasPorMesero(x.getId());
		   if(mesasX < mesasM){
			   meseros.set(0, x);
		   }
	 	 }
	 	 return meseros.get(0);
	 }
	
	@Override
	public String toString() {
		return "Mesero [getId()=" + getId() + ", getNombre()=" + getNombre() + ", estado=" + disponible + "]";
	}

	
}
package main.java.com.lab.restaurant.model;

import java.util.ArrayList;
import java.util.List;

public class Visita{
	private static int identityId;
	private int id;
	private int idCliente;
	private int estado;
	private int idMesa;

	private static List<Visita> lista;
	
	static{
		identityId = 0;
		lista = new ArrayList<>();
	}
	
	{
		identityId++;
		id = identityId;
	}
	
	public int getId() {
		return id;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	public int getIdMesa() {
		return idMesa;
	}
	public void setIdMesa(int idMesa) {
		this.idMesa = idMesa;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
	public static List<Visita> read() {
		return lista;
	}
	
	public static Visita read(int id) {
		
		Visita visita = null;
		
		for(Visita v : read()){
			if(v.getId() == id){
				visita = v;
			}
		}
		
		return visita;
	}
	
	public static int create(Visita reg) {
		
		lista.add(reg);
		
		return 1;
	}
	
	public static int update(Visita reg) {
		int result = 0;
				
		for(Visita x : lista){
			
			if(x.getId() == reg.getId()){
				lista.set(lista.indexOf(x), reg);
				result = 1;
			}
			
		}
		
		return result;
	}
	
	public static int delete(Visita reg) {
		int result = 0;
		
		for(Visita x : lista){
			if(x.getId() == reg.getId()){
				lista.remove(x);
				result = 1;
			}
		}
		return result;
		
	}
	@Override
	public String toString() {
		return "Visita [id=" + id + ", idCliente=" + idCliente + ", estado=" + estado + ", idMesa=" + idMesa
				+ "]";
	}
	

	
	
	
}

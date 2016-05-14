package main.java.com.lab.restaurant.model;

import java.util.List;

public class Visita{
	private int id;
	private int idCliente;
	private int estado;
	private int idMesa;

	private static List<Visita> lista;
	
	public Visita(){
		
	}
	
	public Visita(int idCliente){
		this.idCliente = idCliente;
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
	
	public static int create(Visita visita) {
		
		lista.add(visita);
		
		return 1;
	}
	
	public static int update(Visita visita) {
		int result = 0;
				
		for(Visita reg : lista){
			
			if(reg.getId() == visita.getId()){
				lista.set(lista.indexOf(reg), visita);
				result = 1;
			}
			
		}
		
		return result;
	}
	
	public static int delete(Visita visita) {
		int result = 0;
		
		for(Visita reg : lista){
			if(reg.getId() == visita.getId()){
				lista.remove(reg);
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

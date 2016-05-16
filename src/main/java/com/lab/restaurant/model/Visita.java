package main.java.com.lab.restaurant.model;

public class Visita{
	private int id;
	private int idCliente;
	private int estado;
	private int idMesa;
	
	public Visita(){
		
	}
	
	public Visita(int id,int idCliente){
		this.id = id;
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
	
	@Override
	public String toString() {
		return "Visita [id=" + id + ", idCliente=" + idCliente + ", estado=" + estado + ", idMesa=" + idMesa
				+ "]";
	}

}

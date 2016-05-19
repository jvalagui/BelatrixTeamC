package main.java.com.lab.restaurant.model;

import main.java.com.lab.restaurant.constantes.VisitaEstados;

public class Visita{
	private int id;
	private int idCliente;
	private int idMesero;
	private int idMesa;
	private int estado;
	
	public Visita(){}

	public Visita(int id, int idCliente, int idMesero, int idMesa, int estado) {
		super();
		this.id = id;
		this.idCliente = idCliente;
		this.idMesero = idMesero;
		this.idMesa = idMesa;
		this.estado = estado;
	}

	public Visita(int id, int idCliente) {
		super();
		this.id = id;
		this.idCliente = idCliente;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdMesero() {
		return idMesero;
	}

	public void setIdMesero(int idMesero) {
		this.idMesero = idMesero;
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
		return "Visita [id=" + id + ", idCliente=" + idCliente + ", idMesero=" + idMesero + ", idMesa=" + idMesa
				+ ", estado=" + getEstadoString() + "]";
	}
	
	public String getEstadoString(){
		switch(estado){
			case VisitaEstados.EN_ATENCION:
				return "EN_ATENCION";
			case VisitaEstados.EN_COMEDOR:
				return "EN_COMEDOR";
			case VisitaEstados.EN_ESPERA:
				return "EN_ESPERA";
			case VisitaEstados.EN_RECEPCION:
				return "EN_RECEPCION";
			case VisitaEstados.CERRADO:
				return "CERRADO";
			default: return "";
		}
	}
}

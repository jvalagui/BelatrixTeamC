package main.java.com.lab.restaurant.model;

public class Mesa {
		
	private int id;
	private boolean usada;
	
	{
		usada = false;
	}

	public Mesa(int id, boolean usada) {
		super();
		this.id = id;
		this.usada = usada;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isUsada() {
		return usada;
	}

	public void setUsada(boolean usada) {
		this.usada = usada;
	}

	@Override
	public String toString() {
		return "Mesa [id=" + id + ", usada=" + usada + "]";
	}
	
	
}

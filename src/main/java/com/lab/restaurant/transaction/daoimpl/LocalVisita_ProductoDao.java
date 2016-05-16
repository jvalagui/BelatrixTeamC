package main.java.com.lab.restaurant.transaction.daoimpl;

import java.util.ArrayList;
import java.util.List;

import main.java.com.lab.restaurant.model.Visita_Producto;
import main.java.com.lab.restaurant.transaction.dao.DaoManager;

public class LocalVisita_ProductoDao implements DaoManager<Visita_Producto> {
	private static List<Visita_Producto> lista = new ArrayList<Visita_Producto>();

	@Override
	public List<Visita_Producto> read() {
		return lista;
	}

	@Override
	public Visita_Producto read(int id) {
		Visita_Producto visitaProducto = null;
		for(Visita_Producto reg : lista){
			if(reg.getId() == id){
				visitaProducto = reg;
			}
		}
		return visitaProducto;
	}

	@Override
	public void create(Visita_Producto visitaProducto) {
		lista.add(visitaProducto);
	}

	@Override
	public void update(Visita_Producto visitaProducto) {
		for(Visita_Producto reg : lista){
			if(reg.getId() == visitaProducto.getId()){
				lista.set(lista.indexOf(reg), visitaProducto);
			}
		}
		
	}

	@Override
	public void delete(int id) {
		for(Visita_Producto reg : lista){
			if(reg.getId() == id){
				lista.remove(reg);
			}
		}
	}

}

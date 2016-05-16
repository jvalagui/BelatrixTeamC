package main.java.com.lab.restaurant.transaction.services;

import java.util.List;

import main.java.com.lab.restaurant.model.Visita_Producto;
import main.java.com.lab.restaurant.transaction.dao.DaoFactory;
import main.java.com.lab.restaurant.transaction.dao.DaoManager;

public class Visita_ProductoService implements DaoManager<Visita_Producto>{
	DaoFactory daoFactory = DaoFactory.getDaoFactory(DaoFactory.LOCAL);
	DaoManager<Visita_Producto> visitaProducto = daoFactory.getVisita_ProductoDao();

	@Override
	public List<Visita_Producto> read() {
		return visitaProducto.read();
	}

	@Override
	public Visita_Producto read(int id) {
		return visitaProducto.read(id);
	}

	@Override
	public void create(Visita_Producto t) {
		visitaProducto.create(t);
		
	}

	@Override
	public void update(Visita_Producto t) {
		visitaProducto.update(t);
		
	}

	@Override
	public void delete(int id) {
		visitaProducto.delete(id);
		
	}

}

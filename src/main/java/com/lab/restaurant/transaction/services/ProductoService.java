package main.java.com.lab.restaurant.transaction.services;

import java.util.List;

import main.java.com.lab.restaurant.constantes.OrigenDatos;
import main.java.com.lab.restaurant.model.Producto;
import main.java.com.lab.restaurant.transaction.dao.DaoFactory;
import main.java.com.lab.restaurant.transaction.dao.DaoManager;

public class ProductoService implements DaoManager<Producto> {
	DaoFactory daoFactory = DaoFactory.getDaoFactory(OrigenDatos.ORIGEN);
	DaoManager<Producto> productoDao = daoFactory.getMealDao();

	@Override
	public List<Producto> read() {
		return productoDao.read();
	}

	@Override
	public Producto read(int id) {
		return productoDao.read(id);
	}

	@Override
	public void create(Producto producto) {
		productoDao.create(producto);
	}

	@Override
	public void update(Producto producto) {
		productoDao.update(producto);
	}

	@Override
	public void delete(int id) {
		productoDao.delete(id);
	}

}

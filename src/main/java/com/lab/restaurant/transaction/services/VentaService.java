package main.java.com.lab.restaurant.transaction.services;

import java.util.List;

import main.java.com.lab.restaurant.constantes.OrigenDatos;
import main.java.com.lab.restaurant.model.Venta;
import main.java.com.lab.restaurant.transaction.dao.DaoFactory;
import main.java.com.lab.restaurant.transaction.dao.DaoManager;

public class VentaService implements DaoManager<Venta>{
	DaoFactory daoFactory = DaoFactory.getDaoFactory(OrigenDatos.ORIGEN);
	DaoManager<Venta> ventaDao = daoFactory.getVentaDao();

	@Override
	public List<Venta> read() {
		return ventaDao.read();
	}

	@Override
	public Venta read(int id) {
		return ventaDao.read(id);
	}

	@Override
	public void create(Venta venta) {
		ventaDao.create(venta);
		
	}

	@Override
	public void update(Venta venta) {
		ventaDao.update(venta);
		
	}

	@Override
	public void delete(int id) {
		ventaDao.delete(id);
		
	}

}

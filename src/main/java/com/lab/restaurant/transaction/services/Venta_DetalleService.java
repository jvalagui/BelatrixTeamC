package main.java.com.lab.restaurant.transaction.services;

import java.util.List;

import main.java.com.lab.restaurant.constantes.OrigenDatos;
import main.java.com.lab.restaurant.model.Venta_Detalle;
import main.java.com.lab.restaurant.transaction.dao.DaoFactory;
import main.java.com.lab.restaurant.transaction.dao.DaoManager;

public class Venta_DetalleService implements DaoManager<Venta_Detalle> {
	DaoFactory daoFactory = DaoFactory.getDaoFactory(OrigenDatos.ORIGEN);
	DaoManager<Venta_Detalle> ventaDetalleDao = daoFactory.getVenta_DetalleDao();

	@Override
	public List<Venta_Detalle> read() {
		return ventaDetalleDao.read();
	}

	@Override
	public Venta_Detalle read(int id) {
		return ventaDetalleDao.read(id);
	}

	@Override
	public void create(Venta_Detalle ventaDetalle) {
		ventaDetalleDao.create(ventaDetalle);
		
	}

	@Override
	public void update(Venta_Detalle ventaDetalle) {
		ventaDetalleDao.update(ventaDetalle);
		
	}

	@Override
	public void delete(int id) {
		ventaDetalleDao.delete(id);
		
	}

}

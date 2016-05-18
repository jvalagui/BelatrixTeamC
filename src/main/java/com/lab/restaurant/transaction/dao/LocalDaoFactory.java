package main.java.com.lab.restaurant.transaction.dao;

import main.java.com.lab.restaurant.model.Cliente;
import main.java.com.lab.restaurant.model.Mesa;
import main.java.com.lab.restaurant.model.Mesero;
import main.java.com.lab.restaurant.model.Producto;
import main.java.com.lab.restaurant.model.Venta;
import main.java.com.lab.restaurant.model.Venta_Detalle;
import main.java.com.lab.restaurant.model.Visita;
import main.java.com.lab.restaurant.transaction.daoimpl.LocalClienteDao;
import main.java.com.lab.restaurant.transaction.daoimpl.LocalMesaDao;
import main.java.com.lab.restaurant.transaction.daoimpl.LocalMeseroDao;
import main.java.com.lab.restaurant.transaction.daoimpl.LocalProductoDao;
import main.java.com.lab.restaurant.transaction.daoimpl.LocalVentaDao;
import main.java.com.lab.restaurant.transaction.daoimpl.LocalVenta_DetalleDao;
import main.java.com.lab.restaurant.transaction.daoimpl.LocalVisitaDao;

public class LocalDaoFactory extends DaoFactory {

	@Override
	public DaoManager<Cliente> getClienteDao() {
		return new LocalClienteDao();
	}
	
	public DaoManager<Producto> getMealDao(){
		return new LocalProductoDao();
	}
	
	public DaoManager<Visita> getVisitaDao(){
		return new LocalVisitaDao();
	}
	
	public DaoManager<Mesa> getMesaDao(){
		return new LocalMesaDao();
	}

	public DaoManager<Mesero> getMeseroDao() {
		return new LocalMeseroDao();
	}

	@Override
	public DaoManager<Venta> getVentaDao() {
		return new LocalVentaDao();
	}

	@Override
	public DaoManager<Venta_Detalle> getVenta_DetalleDao() {
		return new LocalVenta_DetalleDao();
	}
	
}

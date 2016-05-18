package main.java.com.lab.restaurant.transaction.dao;

import main.java.com.lab.restaurant.model.Cliente;
import main.java.com.lab.restaurant.model.Mesa;
import main.java.com.lab.restaurant.model.Mesero;
import main.java.com.lab.restaurant.model.Producto;
import main.java.com.lab.restaurant.model.Venta;
import main.java.com.lab.restaurant.model.Venta_Detalle;
import main.java.com.lab.restaurant.model.Visita;
import main.java.com.lab.restaurant.transaction.daoimpl.MySQLClienteDao;
import main.java.com.lab.restaurant.transaction.daoimpl.MySQLMesaDao;
import main.java.com.lab.restaurant.transaction.daoimpl.MySQLMeseroDao;
import main.java.com.lab.restaurant.transaction.daoimpl.MySQLProductoDao;
import main.java.com.lab.restaurant.transaction.daoimpl.MySQLVentaDao;
import main.java.com.lab.restaurant.transaction.daoimpl.MySQLVenta_DetalleDao;
import main.java.com.lab.restaurant.transaction.daoimpl.MySQLVisitaDao;

public class MySqlDaoFactory extends DaoFactory{

	@Override
	public DaoManager<Cliente> getClienteDao() {
		return new MySQLClienteDao();
	}

	@Override
	public DaoManager<Producto> getMealDao() {
		return new MySQLProductoDao();
	}

	@Override
	public DaoManager<Visita> getVisitaDao() {
		return new MySQLVisitaDao();
	}

	@Override
	public DaoManager<Mesa> getMesaDao() {
		return new MySQLMesaDao();
	}

	@Override
	public DaoManager<Mesero> getMeseroDao() {
		return new MySQLMeseroDao();
	}

	@Override
	public DaoManager<Venta> getVentaDao() {
		return new MySQLVentaDao();
	}

	@Override
	public DaoManager<Venta_Detalle> getVenta_DetalleDao() {
		return new MySQLVenta_DetalleDao();
	}

}

package main.java.com.lab.restaurant.transaction.dao;

import main.java.com.lab.restaurant.model.Cliente;
import main.java.com.lab.restaurant.model.ComprobantePago;
import main.java.com.lab.restaurant.model.Mesa;
import main.java.com.lab.restaurant.model.Mesero;
import main.java.com.lab.restaurant.model.Producto;
import main.java.com.lab.restaurant.model.Visita;
import main.java.com.lab.restaurant.model.Visita_Producto;
import main.java.com.lab.restaurant.transaction.daoimpl.LocalCategoriaProductoDao;
import main.java.com.lab.restaurant.transaction.daoimpl.LocalClienteDao;
import main.java.com.lab.restaurant.transaction.daoimpl.LocalComprobantePagoDao;
import main.java.com.lab.restaurant.transaction.daoimpl.LocalMesaDao;
import main.java.com.lab.restaurant.transaction.daoimpl.LocalMeseroDao;
import main.java.com.lab.restaurant.transaction.daoimpl.LocalProductoDao;
import main.java.com.lab.restaurant.transaction.daoimpl.LocalTipoProductoDao;
import main.java.com.lab.restaurant.transaction.daoimpl.LocalVisitaDao;
import main.java.com.lab.restaurant.transaction.daoimpl.LocalVisita_ProductoDao;

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
	public DaoManager<ComprobantePago> getComprobantePagoDao() {
		return new LocalComprobantePagoDao();
	}

	@Override
	public DaoManager<Visita_Producto> getVisita_ProductoDao() {
		return new LocalVisita_ProductoDao();
	}

	@Override
	public LocalCategoriaProductoDao getCategoriaProductoDao() {
		return new LocalCategoriaProductoDao();
	}

	@Override
	public LocalTipoProductoDao getTipoProductoDao() {
		return new LocalTipoProductoDao();
	}
	
	
	
}

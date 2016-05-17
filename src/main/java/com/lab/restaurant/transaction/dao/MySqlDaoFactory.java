package main.java.com.lab.restaurant.transaction.dao;

import main.java.com.lab.restaurant.model.Cliente;
import main.java.com.lab.restaurant.model.ComprobantePago;
import main.java.com.lab.restaurant.model.Producto;
import main.java.com.lab.restaurant.model.Mesa;
import main.java.com.lab.restaurant.model.Mesero;
import main.java.com.lab.restaurant.model.Visita;
import main.java.com.lab.restaurant.model.Visita_Producto;
import main.java.com.lab.restaurant.transaction.daoimpl.LocalCategoriaProductoDao;
import main.java.com.lab.restaurant.transaction.daoimpl.LocalTipoProductoDao;

public class MySqlDaoFactory extends DaoFactory{

	@Override
	public DaoManager<Cliente> getClienteDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DaoManager<Producto> getMealDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DaoManager<Visita> getVisitaDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DaoManager<Mesa> getMesaDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DaoManager<Mesero> getMeseroDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DaoManager<ComprobantePago> getComprobantePagoDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DaoManager<Visita_Producto> getVisita_ProductoDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocalCategoriaProductoDao getCategoriaProductoDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocalTipoProductoDao getTipoProductoDao() {
		// TODO Auto-generated method stub
		return null;
	}

}

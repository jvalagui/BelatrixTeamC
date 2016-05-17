package main.java.com.lab.restaurant.transaction.dao;

import main.java.com.lab.restaurant.model.Cliente;
import main.java.com.lab.restaurant.model.Mesa;
import main.java.com.lab.restaurant.model.Mesero;
import main.java.com.lab.restaurant.model.Producto;
import main.java.com.lab.restaurant.model.Venta;
import main.java.com.lab.restaurant.model.Venta_Detalle;
import main.java.com.lab.restaurant.model.Visita;

public abstract class DaoFactory {
		public static final int MYSQL = 0;
		public static final int LOCAL = 1;
		
		public static DaoFactory getDaoFactory(int daoFactory){
			switch(daoFactory){
			case MYSQL:
				return new MySqlDaoFactory();
			case LOCAL:
				return new LocalDaoFactory();
			default:
				return null;
			}
		}
		
		public abstract DaoManager<Cliente> getClienteDao();
		public abstract DaoManager<Producto> getMealDao();
		public abstract DaoManager<Visita> getVisitaDao();
		public abstract DaoManager<Mesa> getMesaDao();
		public abstract DaoManager<Mesero> getMeseroDao();
		public abstract DaoManager<Venta> getVentaDao();
		public abstract DaoManager<Venta_Detalle> getVenta_DetalleDao();
}

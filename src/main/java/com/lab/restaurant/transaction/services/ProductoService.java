package main.java.com.lab.restaurant.transaction.services;

import java.util.List;

import main.java.com.lab.restaurant.model.Producto;
import main.java.com.lab.restaurant.transaction.dao.DaoFactory;
import main.java.com.lab.restaurant.transaction.dao.DaoManager;

public class ProductoService implements DaoManager<Producto> {
	DaoFactory daoFactory = DaoFactory.getDaoFactory(DaoFactory.LOCAL);
	DaoManager<Producto> mealDao = daoFactory.getMealDao();

	@Override
	public List<Producto> read() {
		return mealDao.read();
	}

	@Override
	public Producto read(int id) {
		return mealDao.read(id);
	}

	@Override
	public void create(Producto t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Producto t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}

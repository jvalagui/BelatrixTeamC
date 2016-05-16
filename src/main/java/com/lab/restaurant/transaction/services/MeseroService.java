package main.java.com.lab.restaurant.transaction.services;

import java.util.List;

import main.java.com.lab.restaurant.model.Mesero;
import main.java.com.lab.restaurant.transaction.dao.DaoFactory;
import main.java.com.lab.restaurant.transaction.dao.DaoManager;

public class MeseroService implements DaoManager<Mesero>{
	DaoFactory daoFactory = DaoFactory.getDaoFactory(DaoFactory.LOCAL);

	DaoManager<Mesero> meseroDao = daoFactory.getMeseroDao();

	@Override
	public List<Mesero> read() {
		return meseroDao.read();
	}

	@Override
	public Mesero read(int id) {
		// TODO Auto-generated method stub
		return meseroDao.read(id);
	}

	@Override
	public void create(Mesero t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Mesero t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}

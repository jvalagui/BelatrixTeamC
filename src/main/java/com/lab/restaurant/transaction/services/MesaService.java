package main.java.com.lab.restaurant.transaction.services;

import java.util.List;

import main.java.com.lab.restaurant.model.Mesa;
import main.java.com.lab.restaurant.transaction.dao.DaoFactory;
import main.java.com.lab.restaurant.transaction.dao.DaoManager;

public class MesaService implements DaoManager<Mesa>{
	DaoFactory daoFactory = DaoFactory.getDaoFactory(DaoFactory.LOCAL);
	
	DaoManager<Mesa> mesaDao = daoFactory.getMesaDao();

	@Override
	public List<Mesa> read() {
		return mesaDao.read();
	}

	@Override
	public Mesa read(int id) {
		return mesaDao.read(id);
	}

	@Override
	public void create(Mesa t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Mesa t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}

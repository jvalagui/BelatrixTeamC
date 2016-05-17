package main.java.com.lab.restaurant.transaction.services;

import java.util.List;

import main.java.com.lab.restaurant.model.Visita;
import main.java.com.lab.restaurant.transaction.dao.DaoFactory;
import main.java.com.lab.restaurant.transaction.dao.DaoManager;

public class VisitaService implements DaoManager<Visita> {
	DaoFactory daoFactory = DaoFactory.getDaoFactory(DaoFactory.LOCAL);
	DaoManager<Visita> visitaDao = daoFactory.getVisitaDao(); 

	@Override
	public List<Visita> read() {
		return visitaDao.read();
	}

	@Override
	public Visita read(int id) {
		return visitaDao.read(id);
	}

	@Override
	public void create(Visita t) {
		visitaDao.create(t);
	}

	@Override
	public void update(Visita t) {
		visitaDao.update(t);
	}

	@Override
	public void delete(int id) {
		visitaDao.delete(id);
	}

}

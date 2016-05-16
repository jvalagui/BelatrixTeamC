package main.java.com.lab.restaurant.transaction.services;

import java.util.List;

import main.java.com.lab.restaurant.model.ComprobantePago;
import main.java.com.lab.restaurant.transaction.dao.DaoFactory;
import main.java.com.lab.restaurant.transaction.dao.DaoManager;

public class ComprobantePagoService implements DaoManager<ComprobantePago> {
	DaoFactory daoFactory = DaoFactory.getDaoFactory(DaoFactory.LOCAL);
	DaoManager<ComprobantePago> comprobantePagoDao = daoFactory.getComprobantePagoDao();

	@Override
	public List<ComprobantePago> read() {
		return comprobantePagoDao.read();
	}

	@Override
	public ComprobantePago read(int id) {
		return comprobantePagoDao.read(id);
	}

	@Override
	public void create(ComprobantePago t) {
		comprobantePagoDao.create(t);
		
	}

	@Override
	public void update(ComprobantePago t) {
		comprobantePagoDao.update(t);
		
	}

	@Override
	public void delete(int id) {
		comprobantePagoDao.delete(id);
	}

}

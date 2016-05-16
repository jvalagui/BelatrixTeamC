package main.java.com.lab.restaurant.transaction.services;

import java.util.List;

import main.java.com.lab.restaurant.model.Cliente;
import main.java.com.lab.restaurant.transaction.dao.DaoFactory;
import main.java.com.lab.restaurant.transaction.dao.DaoManager;

public class ClienteService implements DaoManager<Cliente> {
	DaoFactory daoFactory = DaoFactory.getDaoFactory(DaoFactory.LOCAL);

	DaoManager<Cliente> clienteDao = daoFactory.getClienteDao();

	@Override
	public List<Cliente> read() {
		return clienteDao.read();
	}

	@Override
	public Cliente read(int id) {
		return clienteDao.read(id);
	}

	@Override
	public void create(Cliente t) {
		clienteDao.create(t);
		
	}

	@Override
	public void update(Cliente t) {
		clienteDao.update(t);
		
	}

	@Override
	public void delete(int id) {
		clienteDao.delete(id);
		
	}
	
	
}

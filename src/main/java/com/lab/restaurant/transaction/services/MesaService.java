package main.java.com.lab.restaurant.transaction.services;

import java.util.ArrayList;
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
	public void create(Mesa mesa) {
		mesaDao.create(mesa);
	}

	@Override
	public void update(Mesa mesa) {
		mesaDao.update(mesa);
	}

	@Override
	public void delete(int id) {
		mesaDao.delete(id);
	}

	public List<Mesa> getMesasDisponibles(){
		List<Mesa> disponibles = new ArrayList<>();
		for(Mesa m : read()){
			if(!m.isUsada()){
				disponibles.add(m);
			}	
		}
		return disponibles;
	}
	
	public Mesa obtenerMesaDisponible(){
		return getMesasDisponibles().isEmpty() ? null : getMesasDisponibles().get(((int)Math.random()*getMesasDisponibles().size()));
	}
}

package main.java.com.lab.restaurant.transaction.services;

import java.util.ArrayList;
import java.util.List;

import main.java.com.lab.restaurant.model.Mesero;
import main.java.com.lab.restaurant.transaction.dao.DaoFactory;
import main.java.com.lab.restaurant.transaction.dao.DaoManager;

public class MeseroService implements DaoManager<Mesero> {

	MesaService mesaService = new MesaService();

	DaoFactory daoFactory = DaoFactory.getDaoFactory(DaoFactory.LOCAL);

	DaoManager<Mesero> meseroDao = daoFactory.getMeseroDao();

	@Override
	public List<Mesero> read() {
		return meseroDao.read();
	}

	@Override
	public Mesero read(int id) {
		return meseroDao.read(id);
	}

	@Override
	public void create(Mesero mesero) {
		meseroDao.create(mesero);
	}

	@Override
	public void update(Mesero mesero) {
		meseroDao.update(mesero);
	}

	@Override
	public void delete(int id) {
		meseroDao.delete(id);
	}

	// Retorna uno de los meseros menos ocupados
	public Mesero obtenerMeseroDesocupado() {
		List<Mesero> meseros = new ArrayList<Mesero>();
		meseros.add(read().get(0));
		for (Mesero reg : read()) {
			int mesasM = mesaService.cantidadAtendidasPorMesero(meseros.get(0).getId());
			int mesasX = mesaService.cantidadAtendidasPorMesero(reg.getId());
			if (mesasX < mesasM) {
				meseros.set(0, reg);
			}
		}
		return meseros.get(0);
	}
}

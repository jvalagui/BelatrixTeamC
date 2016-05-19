package main.java.com.lab.restaurant.transaction.services;

import java.util.List;

import com.sun.org.apache.bcel.internal.classfile.ConstantNameAndType;

import main.java.com.lab.restaurant.constantes.VisitaEstados;
import main.java.com.lab.restaurant.model.Mesa;
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
	public void create(Visita visita) {

		int idVisita = generarId(visita.getId());
		visita.setId(idVisita);
		visitaDao.create(visita);
	}

	@Override
	public void update(Visita visita) {
		visitaDao.update(visita);
	}

	@Override
	public void delete(int id) {
		visitaDao.delete(id);
	}
	
	public int generarId(int id){
		if(id==0){
			int nuevoId;
			
			//Obtener el maximo id y sumarle 1
			if(read().isEmpty()){
				nuevoId = 1;
			}else{
				int maximoId = read().stream().max((visita1, visita2)-> visita1.getId()-visita2.getId()).get().getId();
				nuevoId = maximoId+1;
			}
			
			return nuevoId;
		}else{ 
			return id; 
		}
	}
	

	public int cantidadAtendidasPorMesero(int idMesero){
		int c = 0;
		for(Visita reg : read()){
			if(reg.getEstado() == VisitaEstados.EN_COMEDOR && reg.getIdMesero() == idMesero){ c++; }
		}
		return c;
	}

}

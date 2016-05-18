package main.java.com.lab.restaurant.transaction.daoimpl;

import java.util.ArrayList;
import java.util.List;

import main.java.com.lab.restaurant.model.Venta;
import main.java.com.lab.restaurant.transaction.dao.DaoManager;

public class LocalVentaDao implements DaoManager<Venta> {
	private List<Venta> lista = new ArrayList<Venta>();

	@Override
	public List<Venta> read() {
		return lista;
	}

	@Override
	public Venta read(int id) {
		Venta venta = null;
		for(Venta reg : lista){
			if(reg.getIdVenta() == id){
				venta = reg;
			}
		}
		return venta;
	}

	@Override
	public void create(Venta venta) {
		lista.add(venta);
		
	}

	@Override
	public void update(Venta venta) {
		for(Venta reg : lista){
			if(reg.getIdVenta() == venta.getIdVenta()){
				lista.set(lista.indexOf(reg), venta);
			}
		}
		
	}

	@Override
	public void delete(int id) {
		for(Venta reg : lista){
			if(reg.getIdVenta() == id){
				lista.remove(reg);
			}
		}
		
	}

}

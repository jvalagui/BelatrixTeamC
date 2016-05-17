package main.java.com.lab.restaurant.transaction.daoimpl;

import java.util.ArrayList;
import java.util.List;

import main.java.com.lab.restaurant.model.Venta_Detalle;
import main.java.com.lab.restaurant.transaction.dao.DaoManager;

public class LocalVenta_DetalleDao implements DaoManager<Venta_Detalle> {
	List<Venta_Detalle> lista = new ArrayList<Venta_Detalle>();

	@Override
	public List<Venta_Detalle> read() {
		return lista;
	}

	@Override
	public Venta_Detalle read(int id) {
		Venta_Detalle ventaDetalle = null;
		for(Venta_Detalle reg : lista){
			if(reg.getIdVenta() == id){
				ventaDetalle = reg;
			}
		}
		return ventaDetalle;
	}

	@Override
	public void create(Venta_Detalle ventaDetalle) {
		lista.add(ventaDetalle);
		
	}

	@Override
	public void update(Venta_Detalle ventaDetalle) {
		for(Venta_Detalle reg : lista){
			if(reg.getIdVenta() == ventaDetalle.getIdVenta()){
				lista.set(lista.indexOf(reg), ventaDetalle);
			}
		}
		
	}

	@Override
	public void delete(int id) {
		for(Venta_Detalle reg : lista){
			if(reg.getIdVenta() == id){
				lista.remove(reg);
			}
		}
		
	}

}

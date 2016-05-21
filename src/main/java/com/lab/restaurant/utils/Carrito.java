package main.java.com.lab.restaurant.utils;

import java.io.Serializable;
import java.util.HashMap;

import main.java.com.lab.restaurant.transaction.services.ProductoService;

public class Carrito extends HashMap<Integer, Integer> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ProductoService productoService = new ProductoService();

	@Override
	public Integer get(Object idProducto) {
		return super.get(idProducto);
	}

	@Override
	public Integer put(Integer idProducto, Integer cantidad) {
		return super.put(idProducto, cantidad);
	}
	

	@Override
	public Integer replace(Integer idProducto, Integer cantidad) {
		// TODO Auto-generated method stub
		return super.replace(idProducto, cantidad);
	}

	@Override
	public Integer remove(Object idProducto) {
		return super.remove(idProducto);
	}

	public double getTotal(){
		
		double montoTotal = keySet().stream()
							.mapToDouble(idProducto -> productoService.read(idProducto).getPrecio()*get(idProducto))
							.sum();
		
		return montoTotal;
	}
}

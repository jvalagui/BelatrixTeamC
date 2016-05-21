package main.java.com.lab.restaurant.utils;

import java.io.Serializable;
import java.util.HashMap;

import main.java.com.lab.restaurant.transaction.services.ProductoService;

public class Pedidos extends HashMap<Integer, Carrito> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ProductoService productoService = new ProductoService();

	@Override
	public Carrito get(Object idVisita) {
		return super.get(idVisita);
	}

	@Override
	public Carrito put(Integer idVisita, Carrito orden) {
		return super.put(idVisita, orden);
	}

	@Override
	public Carrito remove(Object idVisita) {
		return super.remove(idVisita);
	}

}
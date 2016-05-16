/*package main.test;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.java.com.lab.restaurant.model.Cliente;
import main.java.com.lab.restaurant.model.Mesa;
import main.java.com.lab.restaurant.model.Mesero;
import main.java.com.lab.restaurant.model.Visita;

public class TestRecepcion {

	static{
		Inicializador.inicializar();
	}
	
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void comprobarLlenadoMeseros() {
		assertTrue(Mesero.read().size() == 5);
	}
	
	@Test
	public void comprobarLlenadoMesas() {
		assertTrue(Mesa.read().size() == 10);
	}
	
	@Test
	public void comprobarClienteCreadoCorrectamente() {
		Cliente.create(new Cliente("Camaron"));
		Assert.assertEquals("Camaron" , Cliente.read(1).getNombre());
	}
	
	@Test
	public void comprobarVisitaCreadaCorrectamente() {
		Cliente.create(new Cliente("Camaron"));
		Visita.create(new Visita(1));
		Assert.assertEquals(1 , Visita.read(1).getIdCliente());
	}
	
	@Test
	public void comprobarVisitaActualizadaCorrectamete() {
		Cliente.create(new Cliente("Camaron"));
		Visita.create(new Visita(1));
		Assert.assertEquals(1 , Visita.read(1).getIdCliente());
		Visita visita = Visita.read(1);
		visita.setIdCliente(2);
		Visita.update(visita);
		Assert.assertEquals(2 , Visita.read(1).getIdCliente());
	}
}*/
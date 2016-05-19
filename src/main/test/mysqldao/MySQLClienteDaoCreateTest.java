package main.test.mysqldao;

import static org.junit.Assert.assertNotNull;

import java.sql.CallableStatement;
import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import main.java.com.lab.restaurant.model.Cliente;
import main.java.com.lab.restaurant.utils.MySqlDBConexion;

public class MySQLClienteDaoCreateTest {
	Connection cn;
	String sql;
	Cliente cliente;

	@Before
	public void setUp() throws Exception {
		cn = MySqlDBConexion.getConexion();
		sql = "{call USP_CLIENTE_CREATE(?,?,?,?,?)}";
		fillTestCliente();
	}
	
	private void fillTestCliente(){
		cliente = new Cliente(1, "60465974", "Daniel", "Vasquez", "Fernandez");
	}

	@Test
	public void testConnectionNotNull() {
		assertNotNull(cn);
	}
	
	
	@Test
	public void testClienteNotNull() throws Exception {
		
		assertNotNull(cliente);
	}
	
	@Test
	public void testSQLNotNull() throws Exception {
		
		assertNotNull(sql);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testClienteCreation() throws Exception {
		
		try{
			CallableStatement statement = cn.prepareCall(sql);
			statement.setInt(1, cliente.getId());
			statement.setString(2, cliente.getDni());
			statement.setString(3, cliente.getNombre());
			statement.setString(4, cliente.getApellidoPaterno());
			statement.setString(5, cliente.getApellidoMaterno());
			Assert.assertEquals(1, statement.executeUpdate());
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		
	}

}

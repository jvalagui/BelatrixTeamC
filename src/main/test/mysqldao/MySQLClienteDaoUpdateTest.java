package main.test.mysqldao;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import main.java.com.lab.restaurant.model.Cliente;
import main.java.com.lab.restaurant.utils.MySqlDBConexion;

public class MySQLClienteDaoUpdateTest {
	Connection cn;
	String sql;
	Cliente cliente;

	@Before
	public void setUp() throws Exception {
		cn = MySqlDBConexion.getConexion();
		sql = "{call USP_CLIENTE_UPDATE(?,?,?,?,?)}";
		fillTestCliente();
	}
	
	private void fillTestCliente(){
		cliente = new Cliente(1, "60465974", "Mark", "Chang", "Ramierez");
	}
	
	@Test
	public void testConnectionNotNull() {
		assertNotNull(cn);
	}
	
	@Test
	public void testSQLNotNull() throws Exception {
		assertNotNull(sql);
	}
	
	@Test
	public void testClienteNotNull() throws Exception {
		assertNotNull(cliente);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testClienteUpdate() {
		try{
			PreparedStatement statement = cn.prepareStatement(sql);
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

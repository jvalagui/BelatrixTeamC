package main.test.mysqldao;

import static org.junit.Assert.assertNotNull;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import main.java.com.lab.restaurant.model.Mesa;
import main.java.com.lab.restaurant.utils.MySqlDBConexion;

public class MySQLMesaDaoUpdateTest {
	Connection cn;
	String sql;
	Mesa mesa;

	@Before
	public void setUp() throws Exception {
		cn = MySqlDBConexion.getConexion();
		sql = "{call USP_MESA_UPDATE(?,?)}";
		fillTestMesa();
	}
	
	private void fillTestMesa(){
		mesa = new Mesa(1, true);
	}
	
	@Test
	public void testConnectionNotNull() {
		assertNotNull(cn);
	}
	
	
	@Test
	public void testClienteNotNull() throws Exception {
		
		assertNotNull(mesa);
	}
	
	@Test
	public void testSQLNotNull() throws Exception {
		
		assertNotNull(sql);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		try{
			CallableStatement statement = cn.prepareCall(sql);
			statement.setInt(1, mesa.getId());
			statement.setBoolean(2, mesa.isUsada());
			Assert.assertEquals(1, statement.executeUpdate());
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}

}

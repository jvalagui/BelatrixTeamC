package main.test.mysqldao;

import static org.junit.Assert.*;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import main.java.com.lab.restaurant.model.Producto;
import main.java.com.lab.restaurant.utils.MySqlDBConexion;

public class MySQLProductoDaoDeleteTest {
	Connection cn;
	String sql;
	int id;
	
	@Before
	public void setUp() throws Exception {
		cn = MySqlDBConexion.getConexion();
		sql = "{call USP_PRODUCTO_DELETE(?)}";
		id = 1;
	}
	
	@Test
	public void testConnectionNotNull() {
		assertNotNull(cn);
	}
	
	@Test
	public void testSQLNotNull() throws Exception {
		
		assertNotNull(sql);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testProductoDelete(){
		try{
			CallableStatement statement = cn.prepareCall(sql);
			statement.setInt(1, id);
			Assert.assertEquals(1, statement.executeUpdate());
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}

package main.test.mysqldao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import main.java.com.lab.restaurant.model.Mesero;
import main.java.com.lab.restaurant.utils.MySqlDBConexion;

public class MySQLMeseroUpdateTest {
	Connection cn;
	String sql;
	Mesero mesero;

	@Before
	public void setUp() throws Exception {
		cn = MySqlDBConexion.getConexion();
		sql = "{call USP_MESERO_UPDATE(?,?,?,?,?)}";
		fillTestMesero();
	}
	
	private void fillTestMesero(){
		mesero = new Mesero(1, "60465974", "Mark", "Something", "King");
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
	public void testMeseroNotNull() throws Exception {
		assertNotNull(mesero);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testMeseroUpdate() {
		try{
			CallableStatement statement = cn.prepareCall(sql);
			statement.setInt(1, mesero.getId());
			statement.setString(2, mesero.getDni());
			statement.setString(3, mesero.getNombre());
			statement.setString(4, mesero.getApellidoPaterno());
			statement.setString(5, mesero.getApellidoMaterno());
			Assert.assertEquals(1, statement.executeUpdate());
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}

}

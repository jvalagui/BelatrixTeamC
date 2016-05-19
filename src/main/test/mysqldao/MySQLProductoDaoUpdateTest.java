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

public class MySQLProductoDaoUpdateTest {
	Connection cn;
	String sql;
	Producto producto;
	
	@Before
	public void setUp() throws Exception {
		cn = MySqlDBConexion.getConexion();
		sql = "{call USP_PRODUCTO_UPDATE(?,?,?,?,?,?,?)}";
		fillTestProducto();
	}
	
	private void fillTestProducto(){
		producto = new Producto(1, "Comida", 1, 2, 10, 30, 5);
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
	public void testProductoNotNull(){
		assertNotNull(producto);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testProductoUpdate(){
		try{
			CallableStatement statement = cn.prepareCall(sql);
			statement.setString(2, producto.getNombre());
			statement.setInt(3, producto.getTipo());
			statement.setInt(4, producto.getCategoria());
			statement.setDouble(5, producto.getCosto());
			statement.setDouble(6, producto.getPrecio());
			statement.setInt(7, producto.getStock());
			statement.setInt(1, producto.getId());
			Assert.assertEquals(1, statement.executeUpdate());
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}

package main.test.mysqldao;

import static org.junit.Assert.*;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.java.com.lab.restaurant.model.Producto;
import main.java.com.lab.restaurant.utils.MySqlDBConexion;

public class MySQLProductoDaoReadTest {
	Connection cn;
	String sql;
	String sql2;
	Producto producto;
	List<Producto> lista;
	ResultSet rs;
	int id;

	@Before
	public void setUp() throws Exception {
		cn = MySqlDBConexion.getConexion();
		sql = "{call USP_PRODUCTO_READ}";
		sql2 = "{call USP_PRODUCTO_OBTAIN(?)}";
		id = 1;
	}
	
	@Test
	public void testConnectionNotNull() {
		assertNotNull(cn);
	}
	
	@Test
	public void testSQLNotNull() throws Exception {
		assertNotNull(sql);
		assertNotNull(sql2);
	}

	@Test
	public void testProductoReadAll(){
		try{
			CallableStatement statement = cn.prepareCall(sql);
			rs = statement.executeQuery();
			lista = new ArrayList<Producto>();
			while(rs.next()){
				Producto producto = new Producto(rs.getInt(1), rs.getString(2), rs.getInt(3),
						rs.getInt(4), rs.getDouble(5), rs.getDouble(6), rs.getInt(7));
				lista.add(producto);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		assertNotNull(lista);
	}
	
	@Test
	public void testProductoRead(){
		try{
			CallableStatement statement = cn.prepareCall(sql2);
			statement.setInt(1, id);
			rs = statement.executeQuery();
			if(rs.next()){
				producto = new Producto(rs.getInt(1), rs.getString(2), rs.getInt(3),
						rs.getInt(4), rs.getDouble(5), rs.getDouble(6), rs.getInt(7));
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		assertNotNull(producto);
	}

}

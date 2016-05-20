package main.test.mysqldao;

import static org.junit.Assert.assertNotNull;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import junit.framework.Assert;
import main.java.com.lab.restaurant.model.Producto;
import main.java.com.lab.restaurant.utils.MySqlDBConexion;

@SuppressWarnings("deprecation")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MySQLProductoDaoTest {
	static int id;
	Connection cn;
	ResultSet rs;
	Producto producto;
	Producto productoUpdate;
	List<Producto> lista;
	String sqlCreate = "{call USP_PRODUCTO_CREATE(?,?,?,?,?,?,?)}";
	String sqlRead = "{call USP_PRODUCTO_READ}";
	String sqlReadId = "{call USP_PRODUCTO_OBTAIN(?)}";
	String sqlUpdate = "{call USP_PRODUCTO_UPDATE(?,?,?,?,?,?,?)}";
	String sqlDelete = "{call USP_PRODUCTO_DELETE(?)}";
	
	@Before
	public void setUp() throws Exception {
		cn = MySqlDBConexion.getConexion();
		fillTestProducto();
	}
	
	private void fillTestProducto(){
		producto = new Producto(1, "Comida", 1, 1, 20, 30, 5);
		productoUpdate = new Producto(1, "Comida", 1, 2, 10, 30, 5);
		
	}
	
	@Test
	public void test1_ConnectionNotNull() {
		assertNotNull(cn);
	}
	
	
	@Test
	public void test2_SQLNotNull() throws Exception {
		
		assertNotNull(sqlCreate);
		assertNotNull(sqlRead);
		assertNotNull(sqlReadId);
		assertNotNull(sqlUpdate);
		assertNotNull(sqlDelete);
	}

	@Test
	public void test3_ProductoCreation() {
		try{
			CallableStatement statement = cn.prepareCall(sqlCreate);
			statement.registerOutParameter(1, java.sql.Types.INTEGER);
			statement.setString(2, producto.getNombre());
			statement.setInt(3, producto.getTipo());
			statement.setInt(4, producto.getCategoria());
			statement.setDouble(5, producto.getCosto());
			statement.setDouble(6, producto.getPrecio());
			statement.setInt(7, producto.getStock());
			statement.executeUpdate();
			
			id = statement.getInt(1);
			producto.setId(id);
			Assert.assertNotSame(0, id);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	@Test
	public void test4_ProductoRead(){
		try{
			producto = null;
			CallableStatement statement = cn.prepareCall(sqlReadId);
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
	
	@Test
	public void test5_ProductoReadAll(){
		try{
			CallableStatement statement = cn.prepareCall(sqlRead);
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
	public void test6_ProductoUpdate(){
		try{
			CallableStatement statement = cn.prepareCall(sqlUpdate);
			statement.setString(2, productoUpdate.getNombre());
			statement.setInt(3, productoUpdate.getTipo());
			statement.setInt(4, productoUpdate.getCategoria());
			statement.setDouble(5, productoUpdate.getCosto());
			statement.setDouble(6, productoUpdate.getPrecio());
			statement.setInt(7, productoUpdate.getStock());
			statement.setInt(1, productoUpdate.getId());
			Assert.assertEquals(1, statement.executeUpdate());
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	@Test
	public void test7_ProductoDelete(){
		try{
			CallableStatement statement = cn.prepareCall(sqlDelete);
			statement.setInt(1, id);
			Assert.assertEquals(1, statement.executeUpdate());
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}

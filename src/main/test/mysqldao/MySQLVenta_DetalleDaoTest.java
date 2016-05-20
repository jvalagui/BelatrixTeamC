package main.test.mysqldao;

import static org.junit.Assert.assertNotNull;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import junit.framework.Assert;
import main.java.com.lab.restaurant.model.Venta_Detalle;
import main.java.com.lab.restaurant.utils.MySqlDBConexion;

@SuppressWarnings("deprecation")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MySQLVenta_DetalleDaoTest {
	static int id;
	Connection cn;
	ResultSet rs;
	Venta_Detalle ventaDetalle;
	Venta_Detalle ventaDetalleUpdate;
	List<Venta_Detalle> lista;
	String sqlCreate = "{call USP_VENTA_DETALLE_CREATE(?,?,?)}";
	String sqlRead = "{call USP_VENTA_DETALLE_READ}";
	String sqlReadId = "{call USP_VENTA_DETALLE_OBTAIN(?)}";
	String sqlUpdate = "{call USP_VENTA_DETALLE_UPDATE(?,?,?)}";
	String sqlDelete = "{call USP_VENTA_DETALLE_DELETE(?)}";
	
	@Before
	public void setUp() throws Exception {
		cn = MySqlDBConexion.getConexion();
		fillTestVenta_Detalle();
	}
	
	private void fillTestVenta_Detalle(){
		ventaDetalle = new Venta_Detalle(1, 1, 2);
		ventaDetalleUpdate = new Venta_Detalle(1, 1, 3);
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
	public void test3_Venta_DetalleCreation(){
		try{
			CallableStatement statement = cn.prepareCall(sqlCreate);
			statement.registerOutParameter(1, java.sql.Types.INTEGER);
			statement.setInt(2, ventaDetalle.getIdProducto());
			statement.setInt(3, ventaDetalle.getCantidad());
			statement.executeUpdate();
			
			id = statement.getInt(1);
			ventaDetalle.setIdVenta(id);
			Assert.assertNotSame(0, id);
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}
	
	@Test
	public void test4_Venta_DetalleRead(){
		try{
			ventaDetalle = null;
			CallableStatement statement = cn.prepareCall(sqlReadId);
			statement.setInt(1, id);
			rs = statement.executeQuery();
			if(rs.next()){
				ventaDetalle = new Venta_Detalle(rs.getInt(1), rs.getInt(2), rs.getInt(3));
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
		assertNotNull(ventaDetalle);
	}
	
	@Test
	public void test5_Venta_DetalleReadAll(){
		try{
			CallableStatement statement = cn.prepareCall(sqlRead);
			rs = statement.executeQuery();
			lista = new ArrayList<Venta_Detalle>();
			while(rs.next()){
				Venta_Detalle ventaDetalle = new Venta_Detalle(rs.getInt(1), rs.getInt(2), rs.getInt(3));
				lista.add(ventaDetalle);
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
		assertNotNull(lista);
	}
	
	@Test
	public void test6_Venta_DetalleUpdate(){
		try{
			CallableStatement statement = cn.prepareCall(sqlUpdate);
			statement.setInt(1, ventaDetalleUpdate.getIdVenta());
			statement.setInt(2, ventaDetalleUpdate.getIdProducto());
			statement.setInt(3, ventaDetalleUpdate.getCantidad());
			Assert.assertEquals(1, statement.executeUpdate());
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}
	
	@Test
	public void test7_Venta_DetalleDelete(){
		try{
			CallableStatement statement = cn.prepareCall(sqlDelete);
			statement.setInt(1, id);
			Assert.assertEquals(1, statement.executeUpdate());
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}

}

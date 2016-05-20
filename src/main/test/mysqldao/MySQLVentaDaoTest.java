package main.test.mysqldao;

import static org.junit.Assert.assertNotNull;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import junit.framework.Assert;
import main.java.com.lab.restaurant.model.Venta;
import main.java.com.lab.restaurant.utils.MySqlDBConexion;

@SuppressWarnings("deprecation")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MySQLVentaDaoTest {
	static int id;
	Connection cn;
	ResultSet rs;
	Venta venta;
	Venta ventaUpdate;
	List<Venta> lista;
	Calendar calendar = Calendar.getInstance();
	java.util.Date now = calendar.getTime();
	java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
	String sqlCreate = "{call USP_VENTA_CREATE(?,?,?,?,?)}";
	String sqlRead = "{call USP_VENTA_READ}";
	String sqlReadId = "{call USP_VENTA_OBTAIN(?)}";
	String sqlUpdate = "{call USP_VENTA_UPDATE(?,?,?,?,?)}";
	String sqlDelete = "{call USP_VENTA_DELETE(?)}";
	
	@Before
	public void setUp() throws Exception {
		cn = MySqlDBConexion.getConexion();
		fillTestVenta();
	}
	
	private void fillTestVenta(){
		venta = new Venta(1, "000001", currentTimestamp, 20.00, 1);
		ventaUpdate = new Venta(1, "000001", currentTimestamp, 30.00, 1);
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
	public void test3_VentaCreation(){
		try{
			CallableStatement statement = cn.prepareCall(sqlCreate);
			statement.registerOutParameter(1, java.sql.Types.INTEGER);
			statement.setString(2, venta.getNumeroVenta());
			statement.setTimestamp(3, venta.getFechaVenta());
			statement.setDouble(4, venta.getTotalVenta());
			statement.setInt(5, venta.getIdVisita());
			statement.executeUpdate();
			
			id = statement.getInt(1);
			venta.setIdVenta(id);
			Assert.assertNotSame(0, id);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	@Test
	public void test4_VentaRead(){
		try{
			venta = null;
			CallableStatement statement = cn.prepareCall(sqlReadId);
			statement.setInt(1, id);
			rs = statement.executeQuery();
			if(rs.next()){
				venta = new Venta(rs.getInt(1), rs.getString(2), rs.getTimestamp(3),
						rs.getDouble(4), rs.getInt(5));
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		assertNotNull(venta);
	}
	
	@Test
	public void test5_VentaReadAll(){
		try{
			CallableStatement statement = cn.prepareCall(sqlRead);
			rs = statement.executeQuery();
			lista = new ArrayList<Venta>();
			while(rs.next()){
				Venta venta = new Venta(rs.getInt(1), rs.getString(2), rs.getTimestamp(3),
						rs.getDouble(4), rs.getInt(5));
				lista.add(venta);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		assertNotNull(lista);
	}
	
	@Test
	public void test6_VentaUpdate(){
		try{
			CallableStatement statement = cn.prepareCall(sqlUpdate);
			statement.setInt(1, ventaUpdate.getIdVenta());
			statement.setString(2, ventaUpdate.getNumeroVenta());
			statement.setTimestamp(3, ventaUpdate.getFechaVenta());
			statement.setDouble(4, ventaUpdate.getTotalVenta());
			statement.setInt(5, ventaUpdate.getIdVisita());
			Assert.assertEquals(1, statement.executeUpdate());
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	@Test
	public void test7_VentaDelete(){
		try{
			CallableStatement statement = cn.prepareCall(sqlDelete);
			statement.setInt(1, id);
			Assert.assertEquals(1, statement.executeUpdate());
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}

package main.test.mysqldao;

import static org.junit.Assert.assertNotNull;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.java.com.lab.restaurant.model.Mesa;
import main.java.com.lab.restaurant.utils.MySqlDBConexion;

public class MySQLMesaDaoReadTest {
	Connection cn;
	String sql;
	String sql2;
	ResultSet rs;
	int id;
	Mesa mesa;
	List<Mesa> lista;

	@Before
	public void setUp() throws Exception {
		cn = MySqlDBConexion.getConexion();
		sql = "{call USP_MESA_READ}";
		sql2 = "{call USP_MESA_OBTAIN(?)}";
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
	public void testMesaReadAll() {
		try{
			CallableStatement statement = cn.prepareCall(sql);
			rs = statement.executeQuery();
			lista = new ArrayList<Mesa>();
			while(rs.next()){
				Mesa mesa = new Mesa(rs.getInt(1), rs.getBoolean(2));
				lista.add(mesa);
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
		assertNotNull(lista);
	}
	
	@Test
	public void testMesaRead(){
		try{
			CallableStatement statement = cn.prepareCall(sql2);
			statement.setInt(1, id);
			rs = statement.executeQuery();
			if(rs.next()){
				mesa = new Mesa(rs.getInt(1), rs.getBoolean(2));
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
		assertNotNull(mesa);
	}

}

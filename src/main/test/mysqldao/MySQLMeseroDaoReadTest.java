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

import main.java.com.lab.restaurant.model.Mesero;
import main.java.com.lab.restaurant.utils.MySqlDBConexion;

public class MySQLMeseroDaoReadTest {
	Connection cn;
	String sql;
	List<Mesero> lista;
	Mesero mesero;
	String sql2;
	ResultSet rs;
	int id;

	@Before
	public void setUp() throws Exception {
		cn = MySqlDBConexion.getConexion();
		id = 1;
		sql = "{call USP_MESERO_READ}";
		sql2 = "{call USP_MESERO_OBTAIN(?)}";
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
	public void testMeseroReadAll() {
		try{
			CallableStatement statement = cn.prepareCall(sql);
			rs = statement.executeQuery();
			lista = new ArrayList<Mesero>();
			while(rs.next()){
				Mesero mesero = new Mesero(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				lista.add(mesero);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		assertNotNull(lista);
	}
	
	@Test
	public void testMeseroRead(){
		try{
			CallableStatement statement = cn.prepareCall(sql2);
			statement.setInt(1, id);
			rs = statement.executeQuery();
			if(rs.next()){
				mesero = new Mesero(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
		assertNotNull(mesero);
	}

}

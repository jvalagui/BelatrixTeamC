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

import main.java.com.lab.restaurant.model.Cliente;
import main.java.com.lab.restaurant.utils.MySqlDBConexion;

public class MySQLClienteDaoReadTest {
	Connection cn;
	String sql;
	String sql2;
	ResultSet rs;
	int id;
	Cliente cliente;
	List<Cliente> lista;

	@Before
	public void setUp() throws Exception {
		cn = MySqlDBConexion.getConexion();
		id = 1;
		sql = "{call USP_CLIENTE_READ}";
		sql2 = "{call USP_CLIENTE_OBTAIN(?)}";
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
	public void testClienteReadAll(){
		try{
			CallableStatement statement = cn.prepareCall(sql);
			rs = statement.executeQuery();
			lista = new ArrayList<Cliente>();
			while(rs.next()){
				Cliente cliente = new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				lista.add(cliente);
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
		assertNotNull(lista);
	}
	
	@Test
	public void testClienteRead(){
		try{
			CallableStatement statement = cn.prepareCall(sql2);
			statement.setInt(1, id);
			rs = statement.executeQuery();
			if(rs.next()){
				cliente = new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
		assertNotNull(cliente);
	}

}

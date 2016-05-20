package main.test.mysqldao;

import static org.junit.Assert.assertNotNull;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import junit.framework.Assert;
import main.java.com.lab.restaurant.model.Cliente;
import main.java.com.lab.restaurant.utils.MySqlDBConexion;

@SuppressWarnings("deprecation")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MySQLClienteDaoTest {
	static int id;
	Connection cn;
	String sqlCreate = "{call USP_CLIENTE_CREATE(?,?,?,?,?)}";
	String sqlRead = "{call USP_CLIENTE_READ}";
	String sqlReadId = "{call USP_CLIENTE_OBTAIN(?)}";
	String sqlUpdate = "{call USP_CLIENTE_UPDATE(?,?,?,?,?)}";
	String sqlDelete = "{call USP_CLIENTE_DELETE(?)}";
	Cliente cliente;
	Cliente clienteUpdate;
	ResultSet rs;
	List<Cliente> lista;
	
	@Before
	public void setUp() throws Exception {
		cn = MySqlDBConexion.getConexion();
		fillTestCliente();
	}
	
	@After
	public void after(){
		try {
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void fillTestCliente(){
		cliente = new Cliente(id, "60465974", "Daniel", "Vasquez", "Fernandez");
		clienteUpdate = new Cliente(id, "60465974", "Mark", "Chang", "Ramierez");
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
		
	}
	
	@Test
	public void test3_ClienteCreation() throws Exception {
		
		try{
			CallableStatement statement = cn.prepareCall(sqlCreate);
			statement.registerOutParameter(1, java.sql.Types.INTEGER);
			statement.setString(2, cliente.getDni());
			statement.setString(3, cliente.getNombre());
			statement.setString(4, cliente.getApellidoPaterno());
			statement.setString(5, cliente.getApellidoMaterno());
			statement.executeUpdate();
			
			id = statement.getInt(1);
			cliente.setId(id);
			Assert.assertNotSame(0, id);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}
	
	@Test
	public void test4_ClienteRead(){
		try{
			cliente = null;
			CallableStatement statement = cn.prepareCall(sqlReadId);
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
	
	@Test
	public void test5_ClienteReadAll(){
		try{
			CallableStatement statement = cn.prepareCall(sqlRead);
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
	public void test6_ClienteUpdate() {
		try{
			PreparedStatement statement = cn.prepareStatement(sqlUpdate);
			statement.setInt(1, cliente.getId());
			statement.setString(2, cliente.getDni());
			statement.setString(3, cliente.getNombre());
			statement.setString(4, cliente.getApellidoPaterno());
			statement.setString(5, cliente.getApellidoMaterno());
			Assert.assertEquals(1, statement.executeUpdate());
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}
	
	@Test
	public void test7_ClienteDelete() {
		try{
			CallableStatement statement = cn.prepareCall(sqlDelete);
			statement.setInt(1, id);
			Assert.assertEquals(1, statement.executeUpdate());
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}
	


}

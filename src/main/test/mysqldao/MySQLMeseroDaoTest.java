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
import main.java.com.lab.restaurant.model.Mesero;
import main.java.com.lab.restaurant.utils.MySqlDBConexion;

@SuppressWarnings("deprecation")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MySQLMeseroDaoTest {
	static int id;
	Connection cn;
	ResultSet rs;
	Mesero mesero;
	Mesero meseroUpdate;
	List<Mesero> lista;
	String sqlCreate = "{call USP_MESERO_CREATE(?,?,?,?,?)}";
	String sqlRead = "{call USP_MESERO_READ}";
	String sqlReadId = "{call USP_MESERO_OBTAIN(?)}";
	String sqlUpdate = "{call USP_MESERO_UPDATE(?,?,?,?,?)}";
	String sqlDelete = "{call USP_MESERO_DELETE(?)}";
	
	@Before
	public void setUp() throws Exception {
		cn = MySqlDBConexion.getConexion();
		fillTestMesero();
	}
	
	private void fillTestMesero(){
		mesero = new Mesero(1, "36252578", "Mark", "Frank", "Lastname");
		meseroUpdate = new Mesero(1, "45126532", "Marcus", "DeFranco", "Lastname");
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
	public void test3_MeseroCreation(){
		try{
			CallableStatement statement = cn.prepareCall(sqlCreate);
			statement.registerOutParameter(1, java.sql.Types.INTEGER);
			statement.setString(2, mesero.getDni());
			statement.setString(3, mesero.getNombre());
			statement.setString(4, mesero.getApellidoPaterno());
			statement.setString(5, mesero.getApellidoMaterno());
			statement.executeUpdate();
			
			id = statement.getInt(1);
			mesero.setId(id);
			Assert.assertNotSame(0, id);
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}
	
	@Test
	public void test4_MeseroRead(){
		try{
			mesero = null;
			CallableStatement statement = cn.prepareCall(sqlReadId);
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
	
	@Test
	public void test5_MeseroReadAll() {
		try{
			CallableStatement statement = cn.prepareCall(sqlRead);
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
	public void test6_MeseroUpdate() {
		try{
			CallableStatement statement = cn.prepareCall(sqlUpdate);
			statement.setInt(1, meseroUpdate.getId());
			statement.setString(2, meseroUpdate.getDni());
			statement.setString(3, meseroUpdate.getNombre());
			statement.setString(4, meseroUpdate.getApellidoPaterno());
			statement.setString(5, meseroUpdate.getApellidoMaterno());
			Assert.assertEquals(1, statement.executeUpdate());
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}
	
	@Test
	public void test7_MeseroDelete() {
		try{
			CallableStatement statement = cn.prepareCall(sqlDelete);
			statement.setInt(1, id);
			Assert.assertEquals(1, statement.executeUpdate());
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}

}

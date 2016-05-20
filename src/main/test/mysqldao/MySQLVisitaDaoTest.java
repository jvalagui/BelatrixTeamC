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
import main.java.com.lab.restaurant.model.Visita;
import main.java.com.lab.restaurant.utils.MySqlDBConexion;

@SuppressWarnings("deprecation")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MySQLVisitaDaoTest {
	static int id;
	Connection cn;
	ResultSet rs;
	Visita visita;
	Visita visitaUpdate;
	List<Visita> lista;
	String sqlCreate = "{call USP_VISITA_CREATE(?,?,?,?,?)}";
	String sqlRead = "{call USP_VISITA_READ}";
	String sqlReadId = "{call USP_VISITA_OBTAIN(?)}";
	String sqlUpdate = "{call USP_VISITA_UPDATE(?,?,?,?,?)}";
	String sqlDelete = "{call USP_VISITA_DELETE(?)}";

	@Before
	public void setUp() throws Exception {
		cn = MySqlDBConexion.getConexion();
		fillTestVisita();
	}
	
	private void fillTestVisita(){
		visita = new Visita(1, 1, 1, 1, 2);
		visitaUpdate = new Visita(1, 1, 1, 1, 3);
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
	public void test3_VisitaCreation(){
		try{
			CallableStatement statement = cn.prepareCall(sqlCreate);
			statement.registerOutParameter(1, java.sql.Types.INTEGER);
			statement.setInt(2, visita.getIdCliente());
			statement.setInt(3, visita.getIdMesero());
			statement.setInt(4, visita.getIdMesa());
			statement.setInt(5, visita.getEstado());
			statement.executeUpdate();
			
			id = statement.getInt(1);
			visita.setId(id);
			Assert.assertNotSame(0, id);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	@Test
	public void test4_VisitaRead(){
		try{
			visita = null;
			CallableStatement statement = cn.prepareCall(sqlReadId);
			statement.setInt(1, id);
			rs = statement.executeQuery();
			if(rs.next()){
				visita = new Visita(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		assertNotNull(visita);
	}
	
	@Test
	public void test5_VisitaReadAll(){
		try{
			CallableStatement statement = cn.prepareCall(sqlRead);
			rs = statement.executeQuery();
			lista = new ArrayList<Visita>();
			while(rs.next()){
				Visita visita = new Visita(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
				lista.add(visita);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		assertNotNull(lista);
	}
	
	@Test
	public void test6_VisitaUpdate(){
		try{
			CallableStatement statement = cn.prepareCall(sqlUpdate);
			statement.setInt(1, visitaUpdate.getId());
			statement.setInt(2, visitaUpdate.getIdCliente());
			statement.setInt(3, visitaUpdate.getIdMesero());
			statement.setInt(4, visitaUpdate.getIdMesa());
			statement.setInt(5, visitaUpdate.getEstado());
			Assert.assertEquals(1, statement.executeUpdate());
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	@Test
	public void test7_VisitaDelete(){
		try{
			CallableStatement statement = cn.prepareCall(sqlDelete);
			statement.setInt(1, id);
			Assert.assertEquals(1, statement.executeUpdate());
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}

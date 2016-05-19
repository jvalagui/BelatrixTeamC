package main.test.mysqldao;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import main.java.com.lab.restaurant.utils.MySqlDBConexion;

public class MySQLConnectionTest {

	@Test
	public void test() {
		
		Connection cn = MySqlDBConexion.getConexion();
		
		assertNotNull(cn);
		


	}

}

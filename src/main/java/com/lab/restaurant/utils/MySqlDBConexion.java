package main.java.com.lab.restaurant.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import main.java.com.lab.restaurant.constantes.DB_Properties;

public class MySqlDBConexion {

	public static Connection getConexion(String bd) {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost/"+DB_Properties.BD_NAME;
			
			con = DriverManager.getConnection(url, DB_Properties.MYSQL_USER, DB_Properties.MYSQL_PASSWORD);
		} catch (ClassNotFoundException ex) {
			System.out.println("No hay Driver!!");
		} catch (SQLException ex) {
			System.out.println("Error con la BD");
		}
		return con;
	}
	
}

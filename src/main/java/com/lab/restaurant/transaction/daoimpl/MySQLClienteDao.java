package main.java.com.lab.restaurant.transaction.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.java.com.lab.restaurant.model.Cliente;
import main.java.com.lab.restaurant.transaction.dao.DaoManager;
import main.java.com.lab.restaurant.utils.MySqlDBConexion;

public class MySQLClienteDao implements DaoManager<Cliente>{

	@Override
	public List<Cliente> read() {
		List<Cliente> lista = null;
		Connection cn = MySqlDBConexion.getConexion();
		ResultSet rs = null;
		String sql = "{call USP_CLIENTE_READ}";
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
		return lista;
	}

	@Override
	public Cliente read(int id) {
		Cliente cliente = null;
		Connection cn = MySqlDBConexion.getConexion();
		ResultSet rs = null;
		String sql = "{call USP_CLIENTE_OBTAIN(?)}";
		try{
			CallableStatement statement = cn.prepareCall(sql);
			statement.setInt(1, id);
			rs = statement.executeQuery();
			if(rs.next()){
				cliente = new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return cliente;
	}

	@Override
	public void create(Cliente cliente) {
		Connection cn = MySqlDBConexion.getConexion();
		String sql = "{call USP_CLIENTE_CREATE(?,?,?,?,?)}";
		try{
			CallableStatement statement = cn.prepareCall(sql);
			statement.setInt(1, cliente.getId());
			statement.setString(2, cliente.getDni());
			statement.setString(3, cliente.getNombre());
			statement.setString(4, cliente.getApellidoPaterno());
			statement.setString(5, cliente.getApellidoMaterno());
			statement.executeUpdate();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

	@Override
	public void update(Cliente cliente) {
		Connection cn = MySqlDBConexion.getConexion();
		String sql = "{call USP_CLIENTE_UPDATE(?,?,?,?,?)}";
		try{
			PreparedStatement statement = cn.prepareStatement(sql);
			statement.setString(2, cliente.getDni());
			statement.setString(3, cliente.getNombre());
			statement.setString(4, cliente.getApellidoPaterno());
			statement.setString(5, cliente.getApellidoMaterno());
			statement.setInt(1, cliente.getId());
			statement.executeUpdate();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		Connection cn = MySqlDBConexion.getConexion();
		String sql = "{call USP_CLIENTE_DELETE(?)}";
		try{
			CallableStatement statement = cn.prepareCall(sql);
			statement.setInt(1, id);
			statement.executeUpdate();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

}

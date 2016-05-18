package main.java.com.lab.restaurant.transaction.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import main.java.com.lab.restaurant.model.Mesa;
import main.java.com.lab.restaurant.transaction.dao.DaoManager;
import main.java.com.lab.restaurant.utils.MySqlDBConexion;

public class MySQLMesaDao implements DaoManager<Mesa> {

	@Override
	public List<Mesa> read() {
		List<Mesa> lista = null;
		Connection cn = MySqlDBConexion.getConexion();
		ResultSet rs = null;
		String sql = "{call USP_MESA_READ}";
		try{
			CallableStatement statement = cn.prepareCall(sql);
			rs = statement.executeQuery();
			lista = new ArrayList<Mesa>();
			while(rs.next()){
				Mesa mesa = new Mesa(rs.getInt(1), rs.getBoolean(2));
				lista.add(mesa);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return lista;
	}

	@Override
	public Mesa read(int id) {
		Mesa mesa = null;
		Connection cn = MySqlDBConexion.getConexion();
		ResultSet rs = null;
		String sql = "{call USP_MESA_OBTAIN(?)}";
		try{
			CallableStatement statement = cn.prepareCall(sql);
			statement.setInt(1, id);
			rs = statement.executeQuery();
			if(rs.next()){
				mesa = new Mesa(rs.getInt(1), rs.getBoolean(3));
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return mesa;
	}

	@Override
	public void create(Mesa mesa) {
		Connection cn = MySqlDBConexion.getConexion();
		String sql = "{call USP_MESA_CREATE(?,?)}";
		try{
			CallableStatement statement = cn.prepareCall(sql);
			statement.setInt(1, mesa.getId());
			statement.setBoolean(2, mesa.isUsada());
			statement.executeUpdate();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

	@Override
	public void update(Mesa mesa) {
		Connection cn = MySqlDBConexion.getConexion();
		String sql = "{call USP_MESA_UPDATE(?,?)}";
		try{
			CallableStatement statement = cn.prepareCall(sql);
			statement.setInt(1, mesa.getId());
			statement.setBoolean(2, mesa.isUsada());
			statement.executeUpdate();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		Connection cn = MySqlDBConexion.getConexion();
		String sql = "{call USP_MESA_DELETE(?)}";
		try{
			CallableStatement statement = cn.prepareCall(sql);
			statement.setInt(1, id);
			statement.executeUpdate();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

}

package main.java.com.lab.restaurant.transaction.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import main.java.com.lab.restaurant.model.Mesero;
import main.java.com.lab.restaurant.transaction.dao.DaoManager;
import main.java.com.lab.restaurant.utils.MySqlDBConexion;

public class MySQLMeseroDao implements DaoManager<Mesero> {

	@Override
	public List<Mesero> read() {
		List<Mesero> lista = null;
		Connection cn = MySqlDBConexion.getConexion();
		ResultSet rs = null;
		String sql = "{call USP_MESERO_READ}";
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
		return lista;
	}

	@Override
	public Mesero read(int id) {
		Mesero mesero = null;
		Connection cn = MySqlDBConexion.getConexion();
		ResultSet rs = null;
		String sql = "{call USP_MESERO_OBTAIN(?)}";
		try{
			CallableStatement statement = cn.prepareCall(sql);
			statement.setInt(1, id);
			rs = statement.executeQuery();
			if(rs.next()){
				mesero = new Mesero(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return mesero;
	}

	@Override
	public void create(Mesero mesero) {
		Connection cn = MySqlDBConexion.getConexion();
		String sql = "{call USP_MESERO_CREATE(?,?,?,?,?)}";
		try{
			CallableStatement statement = cn.prepareCall(sql);
			statement.setInt(1, mesero.getId());
			statement.setString(2, mesero.getDni());
			statement.setString(3, mesero.getNombre());
			statement.setString(4, mesero.getApellidoPaterno());
			statement.setString(5, mesero.getApellidoMaterno());
			statement.executeUpdate();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

	@Override
	public void update(Mesero mesero) {
		Connection cn = MySqlDBConexion.getConexion();
		String sql = "{call USP_MESERO_UPDATE(?,?,?,?,?)}";
		try{
			CallableStatement statement = cn.prepareCall(sql);
			statement.setInt(1, mesero.getId());
			statement.setString(2, mesero.getDni());
			statement.setString(3, mesero.getNombre());
			statement.setString(4, mesero.getApellidoPaterno());
			statement.setString(5, mesero.getApellidoMaterno());
			statement.executeUpdate();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		Connection cn = MySqlDBConexion.getConexion();
		String sql = "{call USP_MESERO_DELETE(?)}";
		try{
			CallableStatement statement = cn.prepareCall(sql);
			statement.setInt(1, id);
			statement.executeUpdate();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}

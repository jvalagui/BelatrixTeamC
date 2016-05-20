package main.java.com.lab.restaurant.transaction.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.java.com.lab.restaurant.model.Visita;
import main.java.com.lab.restaurant.transaction.dao.DaoManager;
import main.java.com.lab.restaurant.utils.MySqlDBConexion;

public class MySQLVisitaDao implements DaoManager<Visita>{

	@Override
	public List<Visita> read() {
		List<Visita> lista = null;
		Connection cn = MySqlDBConexion.getConexion();
		ResultSet rs = null;
		String sql = "{call USP_VISITA_READ}";
		try{
			CallableStatement statement = cn.prepareCall(sql);
			rs = statement.executeQuery();
			lista = new ArrayList<Visita>();
			while(rs.next()){
				Visita visita = new Visita(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
				lista.add(visita);
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return lista;
	}

	@Override
	public Visita read(int id) {
		Visita visita = null;
		Connection cn = MySqlDBConexion.getConexion();
		ResultSet rs = null;
		String sql = "{call USP_VISITA_OBTAIN(?)}";
		try{
			CallableStatement statement = cn.prepareCall(sql);
			statement.setInt(1, id);
			rs = statement.executeQuery();
			if(rs.next()){
				visita = new Visita(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
		return visita;
	}

	@Override
	public void create(Visita visita) {
		Connection cn = MySqlDBConexion.getConexion();
		String sql = "{call USP_VISITA_CREATE(?,?,?,?,?)}";
		try{
			CallableStatement statement = cn.prepareCall(sql);
			statement.setInt(1, visita.getId());
			statement.setInt(2, visita.getIdCliente());
			statement.setInt(3, visita.getIdMesero());
			statement.setInt(4, visita.getIdMesa());
			statement.setInt(5, visita.getEstado());
			statement.executeUpdate();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
	}

	@Override
	public void update(Visita visita) {
		Connection cn = MySqlDBConexion.getConexion();
		String sql = "{call USP_VISITA_UPDATE(?,?,?,?,?)}";
		try{
			CallableStatement statement = cn.prepareCall(sql);
			statement.setInt(1, visita.getId());
			statement.setInt(2, visita.getIdCliente());
			statement.setInt(3, visita.getIdMesero());
			statement.setInt(4, visita.getIdMesa());
			statement.setInt(5, visita.getEstado());
			statement.executeUpdate();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		Connection cn = MySqlDBConexion.getConexion();
		String sql = "{call USP_VISITA_DELETE(?)}";
		try{
			CallableStatement statement = cn.prepareCall(sql);
			statement.setInt(1, id);
			statement.executeUpdate();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
	}

}

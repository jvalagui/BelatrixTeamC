package main.java.com.lab.restaurant.transaction.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.java.com.lab.restaurant.model.Venta;
import main.java.com.lab.restaurant.transaction.dao.DaoManager;
import main.java.com.lab.restaurant.utils.MySqlDBConexion;

public class MySQLVentaDao implements DaoManager<Venta> {

	@Override
	public List<Venta> read() {
		List<Venta> lista = null;
		Connection cn = MySqlDBConexion.getConexion();
		ResultSet rs = null;
		String sql = "{call USP_VENTA_READ}";
		try{
			CallableStatement statement = cn.prepareCall(sql);
			rs = statement.executeQuery();
			lista = new ArrayList<Venta>();
			while(rs.next()){
				Venta venta = new Venta(rs.getInt(1), rs.getString(2), rs.getTimestamp(3),
						rs.getDouble(4), rs.getInt(5));
				lista.add(venta);
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return lista;
	}

	@Override
	public Venta read(int id) {
		Venta venta = null;
		Connection cn = MySqlDBConexion.getConexion();
		ResultSet rs = null;
		String sql = "{call USP_VENTA_OBTAIN(?)}";
		try{
			CallableStatement statement = cn.prepareCall(sql);
			statement.setInt(1, id);
			rs = statement.executeQuery();
			if(rs.next()){
				venta = new Venta(rs.getInt(1), rs.getString(2), rs.getTimestamp(3),
						rs.getDouble(4), rs.getInt(5));
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return venta;
	}

	@Override
	public void create(Venta venta) {
		Connection cn = MySqlDBConexion.getConexion();
		String sql = "{call USP_VENTA_CREATE(?,?,?,?,?)}";
		try{
			CallableStatement statement = cn.prepareCall(sql);
			statement.setInt(1, venta.getIdVenta());
			statement.setString(2, venta.getNumeroVenta());
			statement.setTimestamp(3, venta.getFechaVenta());
			statement.setDouble(4, venta.getTotalVenta());
			statement.setInt(5, venta.getIdVisita());
			statement.executeUpdate();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
	}

	@Override
	public void update(Venta venta) {
		Connection cn = MySqlDBConexion.getConexion();
		String sql = "{call USP_VENTA_UPDATE(?,?,?,?,?)}";
		try{
			CallableStatement statement = cn.prepareCall(sql);
			statement.setInt(1, venta.getIdVenta());
			statement.setString(2, venta.getNumeroVenta());
			statement.setTimestamp(3, venta.getFechaVenta());
			statement.setDouble(4, venta.getTotalVenta());
			statement.setInt(5, venta.getIdVisita());
			statement.executeUpdate();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
		
	}

	@Override
	public void delete(int id) {
		Connection cn = MySqlDBConexion.getConexion();
		String sql = "{call USP_VENTA_DELETE(?)}";
		try{
			CallableStatement statement = cn.prepareCall(sql);
			statement.setInt(1, id);
			statement.executeUpdate();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
	}

}

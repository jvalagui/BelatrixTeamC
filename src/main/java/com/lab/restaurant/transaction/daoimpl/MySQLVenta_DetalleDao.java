package main.java.com.lab.restaurant.transaction.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.java.com.lab.restaurant.model.Venta_Detalle;
import main.java.com.lab.restaurant.transaction.dao.DaoManager;
import main.java.com.lab.restaurant.utils.MySqlDBConexion;

public class MySQLVenta_DetalleDao implements DaoManager<Venta_Detalle> {

	@Override
	public List<Venta_Detalle> read() {
		List<Venta_Detalle> lista = null;
		Connection cn = MySqlDBConexion.getConexion();
		ResultSet rs = null;
		String sql = "{call USP_VENTA_DETALLE_READ}";
		try{
			CallableStatement statement = cn.prepareCall(sql);
			rs = statement.executeQuery();
			lista = new ArrayList<Venta_Detalle>();
			while(rs.next()){
				Venta_Detalle ventaDetalle = new Venta_Detalle(rs.getInt(1), rs.getInt(2), rs.getInt(3));
				lista.add(ventaDetalle);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return lista;
	}

	@Override
	public Venta_Detalle read(int id) {
		Venta_Detalle ventaDetalle = null;
		Connection cn = MySqlDBConexion.getConexion();
		ResultSet rs = null;
		String sql = "{call USP_VENTA_DETALLE_OBTAIN(?)}";
		try{
			CallableStatement statement = cn.prepareCall(sql);
			statement.setInt(1, id);
			rs = statement.executeQuery();
			if(rs.next()){
				ventaDetalle = new Venta_Detalle(rs.getInt(1), rs.getInt(2), rs.getInt(3));
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return ventaDetalle;
	}

	@Override
	public void create(Venta_Detalle ventaDetalle) {
		Connection cn = MySqlDBConexion.getConexion();
		String sql = "{call USP_VENTA_DETALLE_CREATE(?,?,?)}";
		try{
			CallableStatement statement = cn.prepareCall(sql);
			statement.setInt(1, ventaDetalle.getIdVenta());
			statement.setInt(2, ventaDetalle.getIdProducto());
			statement.setInt(3, ventaDetalle.getCantidad());
			statement.executeUpdate();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
	}

	@Override
	public void update(Venta_Detalle ventaDetalle) {
		Connection cn = MySqlDBConexion.getConexion();
		String sql = "{call USP_VENTA_DETALLE_UPDATE(?,?,?)}";
		try{
			CallableStatement statement = cn.prepareCall(sql);
			statement.setInt(1, ventaDetalle.getIdVenta());
			statement.setInt(2, ventaDetalle.getIdProducto());
			statement.setInt(3, ventaDetalle.getCantidad());
			statement.executeUpdate();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		Connection cn = MySqlDBConexion.getConexion();
		String sql = "{call USP_VENTA_DETALLE_DELETE(?)}";
		try{
			CallableStatement statement = cn.prepareCall(sql);
			statement.setInt(1, id);
			statement.executeUpdate();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
	}

}

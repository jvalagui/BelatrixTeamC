package main.java.com.lab.restaurant.transaction.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import main.java.com.lab.restaurant.model.Producto;
import main.java.com.lab.restaurant.transaction.dao.DaoManager;
import main.java.com.lab.restaurant.utils.MySqlDBConexion;

public class MySQLProductoDao implements DaoManager<Producto>{

	@Override
	public List<Producto> read() {
		List<Producto> lista = null;
		Connection cn = MySqlDBConexion.getConexion();
		ResultSet rs = null;
		String sql = "{call USP_PRODUCTO_READ}";
		try{
			CallableStatement statement = cn.prepareCall(sql);
			rs = statement.executeQuery();
			lista = new ArrayList<Producto>();
			while(rs.next()){
				Producto producto = new Producto(rs.getInt(1), rs.getString(2), rs.getInt(3),
						rs.getInt(4), rs.getDouble(5), rs.getDouble(6), rs.getInt(7));
				lista.add(producto);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return lista;
	}

	@Override
	public Producto read(int id) {
		Producto producto = null;
		Connection cn = MySqlDBConexion.getConexion();
		ResultSet rs = null;
		String sql = "{call USP_PRODUCTO_READ(?)}";
		try{
			CallableStatement statement = cn.prepareCall(sql);
			statement.setInt(1, id);
			rs = statement.executeQuery();
			if(rs.next()){
				producto = new Producto(rs.getInt(1), rs.getString(2), rs.getInt(3),
						rs.getInt(4), rs.getDouble(5), rs.getDouble(6), rs.getInt(7));
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return producto;
	}

	@Override
	public void create(Producto producto) {
		Connection cn = MySqlDBConexion.getConexion();
		String sql = "{call USP_PRODUCTO_CREATE(?,?,?,?,?,?,?)}";
		try{
			CallableStatement statement = cn.prepareCall(sql);
			statement.setInt(1, producto.getId());
			statement.setString(2, producto.getNombre());
			statement.setInt(3, producto.getTipo());
			statement.setInt(4, producto.getCategoria());
			statement.setDouble(5, producto.getCosto());
			statement.setDouble(6, producto.getPrecio());
			statement.setInt(7, producto.getStock());
			statement.executeUpdate();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

	@Override
	public void update(Producto producto) {
		Connection cn = MySqlDBConexion.getConexion();
		String sql = "{call USP_PRODUCTO_UPDATE(?,?,?,?,?,?,?)}";
		try{
			CallableStatement statement = cn.prepareCall(sql);
			statement.setString(2, producto.getNombre());
			statement.setInt(3, producto.getTipo());
			statement.setInt(4, producto.getCategoria());
			statement.setDouble(5, producto.getCosto());
			statement.setDouble(6, producto.getPrecio());
			statement.setInt(7, producto.getStock());
			statement.setInt(1, producto.getId());
			statement.executeUpdate();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		Connection cn = MySqlDBConexion.getConexion();
		String sql = "{call USP_PRODUCTO_DELETE(?)}";
		try{
			CallableStatement statement = cn.prepareCall(sql);
			statement.setInt(1, id);
			statement.executeUpdate();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

}

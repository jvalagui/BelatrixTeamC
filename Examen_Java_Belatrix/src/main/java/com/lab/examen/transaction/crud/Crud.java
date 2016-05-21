package main.java.com.lab.examen.transaction.crud;

import java.util.List;

public interface Crud<T>{

	public void create(T t);
	public void update(T t);
	public void delete(int id);
	public T read(int id);
	public List<T> read();
}

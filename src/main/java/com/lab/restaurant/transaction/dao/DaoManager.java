package main.java.com.lab.restaurant.transaction.dao;

import java.util.List;

public interface DaoManager <T> {
		public List<T> read();
		public T read(int id);
		public void create(T t);
		public void update(T t);
		public void delete(int id);
}

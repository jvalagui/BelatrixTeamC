package transaction;

import java.util.ArrayList;
import java.util.List;

public interface Crud <T>{
	public void create(T object);
	public List<T> read();
	public T read(int id);
	//public void update(T object);
	//public void delete(int id);
}

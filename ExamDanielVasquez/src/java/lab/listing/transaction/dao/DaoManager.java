package java.lab.listing.transaction.dao;

import java.util.List;

/**
 * Created by daniel on 5/21/16.
 */
public interface DaoManager<T> {
    public List<T> read();
    public T readIf(int id);
    public void create(T t);
    public void update(T t);
    public void delete(int id);
}

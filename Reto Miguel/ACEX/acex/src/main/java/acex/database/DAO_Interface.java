package acex.database;

import java.util.List;


public interface DAO_Interface<T> {
    public List<T> getAll();
    public T getById(int id);
    
    public boolean update(T object);
    public boolean delete(T object);
}
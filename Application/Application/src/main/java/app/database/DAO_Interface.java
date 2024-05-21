package app.database;
/* @author Adrian */
import java.util.List;

/**
 * Esta interfaz define los métodos básicos para acceder a una base de datos.
 * 
 * @param <T> el tipo de objeto que se va a acceder en la base de datos.
 */
public interface DAO_Interface<T> {
    /**
     * Obtiene todos los objetos de la base de datos.
     * 
     * @return una lista de objetos de tipo T.
     */
    public List<T> getAll();

    /**
     * Obtiene un objeto de la base de datos por su identificador.
     * 
     * @param id el identificador del objeto.
     * @return el objeto de tipo T correspondiente al identificador dado.
     */
    public T getById(int id);

    /**
     * Actualiza un objeto en la base de datos.
     * 
     * @param object el objeto a actualizar.
     * @return true si la actualización fue exitosa, false de lo contrario.
     */
    public boolean update(T object);

    /**
     * Elimina un objeto de la base de datos por su identificador.
     * 
     * @param id el identificador del objeto a eliminar.
     * @return true si la eliminación fue exitosa, false de lo contrario.
     */
    public boolean delete(int id);
}

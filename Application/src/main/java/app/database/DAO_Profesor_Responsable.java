package app.database;
/* @author Adrian */
import app.objects.Obj_Profesor_Responsable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase implementa la interfaz DAO_Interface y proporciona métodos para acceder a la tabla "profesor_responsable" en la base de datos.
 */
public class DAO_Profesor_Responsable implements DAO_Interface<Obj_Profesor_Responsable> {
    /**
     * Obtiene todos los registros de la tabla "profesor_responsable".
     * 
     * @return una lista de objetos Obj_Profesor_Responsable que representan los registros de la tabla
     */
    @Override
    public List<Obj_Profesor_Responsable> getAll() {
        String sql = "SELECT id, id_profesor, id_actividad FROM profesor_responsable";
        List<Obj_Profesor_Responsable> profesores = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement(); ResultSet rset = stmt.executeQuery(sql)) {
            while (rset.next()) {
                Obj_Profesor_Responsable profesor = newProfesor(rset);
                
                if (!profesores.add(profesor)) {
                    throw new Exception("[ERROR] No se ha podido obtener el objecto.");
                }
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return profesores;
    }

        /**
     * Obtiene un registro de la tabla "profesor_responsable" por su ID.
     * 
     * @param id el ID del registro a obtener
     * @return un objeto Obj_Profesor_Responsable que representa el registro de la tabla, o null si no se encuentra
     */
    @Override
    public Obj_Profesor_Responsable getById(int id) {
        String sql = "SELECT id, id_profesor, id_actividad FROM profesor_responsable WHERE id=?";
        Obj_Profesor_Responsable profesor = null;
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            
            try (ResultSet rset = stmt.executeQuery()) {
                if (rset.next()) {
                    profesor = newProfesor(rset);
                }
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        }

        return profesor;
    }

     /**
     * Actualiza un registro de la tabla "profesor_responsable".
     * Si el objeto Obj_Profesor_Responsable tiene un ID mayor a 0, se realiza una actualización.
     * Si el objeto Obj_Profesor_Responsable tiene un ID igual a 0, se realiza una inserción.
     * 
     * @param profesor el objeto Obj_Profesor_Responsable a actualizar o insertar
     * @return true si la operación se realiza con éxito, false de lo contrario
     */
    @Override
    public boolean update(Obj_Profesor_Responsable profesor) {
        String sql = null;
        boolean result = false;
        
        if (profesor.getId() > 0) {
            sql = "UPDATE profesor_responsable SET id_profesor=?, id_actividad=? WHERE id=?";
        } else {
           sql = "INSERT INTO profesor_responsable (id_profesor, id_actividad) VALUES (?, ?)";
        }
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            if (profesor.getId() > 0) {
                stmt.setInt(3, profesor.getId());
            }
            stmt.setInt(1, profesor.getProfesor().getId());
            stmt.setInt(2, profesor.getActividad().getId());
            
            if (stmt.executeUpdate() != 1) {
                throw new Exception("[ERROR] No se ha podido actualizar el objecto.");
            } else {
                result = true;
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return result;
    }

     /**
     * Elimina un registro de la tabla "profesor_responsable" por su ID.
     * 
     * @param id el ID del registro a eliminar
     * @return true si la operación se realiza con éxito, false de lo contrario
     */
    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM profesor_responsable WHERE id=?";
        boolean result = false;
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            
            if (stmt.executeUpdate() != 1) {
                throw new Exception("[ERROR] No se ha podido eliminar el objecto.");
            } else {
                result = true;
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return result;
    }
    
     /**
     * Crea un nuevo objeto Obj_Profesor_Responsable a partir de un ResultSet.
     * 
     * @param rset el ResultSet que contiene los datos del objeto
     * @return un objeto Obj_Profesor_Responsable creado a partir de los datos del ResultSet
     * @throws SQLException si ocurre un error al acceder a los datos del ResultSet
     */
    private Obj_Profesor_Responsable newProfesor(final ResultSet rset) throws SQLException {
        return new Obj_Profesor_Responsable(rset.getInt("id"), rset.getInt("id_profesor"), rset.getInt("id_actividad"));
    }
    
     /**
     * Obtiene la conexión a la base de datos.
     * 
     * @return la conexión a la base de datos
     */
    private Connection getConnection() {
        return Access.getInstance().getConnection();
    }
    
      /**
     * Maneja una excepción de tipo SQLException, mostrando información detallada sobre el error.
     * 
     * @param ex la excepción SQLException a manejar
     */
    private void handleSQLException(SQLException ex) {
        System.out.println("[ERROR] Code: " + ex.getErrorCode());
        System.out.println("[ERROR] Message: " + ex.getMessage());
        System.out.println("[ERROR] SQL State: " + ex.getSQLState());
    }
}

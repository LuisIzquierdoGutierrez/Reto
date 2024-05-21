package app.database;
/* @author Miguel */
import app.objects.Obj_Alojamiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase implementa la interfaz DAO_Interface y proporciona métodos para acceder a la tabla "alojamiento" en la base de datos.
 */
public class DAO_Alojamiento implements DAO_Interface<Obj_Alojamiento> {
    
    /**
     * Obtiene todos los alojamientos de la base de datos.
     * 
     * @return una lista de objetos de tipo Obj_Alojamiento que representan los alojamientos en la base de datos.
     */

    @Override
    public List<Obj_Alojamiento> getAll() {
        String sql = "SELECT id, nombre FROM alojamiento";
        List<Obj_Alojamiento> alojamientos = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement(); ResultSet rset = stmt.executeQuery(sql)) {
            while (rset.next()) {
                Obj_Alojamiento alojamiento = newAlojamiento(rset);
                
                if (!alojamientos.add(alojamiento)) {
                    throw new Exception("[ERROR] No se ha podido obtener el objecto.");
                }
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return alojamientos;
    }
    
     /**
     * Obtiene un alojamiento de la base de datos por su ID.
     * 
     * @param id el ID del alojamiento a buscar.
     * @return un objeto de tipo Obj_Alojamiento que representa el alojamiento con el ID especificado, o null si no se encuentra.
     */

    
    @Override
    public Obj_Alojamiento getById(int id) {
        String sql = "SELECT id, nombre FROM alojamiento WHERE id=?";
        Obj_Alojamiento alojamiento = null;
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            
            try (ResultSet rset = stmt.executeQuery()) {
                if (rset.next()) {
                    alojamiento = newAlojamiento(rset);
                }
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        }

        return alojamiento;
    }
    /**
     * Actualiza un alojamiento en la base de datos.
     * Si el alojamiento tiene un ID mayor a 0, se realiza una actualización.
     * Si el alojamiento tiene un ID igual a 0, se realiza una inserción.
     * 
     * @param alojamiento el objeto de tipo Obj_Alojamiento que representa el alojamiento a actualizar o insertar.
     * @return true si la actualización o inserción fue exitosa, false de lo contrario.
     */

    
    @Override
    public boolean update(Obj_Alojamiento alojamiento) {
        String sql = null;
        boolean result = false;
        
        if (alojamiento.getId() > 0) {
            sql = "UPDATE alojamiento SET nombre=? WHERE id=?";
        } else {
           sql = "INSERT INTO alojamiento (nombre) VALUES (?)";
        }
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            if (alojamiento.getId() > 0) {
                stmt.setInt(2, alojamiento.getId());
            }
            stmt.setString(1, alojamiento.getNombre());
            
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
     * Elimina un alojamiento de la base de datos por su ID.
     * 
     * @param id el ID del alojamiento a eliminar.
     * @return true si la eliminación fue exitosa, false de lo contrario.
     */

    
    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM alojamiento WHERE id=?";
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
     * Crea un nuevo objeto de tipo Obj_Alojamiento a partir de un ResultSet.
     * 
     * @param rset el ResultSet que contiene los datos del alojamiento.
     * @return un objeto de tipo Obj_Alojamiento creado a partir de los datos del ResultSet.
     * @throws SQLException si ocurre un error al acceder a los datos del ResultSet.
     */
    
    private Obj_Alojamiento newAlojamiento(final ResultSet rset) throws SQLException {
        return new Obj_Alojamiento(rset.getInt("id"), rset.getString("nombre"));
    }
    
   /**
     * Obtiene la conexión a la base de datos.
     * 
     * @return la conexión a la base de datos.
     */
    private Connection getConnection() {
        return Access.getInstance().getConnection();
    }
    
    
    /**
     * Maneja una excepción de tipo SQLException, mostrando información detallada sobre el error.
     * 
     * @param ex la excepción de tipo SQLException a manejar.
     */
    private void handleSQLException(SQLException ex) {
        System.out.println("[ERROR] Code: " + ex.getErrorCode());
        System.out.println("[ERROR] Message: " + ex.getMessage());
        System.out.println("[ERROR] SQL State: " + ex.getSQLState());
    }
}

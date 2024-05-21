package app.database;
/* @author Saul */
import app.objects.Obj_Transporte;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase implementa la interfaz DAO_Interface y proporciona métodos para acceder a la tabla "transporte" en la base de datos.
 */
public class DAO_Transporte implements DAO_Interface<Obj_Transporte> {
     /**
     * Obtiene todos los objetos de transporte de la base de datos.
     * 
     * @return una lista de objetos de transporte
     */
    @Override
    public List<Obj_Transporte> getAll() {
        String sql = "SELECT id, nombre FROM transporte";
        List<Obj_Transporte> transportes = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement(); ResultSet rset = stmt.executeQuery(sql)) {
            while (rset.next()) {
                Obj_Transporte transporte = newTransporte(rset);
                
                if (!transportes.add(transporte)) {
                    throw new Exception("[ERROR] No se ha podido obtener el objecto.");
                }
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return transportes;
    }

     /**
     * Obtiene un objeto de transporte por su ID.
     * 
     * @param id el ID del objeto de transporte a obtener
     * @return el objeto de transporte correspondiente al ID especificado, o null si no se encuentra
     */
    @Override
    public Obj_Transporte getById(int id) {
        String sql = "SELECT id, nombre FROM transporte WHERE id=?";
        Obj_Transporte transporte = null;
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            
            try (ResultSet rset = stmt.executeQuery()) {
                if (rset.next()) {
                    transporte = newTransporte(rset);
                }
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        }

        return transporte;
    }

         /**
     * Actualiza un objeto de transporte en la base de datos.
     * Si el objeto de transporte tiene un ID mayor que 0, se realiza una actualización.
     * Si el objeto de transporte tiene un ID igual a 0, se realiza una inserción.
     * 
     * @param transporte el objeto de transporte a actualizar
     * @return true si la actualización se realiza correctamente, false en caso contrario
     */
    @Override
    public boolean update(Obj_Transporte transporte) {
        String sql = null;
        boolean result = false;
        
        if (transporte.getId() > 0) {
            sql = "UPDATE transporte SET nombre=? WHERE id=?";
        } else {
           sql = "INSERT INTO transporte (nombre) VALUES (?)";
        }
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            if (transporte.getId() > 0) {
                stmt.setInt(2, transporte.getId());
            }
            stmt.setString(1, transporte.getNombre());
            
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
     * Elimina un objeto de transporte de la base de datos por su ID.
     * 
     * @param id el ID del objeto de transporte a eliminar
     * @return true si la eliminación se realiza correctamente, false en caso contrario
     */
    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM transporte WHERE id=?";
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
     * Crea un nuevo objeto de transporte a partir de los datos del ResultSet.
     * 
     * @param rset el ResultSet que contiene los datos del objeto de transporte
     * @return el objeto de transporte creado
     * @throws SQLException si ocurre un error al acceder a los datos del ResultSet
     */
    private Obj_Transporte newTransporte(final ResultSet rset) throws SQLException {
        return new Obj_Transporte(rset.getInt("id"), rset.getString("nombre"));
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
     * Maneja una excepción de SQL, mostrando información detallada sobre el error.
     * 
     * @param ex la excepción de SQL a manejar
     */
    private void handleSQLException(SQLException ex) {
        System.out.println("[ERROR] Code: " + ex.getErrorCode());
        System.out.println("[ERROR] Message: " + ex.getMessage());
        System.out.println("[ERROR] SQL State: " + ex.getSQLState());
    }
}

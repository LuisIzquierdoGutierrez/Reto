package app.database;
/* @author Miguel */
import app.objects.Obj_Alojamiento_Utilizado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase implementa la interfaz DAO_Interface y proporciona métodos para acceder a la tabla "alojamiento_utilizado" en la base de datos.
 */


public class DAO_Alojamiento_Utilizado implements DAO_Interface<Obj_Alojamiento_Utilizado> {
    
     /**
     * Recupera todos los registros de la tabla "alojamiento_utilizado".
     * 
     * @return una lista de objetos Obj_Alojamiento_Utilizado que representan los registros de la tabla.
     */
    
    @Override
    public List<Obj_Alojamiento_Utilizado> getAll() {
        String sql = "SELECT id, id_alojamiento, id_actividad, importe, comentario FROM alojamiento_utilizado";
        List<Obj_Alojamiento_Utilizado> alojamientos = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement(); ResultSet rset = stmt.executeQuery(sql)) {
            while (rset.next()) {
                Obj_Alojamiento_Utilizado alojamiento = newAlojamiento(rset);
                
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
     * Recupera un registro de la tabla "alojamiento_utilizado" por su ID.
     * 
     * @param id el ID del registro a recuperar.
     * @return un objeto Obj_Alojamiento_Utilizado que representa el registro correspondiente al ID especificado, o null si no se encuentra ningún registro.
     */

    
    @Override
    public Obj_Alojamiento_Utilizado getById(int id) {
        String sql = "SELECT id, id_alojamiento, id_actividad, importe, comentario FROM alojamiento_utilizado WHERE id=?";
        Obj_Alojamiento_Utilizado alojamiento = null;
        
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
     * Actualiza un registro de la tabla "alojamiento_utilizado".
     * Si el objeto Obj_Alojamiento_Utilizado tiene un ID mayor que 0, se realiza una actualización.
     * Si el objeto Obj_Alojamiento_Utilizado tiene un ID igual a 0, se realiza una inserción.
     * 
     * @param alojamiento el objeto Obj_Alojamiento_Utilizado que se va a actualizar o insertar.
     * @return true si la operación se realiza con éxito, false de lo contrario.
     */

    
    @Override
    public boolean update(Obj_Alojamiento_Utilizado alojamiento) {
        String sql = null;
        boolean result = false;
        
        if (alojamiento.getId() > 0) {
            sql = "UPDATE alojamiento_utilizado SET id_alojamiento=?, id_actividad=?, importe=?, comentario=? WHERE id=?";
        } else {
           sql = "INSERT INTO alojamiento_utilizado (id_alojamiento, id_actividad, importe, comentario) VALUES (?, ?, ?, ?)";
        }
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            if (alojamiento.getId() > 0) {
                stmt.setInt(5, alojamiento.getId());
            }
            stmt.setInt(1, alojamiento.getAlojamiento().getId());
            stmt.setInt(2, alojamiento.getActividad().getId());
            stmt.setDouble(3, alojamiento.getImporte());
            stmt.setString(4, alojamiento.getComentario());
            
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
     * Elimina un registro de la tabla "alojamiento_utilizado" por su ID.
     * 
     * @param id el ID del registro a eliminar.
     * @return true si la operación se realiza con éxito, false de lo contrario.
     */

    
    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM alojamiento_utilizado WHERE id=?";
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
     * Crea un nuevo objeto Obj_Alojamiento_Utilizado a partir de un ResultSet.
     * 
     * @param rset el ResultSet que contiene los datos del objeto.
     * @return un objeto Obj_Alojamiento_Utilizado creado a partir de los datos del ResultSet.
     * @throws SQLException si ocurre algún error al acceder a los datos del ResultSet.
     */
    

    private Obj_Alojamiento_Utilizado newAlojamiento(final ResultSet rset) throws SQLException {
        return new Obj_Alojamiento_Utilizado(rset.getInt("id"), rset.getInt("id_alojamiento"), rset.getInt("id_actividad"), rset.getDouble("importe"), rset.getString("comentario"));
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
     * @param ex la excepción SQLException que se va a manejar.
     */
    private void handleSQLException(SQLException ex) {
        System.out.println("[ERROR] Code: " + ex.getErrorCode());
        System.out.println("[ERROR] Message: " + ex.getMessage());
        System.out.println("[ERROR] SQL State: " + ex.getSQLState());
    }
}

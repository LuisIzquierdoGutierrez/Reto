package app.database;
/* @author  Luis*/
import app.objects.Obj_Transporte_Utilizado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase implementa la interfaz DAO_Interface y proporciona métodos para acceder a la tabla "transporte_utilizado" en la base de datos.
 */
public class DAO_Transporte_Utilizado implements DAO_Interface<Obj_Transporte_Utilizado> {
   
    /**
     * Obtiene todos los registros de la tabla "transporte_utilizado".
     * 
     * @return una lista de objetos Obj_Transporte_Utilizado que representan los registros de la tabla.
     */
    @Override
    public List<Obj_Transporte_Utilizado> getAll() {
        String sql = "SELECT id, id_transporte, id_actividad, importe, comentario FROM transporte_utilizado";
        List<Obj_Transporte_Utilizado> transportes = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement(); ResultSet rset = stmt.executeQuery(sql)) {
            while (rset.next()) {
                Obj_Transporte_Utilizado transporte = newTransporte(rset);
                
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
     * Obtiene un registro de la tabla "transporte_utilizado" por su ID.
     * 
     * @param id el ID del registro a obtener.
     * @return un objeto Obj_Transporte_Utilizado que representa el registro correspondiente al ID especificado, o null si no se encuentra ningún registro.
     */
    @Override
    public Obj_Transporte_Utilizado getById(int id) {
        String sql = "SELECT id, id_transporte, id_actividad, importe, comentario FROM transporte_utilizado WHERE id=?";
        Obj_Transporte_Utilizado transporte = null;
        
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
     * Actualiza un registro de la tabla "transporte_utilizado".
     * Si el objeto Obj_Transporte_Utilizado tiene un ID mayor que 0, se realiza una actualización en la base de datos.
     * Si el objeto Obj_Transporte_Utilizado tiene un ID igual a 0, se realiza una inserción en la base de datos.
     * 
     * @param transporte el objeto Obj_Transporte_Utilizado a actualizar o insertar.
     * @return true si la operación se realiza correctamente, false en caso contrario.
     */
    @Override
    public boolean update(Obj_Transporte_Utilizado transporte) {
        String sql = null;
        boolean result = false;
        
        if (transporte.getId() > 0) {
            sql = "UPDATE transporte_utilizado SET id_transporte=?, id_actividad=?, importe=?, comentario=? WHERE id=?";
        } else {
           sql = "INSERT INTO transporte_utilizado (id_transporte, id_actividad, importe, comentario) VALUES (?, ?, ?, ?)";
        }
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            if (transporte.getId() > 0) {
                stmt.setInt(5, transporte.getId());
            }
            stmt.setInt(1, transporte.getTransporte().getId());
            stmt.setInt(2, transporte.getActividad().getId());
            stmt.setDouble(3, transporte.getImporte());
            stmt.setString(4, transporte.getComentario());
            
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
     * Elimina un registro de la tabla "transporte_utilizado" por su ID.
     * 
     * @param id el ID del registro a eliminar.
     * @return true si la operación se realiza correctamente, false en caso contrario.
     */
    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM transporte_utilizado WHERE id=?";
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
     * Crea un nuevo objeto Obj_Transporte_Utilizado a partir de un ResultSet.
     * 
     * @param rset el ResultSet que contiene los datos del objeto.
     * @return un objeto Obj_Transporte_Utilizado creado a partir de los datos del ResultSet.
     * @throws SQLException si ocurre un error al acceder a los datos del ResultSet.
     */
    private Obj_Transporte_Utilizado newTransporte(final ResultSet rset) throws SQLException {
        return new Obj_Transporte_Utilizado(rset.getInt("id"), rset.getInt("id_transporte"), rset.getInt("id_actividad"), rset.getDouble("importe"), rset.getString("comentario"));
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
     * @param ex la excepción SQLException a manejar.
     */
    private void handleSQLException(SQLException ex) {
        System.out.println("[ERROR] Code: " + ex.getErrorCode());
        System.out.println("[ERROR] Message: " + ex.getMessage());
        System.out.println("[ERROR] SQL State: " + ex.getSQLState());
    }
}

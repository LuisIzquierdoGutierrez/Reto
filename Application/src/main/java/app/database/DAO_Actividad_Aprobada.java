package app.database;
/* @author Adrian */
import app.enums.Enum_Estado;
import app.enums.Enum_Tipo;
import app.objects.Obj_Actividad_Aprobada;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


    /**
    * Esta clase implementa la interfaz DAO_Interface y proporciona métodos para acceder a la tabla "actividad_aprobada" en la base de datos.
    */
public class DAO_Actividad_Aprobada implements DAO_Interface<Obj_Actividad_Aprobada> {

    /**
     * Obtiene todas las actividades aprobadas de la base de datos.
     * 
     * @return una lista de objetos Obj_Actividad_Aprobada que representan las actividades aprobadas.
     */
    public List<Obj_Actividad_Aprobada> getAll() {
        String sql = "SELECT id, id_solicitante, titulo, comentario_actividad, tipo, prevista, estado, comentario_estado, transporte, alojamiento, hora_inicio, hora_fin, fecha_inicio, fecha_fin FROM actividad_aprobada";
        List<Obj_Actividad_Aprobada> actividades = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement(); ResultSet rset = stmt.executeQuery(sql)) {
            while (rset.next()) {
                Obj_Actividad_Aprobada actividad = newActividad(rset);
                
                if (!actividades.add(actividad)) {
                    throw new Exception("[ERROR] No se ha podido obtener el objecto.");
                }
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return actividades;
    }
    /**
     * Obtiene una actividad aprobada de la base de datos por su ID.
     * 
     * @param id el ID de la actividad aprobada.
     * @return un objeto Obj_Actividad_Aprobada que representa la actividad aprobada, o null si no se encuentra.
     */
    
    @Override
    public Obj_Actividad_Aprobada getById(int id) {
        String sql = "SELECT id, id_solicitante, titulo, comentario_actividad, tipo, prevista, estado, comentario_estado, transporte, alojamiento, hora_inicio, hora_fin, fecha_inicio, fecha_fin FROM actividad_aprobada WHERE id=?";
        Obj_Actividad_Aprobada actividad = null;
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            
            try (ResultSet rset = stmt.executeQuery()) {
                if (rset.next()) {
                    actividad = newActividad(rset);
                }
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        }

        return actividad;
    }
     /**
     * Actualiza una actividad aprobada en la base de datos.
     * 
     * @param actividad el objeto Obj_Actividad_Aprobada que representa la actividad aprobada a actualizar.
     * @return true si la actualización fue exitosa, false de lo contrario.
     */

    
    @Override
    public boolean update(Obj_Actividad_Aprobada actividad) {
        String sql = null;
        boolean result = false;
        
        if (actividad.getId() > 0) {
            sql = "UPDATE actividad_aprobada SET id_solicitante=?, titulo=?, comentario_actividad=?, tipo=?, prevista=?, estado=?, comentario_estado=?, transporte=?, alojamiento=?, hora_inicio=?, hora_fin=?, fecha_inicio=?, fecha_fin=? WHERE id=?";
        } else {
            sql = "INSERT INTO actividad_aprobada (id_solicitante, titulo, comentario_actividad, tipo, prevista, estado, comentario_estado, transporte, alojamiento, hora_inicio, hora_fin, fecha_inicio, fecha_fin) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        }
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            if (actividad.getId() > 0) {
                stmt.setInt(14, actividad.getId());
            }
            stmt.setInt(1, actividad.getSolicitante().getId());
            stmt.setString(2, actividad.getNombre());
            stmt.setString(3, actividad.getComentarioActividad());
            stmt.setString(4, String.valueOf(actividad.getTipo()));
            stmt.setBoolean(5, actividad.isPrevista());
            stmt.setString(6, String.valueOf(actividad.getEstado()));
            stmt.setString(7, actividad.getComentarioEstado());
            stmt.setBoolean(8, actividad.isTransporte());
            stmt.setBoolean(9, actividad.isAlojamiento());
            stmt.setTime(10, Time.valueOf(actividad.getHoraInicio()));
            stmt.setTime(11, Time.valueOf(actividad.getHoraFin()));
            stmt.setDate(12, Date.valueOf(actividad.getFechaInicio()));
            stmt.setDate(13, Date.valueOf(actividad.getFechaFin()));
            
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
     * Elimina una actividad aprobada de la base de datos por su ID.
     * 
     * @param id el ID de la actividad aprobada a eliminar.
     * @return true si la eliminación fue exitosa, false de lo contrario.
     */

    
    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM actividad_aprobada WHERE id=?";
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
     * Crea un nuevo objeto Obj_Actividad_Aprobada a partir de un ResultSet.
     * 
     * @param rset el ResultSet que contiene los datos de la actividad aprobada.
     * @return un objeto Obj_Actividad_Aprobada creado a partir de los datos del ResultSet.
     * @throws SQLException si ocurre un error al acceder a los datos del ResultSet.
     */


    private Obj_Actividad_Aprobada newActividad(final ResultSet rset) throws SQLException {
        return new Obj_Actividad_Aprobada(rset.getInt("id"), rset.getInt("id_solicitante"), rset.getString("titulo"), rset.getString("comentario_actividad"), Enum_Tipo.valueOf(rset.getString("tipo")), rset.getBoolean("prevista"), Enum_Estado.valueOf(rset.getString("estado")), rset.getString("comentario_estado"), rset.getBoolean("transporte"), rset.getBoolean("alojamiento"), rset.getTime("hora_inicio").toLocalTime(), rset.getTime("hora_fin").toLocalTime(), rset.getDate("fecha_inicio").toLocalDate(), rset.getDate("fecha_fin").toLocalDate());
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
     * Maneja una excepción de tipo SQLException, imprimiendo información detallada sobre la excepción.
     * 
     * @param ex la excepción SQLException a manejar.
     */
    private void handleSQLException(SQLException ex) {
        System.out.println("[ERROR] Code: " + ex.getErrorCode());
        System.out.println("[ERROR] Message: " + ex.getMessage());
        System.out.println("[ERROR] SQL State: " + ex.getSQLState());
    }
}

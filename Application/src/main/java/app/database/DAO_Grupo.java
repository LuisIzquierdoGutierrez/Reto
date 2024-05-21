package app.database;
/* @author Adrian ,Luis */
import app.objects.Obj_Grupo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase implementa la interfaz DAO_Interface y proporciona métodos para acceder a la tabla "grupo" en la base de datos.
 */


public class DAO_Grupo implements DAO_Interface<Obj_Grupo> {
    
     /**
     * Obtiene todos los grupos de la base de datos.
     * 
     * @return una lista de objetos Obj_Grupo que representan los grupos en la base de datos.
     */

    @Override
    public List<Obj_Grupo> getAll() {
        String sql = "SELECT id, id_curso, codigo, num_alumnos, activo FROM grupo";
        List<Obj_Grupo> grupos = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement(); ResultSet rset = stmt.executeQuery(sql)) {
            while (rset.next()) {
                Obj_Grupo grupo = newGrupo(rset);
                
                if (!grupos.add(grupo)) {
                    throw new Exception("[ERROR] No se ha podido obtener el objecto.");
                }
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return grupos;
    }
    
       /**
     * Obtiene un grupo de la base de datos por su ID.
     * 
     * @param id el ID del grupo a buscar.
     * @return un objeto Obj_Grupo que representa el grupo con el ID especificado, o null si no se encuentra.
     */

    
    @Override
    public Obj_Grupo getById(int id) {
        String sql = "SELECT id, id_curso, codigo, num_alumnos, activo FROM grupo WHERE id=?";
        Obj_Grupo grupo = null;
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            
            try (ResultSet rset = stmt.executeQuery()) {
                if (rset.next()) {
                    grupo = newGrupo(rset);
                }
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        }

        return grupo;
    }
    
       /**
     * Actualiza un grupo en la base de datos.
     * Si el grupo tiene un ID mayor que 0, se realiza una actualización.
     * Si el grupo tiene un ID igual a 0, se realiza una inserción.
     * 
     * @param grupo el grupo a actualizar o insertar en la base de datos.
     * @return true si la operación se realiza con éxito, false de lo contrario.
     */

    
    @Override
    public boolean update(Obj_Grupo grupo) {
        String sql = null;
        boolean result = false;
        
        if (grupo.getId() > 0) {
            sql = "UPDATE grupo SET id_curso=?, codigo=?, num_alumnos=?, activo=? WHERE id=?";
        } else {
           sql = "INSERT INTO grupo (id_curso, codigo, num_alumnos, activo) VALUES (?, ?, ?, ?)";
        }
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            if (grupo.getId() > 0) {
                stmt.setInt(5, grupo.getId());
            }
            stmt.setInt(1, grupo.getCurso().getId());
            stmt.setString(2, grupo.getCodigo());
            stmt.setInt(3, grupo.getNumAlumnos());
            stmt.setBoolean(4, grupo.isActivo());
            
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
     * Elimina un grupo de la base de datos por su ID.
     * 
     * @param id el ID del grupo a eliminar.
     * @return true si la operación se realiza con éxito, false de lo contrario.
     */

    
    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM grupo WHERE id=?";
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
     * Crea un nuevo objeto Obj_Grupo a partir de un ResultSet.
     * 
     * @param rset el ResultSet que contiene los datos del grupo.
     * @return un objeto Obj_Grupo creado a partir de los datos del ResultSet.
     * @throws SQLException si ocurre un error al acceder a los datos del ResultSet.
     */

    
    private Obj_Grupo newGrupo(final ResultSet rset) throws SQLException {
        return new Obj_Grupo(rset.getInt("id"), rset.getInt("id_curso"), rset.getString("codigo"), rset.getInt("num_alumnos"), rset.getBoolean("activo"));
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
     * @param ex la excepción SQLException que se ha producido.
     */
    private void handleSQLException(SQLException ex) {
        System.out.println("[ERROR] Code: " + ex.getErrorCode());
        System.out.println("[ERROR] Message: " + ex.getMessage());
        System.out.println("[ERROR] SQL State: " + ex.getSQLState());
    }
}

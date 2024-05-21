package app.database;
/* @author Adrian */
import app.objects.Obj_Departamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase implementa la interfaz DAO_Interface y proporciona métodos para acceder a la tabla "departamento" en la base de datos.
 */

public class DAO_Departamento implements DAO_Interface<Obj_Departamento> {
    
      /**
     * Obtiene todos los departamentos de la base de datos.
     * 
     * @return una lista de objetos Obj_Departamento que representan los departamentos en la base de datos.
     */

    @Override
    public List<Obj_Departamento> getAll() {
        String sql = "SELECT id, id_jefe, codigo, nombre FROM departamento";
        List<Obj_Departamento> departamentos = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement(); ResultSet rset = stmt.executeQuery(sql)) {
            while (rset.next()) {
                Obj_Departamento departamento = newDepartamento(rset);
                
                if (!departamentos.add(departamento)) {
                    throw new Exception("[ERROR] No se ha podido obtener el objecto.");
                }
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return departamentos;
    }
    
     /**
     * Obtiene un departamento de la base de datos por su ID.
     * 
     * @param id el ID del departamento a buscar.
     * @return un objeto Obj_Departamento que representa el departamento con el ID especificado, o null si no se encuentra.
     */

    
    @Override
    public Obj_Departamento getById(int id) {
        String sql = "SELECT id, id_jefe, codigo, nombre FROM departamento WHERE id=?";
        Obj_Departamento departamento = null;
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            
            try (ResultSet rset = stmt.executeQuery()) {
                if (rset.next()) {
                    departamento = newDepartamento(rset);
                }
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        }

        return departamento;
    }
    
      /**
     * Actualiza un departamento en la base de datos.
     * Si el departamento tiene un ID mayor a 0, se realiza una actualización.
     * Si el departamento tiene un ID igual a 0, se realiza una inserción.
     * 
     * @param departamento el objeto Obj_Departamento que representa el departamento a actualizar o insertar.
     * @return true si la actualización o inserción fue exitosa, false de lo contrario.
     */

    
    @Override
    public boolean update(Obj_Departamento departamento) {
        String sql = null;
        boolean result = false;
        
        if (departamento.getId() > 0) {
            sql = "UPDATE departamento SET id_jefe=?, codigo=?, nombre=? WHERE id=?";
        } else {
           sql = "INSERT INTO departamento (id_jefe, codigo, nombre) VALUES (?, ?, ?)";
        }
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            if (departamento.getId() > 0) {
                stmt.setInt(4, departamento.getId());
            }
            stmt.setInt(1, departamento.getJefe().getId());
            stmt.setString(2, departamento.getCodigo());
            stmt.setString(3, departamento.getNombre());
            
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
     * Elimina un departamento de la base de datos por su ID.
     * 
     * @param id el ID del departamento a eliminar.
     * @return true si la eliminación fue exitosa, false de lo contrario.
     */

    
    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM departamento WHERE id=?";
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
     * Crea un nuevo objeto Obj_Departamento a partir de los datos del ResultSet.
     * 
     * @param rset el ResultSet que contiene los datos del departamento.
     * @return un objeto Obj_Departamento creado a partir de los datos del ResultSet.
     * @throws SQLException si ocurre un error al acceder a los datos del ResultSet.
     */
    

    private Obj_Departamento newDepartamento(final ResultSet rset) throws SQLException {
        return new Obj_Departamento(rset.getInt("id"), rset.getInt("id_jefe"), rset.getString("codigo"), rset.getString("nombre"));
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
     * Maneja una excepción de SQL, imprimiendo información sobre la excepción.
     * 
     * @param ex la excepción de SQL a manejar.
     */
    private void handleSQLException(SQLException ex) {
        System.out.println("[ERROR] Code: " + ex.getErrorCode());
        System.out.println("[ERROR] Message: " + ex.getMessage());
        System.out.println("[ERROR] SQL State: " + ex.getSQLState());
    }
}

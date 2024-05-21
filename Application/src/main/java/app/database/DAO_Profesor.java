package app.database;
/* @author Luis */
import app.enums.Enum_Perfil;
import app.objects.Obj_Profesor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase implementa la interfaz DAO_Interface y proporciona métodos para acceder a la tabla "profesor" en la base de datos.
 */
public class DAO_Profesor implements DAO_Interface<Obj_Profesor> {
     
    /**
     * Obtiene todos los profesores de la base de datos.
     * 
     * @return una lista de objetos Obj_Profesor que representan a todos los profesores en la base de datos.
     */
    @Override
    public List<Obj_Profesor> getAll() {
        String sql = "SELECT id, id_departamento, dni, nombre, apellidos, email, password, perfil, activo FROM profesor";
        List<Obj_Profesor> profesores = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement(); ResultSet rset = stmt.executeQuery(sql)) {
            while (rset.next()) {
                Obj_Profesor profesor = newProfesor(rset);
                
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
     * Obtiene un profesor de la base de datos por su ID.
     * 
     * @param id el ID del profesor a buscar.
     * @return un objeto Obj_Profesor que representa al profesor con el ID especificado, o null si no se encuentra.
     */
    @Override
    public Obj_Profesor getById(int id) {
        String sql = "SELECT id, id_departamento, dni, nombre, apellidos, email, password, perfil, activo FROM profesor WHERE id=?";
        Obj_Profesor profesor = null;
        
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
     * Actualiza un profesor en la base de datos.
     * Si el profesor tiene un ID mayor que 0, se realiza una actualización.
     * Si el profesor tiene un ID igual a 0, se realiza una inserción.
     * 
     * @param profesor el objeto Obj_Profesor a actualizar o insertar.
     * @return true si la operación se realiza con éxito, false en caso contrario.
     */
    @Override
    public boolean update(Obj_Profesor profesor) {
        String sql = null;
        boolean result = false;
        
        if (profesor.getId() > 0) {
            sql = "UPDATE profesor SET id_departamento=?, dni=?, nombre=?, apellidos=?, email=?, password=?, perfil=?, activo=? WHERE id=?";
        } else {
           sql = "INSERT INTO profesor (id_departamento, dni, nombre, apellidos, email, password, perfil, activo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        }
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            if (profesor.getId() > 0) {
                stmt.setInt(9, profesor.getId());
            }
            stmt.setInt(1, profesor.getDepartamento().getId());
            stmt.setString(2, profesor.getDni());
            stmt.setString(3, profesor.getNombre());
            stmt.setString(4, profesor.getApellidos());
            stmt.setString(5, profesor.getEmail());
            stmt.setString(6, profesor.getPassword());
            stmt.setString(7, String.valueOf(profesor.getPerfil()));
            stmt.setBoolean(8, profesor.isActivo());
            
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
     * Elimina un profesor de la base de datos por su ID.
     * 
     * @param id el ID del profesor a eliminar.
     * @return true si la operación se realiza con éxito, false en caso contrario.
     */
    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM profesor WHERE id=?";
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
     * Crea un nuevo objeto Obj_Profesor a partir de los datos del ResultSet.
     * 
     * @param rset el ResultSet que contiene los datos del profesor.
     * @return un objeto Obj_Profesor creado a partir de los datos del ResultSet.
     * @throws SQLException si ocurre un error al acceder a los datos del ResultSet.
     */
    private Obj_Profesor newProfesor(final ResultSet rset) throws SQLException {
        return new Obj_Profesor(rset.getInt("id"), rset.getInt("id_departamento"), rset.getString("dni"), rset.getString("nombre"), rset.getString("apellidos"), rset.getString("email"), rset.getString("password"), Enum_Perfil.valueOf(rset.getString("perfil")), rset.getBoolean("activo"));
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

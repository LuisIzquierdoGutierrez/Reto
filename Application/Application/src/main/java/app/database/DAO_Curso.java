package app.database;
/* @author Naiara */
import app.enums.Enum_Etapa;
import app.objects.Obj_Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase implementa la interfaz DAO_Interface y proporciona métodos para acceder a la tabla "curso" en la base de datos.
 */
public class DAO_Curso implements DAO_Interface<Obj_Curso> {
    
     /**
     * Obtiene todos los cursos de la base de datos.
     * 
     * @return una lista de objetos de tipo Obj_Curso que representan todos los cursos en la base de datos.
     */

    @Override
    public List<Obj_Curso> getAll() {
        String sql = "SELECT id, codigo, etapa, descripcion, activo FROM curso";
        List<Obj_Curso> cursos = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement(); ResultSet rset = stmt.executeQuery(sql)) {
            while (rset.next()) {
                Obj_Curso curso = newCurso(rset);
                
                if (!cursos.add(curso)) {
                    throw new Exception("[ERROR] No se ha podido obtener el objecto.");
                }
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return cursos;
    }
    
     /**
     * Obtiene un curso de la base de datos por su ID.
     * 
     * @param id el ID del curso a buscar.
     * @return un objeto de tipo Obj_Curso que representa el curso encontrado, o null si no se encuentra.
     */

    
    @Override
    public Obj_Curso getById(int id) {
        String sql = "SELECT id, codigo, etapa, descripcion, activo FROM curso WHERE id=?";
        Obj_Curso curso = null;
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            
            try (ResultSet rset = stmt.executeQuery()) {
                if (rset.next()) {
                    curso = newCurso(rset);
                }
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        }

        return curso;
    }

     /**
     * Actualiza un curso en la base de datos.
     * Si el curso tiene un ID mayor a 0, se realiza una actualización.
     * Si el curso tiene un ID igual a 0, se realiza una inserción.
     * 
     * @param curso el objeto de tipo Obj_Curso que representa el curso a actualizar o insertar.
     * @return true si la operación se realiza con éxito, false de lo contrario.
     */
    
    @Override
    public boolean update(Obj_Curso curso) {
        String sql = null;
        boolean result = false;
        
        if (curso.getId() > 0) {
            sql = "UPDATE curso SET codigo=?, etapa=?, descripcion=?, activo=? WHERE id=?";
        } else {
           sql = "INSERT INTO curso (codigo, etapa, descripcion, activo) VALUES (?, ?, ?, ?)";
        }
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            if (curso.getId() > 0) {
                stmt.setInt(5, curso.getId());
            }
            stmt.setString(1, curso.getCodigo());
            stmt.setString(2, String.valueOf(curso.getEtapa()));
            stmt.setString(3, curso.getDescripcion());
            stmt.setBoolean(4, curso.isActivo());
            
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
     * Elimina un curso de la base de datos por su ID.
     * 
     * @param id el ID del curso a eliminar.
     * @return true si la operación se realiza con éxito, false de lo contrario.
     */

    
    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM curso WHERE id=?";
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
     * Crea un nuevo objeto de tipo Obj_Curso a partir de los datos del ResultSet.
     * 
     * @param rset el ResultSet que contiene los datos del curso.
     * @return un objeto de tipo Obj_Curso creado a partir de los datos del ResultSet.
     * @throws SQLException si ocurre un error al acceder a los datos del ResultSet.
     */
    

    private Obj_Curso newCurso(final ResultSet rset) throws SQLException {
        return new Obj_Curso(rset.getInt("id"), rset.getString("codigo"), Enum_Etapa.valueOf(rset.getString("etapa")), rset.getString("descripcion"), rset.getBoolean("activo"));
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
     * Maneja las excepciones de tipo SQLException.
     * Imprime información detallada sobre la excepción.
     * 
     * @param ex la excepción de tipo SQLException.
     */
    private void handleSQLException(SQLException ex) {
        System.out.println("[ERROR] Code: " + ex.getErrorCode());
        System.out.println("[ERROR] Message: " + ex.getMessage());
        System.out.println("[ERROR] SQL State: " + ex.getSQLState());
    }
}


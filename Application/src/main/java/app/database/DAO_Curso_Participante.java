package app.database;

import app.objects.Obj_Curso_Participante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DAO_Curso_Participante implements DAO_Interface<Obj_Curso_Participante> {

    @Override
    public List<Obj_Curso_Participante> getAll() {
        String sql = "SELECT id, id_curso, id_actividad, num_alumnos FROM curso_participante";
        List<Obj_Curso_Participante> cursos = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement(); ResultSet rset = stmt.executeQuery(sql)) {
            while (rset.next()) {
                Obj_Curso_Participante curso = newCurso(rset);
                
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

    
    @Override
    public Obj_Curso_Participante getById(int id) {
        String sql = "SELECT id, id_curso, id_actividad, num_alumnos FROM curso_participante WHERE id=?";
        Obj_Curso_Participante curso = null;
        
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

    
    @Override
    public boolean update(Obj_Curso_Participante curso) {
        String sql = null;
        boolean result = false;
        
        if (curso.getId() > 0) {
            sql = "UPDATE curso_participante SET id_curso=?, id_actividad=?, num_alumnos=? WHERE id=?";
        } else {
           sql = "INSERT INTO curso_participante (id_curso, id_actividad, num_alumnos) VALUES (?, ?, ?)";
        }
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            if (curso.getId() > 0) {
                stmt.setInt(4, curso.getId());
            }
            stmt.setInt(1, curso.getCurso().getId());
            stmt.setInt(2, curso.getActividad().getId());
            stmt.setInt(3, curso.getNumAlumnos());
            
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

    
    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM curso_participante WHERE id=?";
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
    
    
    private Obj_Curso_Participante newCurso(final ResultSet rset) throws SQLException {
        return new Obj_Curso_Participante(rset.getInt("id"), rset.getInt("id_curso"), rset.getInt("id_actividad"), rset.getInt("num_alumnos"));
    }
    
    
    private Connection getConnection() {
        return Access.getInstance().getConnection();
    }
    
    
    private void handleSQLException(SQLException ex) {
        System.out.println("[ERROR] Code: " + ex.getErrorCode());
        System.out.println("[ERROR] Message: " + ex.getMessage());
        System.out.println("[ERROR] SQL State: " + ex.getSQLState());
    }
}

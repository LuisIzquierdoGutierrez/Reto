package acex.database;

import acex.enums.C_Etapa;
import acex.objects.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DAO_Curso implements DAO_Interface<Curso> {
    
    @Override
    public List<Curso> getAll() {
        String sql = "SELECT id, codigo, etapa, num_alumnos, activo, descripcion FROM curso";
        List<Curso> cursos = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement(); ResultSet rset = stmt.executeQuery(sql)) {
            while (rset.next()) {
                Curso curso = getCurso(rset);
                
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
    public Curso getById(int id) {
        String sql = "SELECT id, codigo, etapa, num_alumnos, activo, descripcion FROM curso WHERE id=?";
        Curso curso = null;
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            
            try (ResultSet rset = stmt.executeQuery()) {
                if (rset.next()) {
                    curso = getCurso(rset);
                }
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        }

        return curso;
    }
    
    
    @Override
    public boolean update(Curso curso) {
        String sql = null;
        boolean result = false;
        
        if (curso.getId() > 0) {
            sql = "UPDATE curso SET codigo=?, etapa=?, num_alumnos=?, activo=?, descripcion=? WHERE id=?";
        } else {
           sql = "INSERT INTO curso (codigo, etapa, num_alumnos, activo, descripcion) VALUES (?, ?, ?, ?, ?)";
        }
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setString(1, curso.getCodigo());
            stmt.setString(2, String.valueOf(curso.getEtapa()));
            stmt.setInt(3, curso.getNumAlumnos());
            stmt.setBoolean(4, curso.isActivo());
            stmt.setString(5, curso.getDescripcion());
            stmt.setInt(6, curso.getId());
            
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
    public boolean delete(Curso curso) {
        String sql = "DELETE FROM curso WHERE id=?";
        boolean result = false;
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, curso.getId());
            
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
    
    
    private Curso getCurso(ResultSet rset) throws SQLException {
        return new Curso(rset.getInt("id"), rset.getString("codigo"), C_Etapa.valueOf(rset.getString("etapa")), rset.getInt("num_alumnos"), rset.getBoolean("activo"), rset.getString("descripcion"));
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

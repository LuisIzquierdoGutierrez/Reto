package app.database;

import app.enums.Enum_Etapa;
import app.objects.Obj_Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DAO_Curso implements DAO_Interface<Obj_Curso> {

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
    

    private Obj_Curso newCurso(final ResultSet rset) throws SQLException {
        return new Obj_Curso(rset.getInt("id"), rset.getString("codigo"), Enum_Etapa.valueOf(rset.getString("etapa")), rset.getString("descripcion"), rset.getBoolean("activo"));
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

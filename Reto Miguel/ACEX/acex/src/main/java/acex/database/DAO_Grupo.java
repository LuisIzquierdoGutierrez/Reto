package acex.database;

import acex.objects.Grupo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DAO_Grupo implements DAO_Interface<Grupo> {
    
    @Override
    public List<Grupo> getAll() {
        String sql = "SELECT id, id_curso, codigo, num_alumnos, activo, descripcion FROM grupo";
        List<Grupo> grupos = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement(); ResultSet rset = stmt.executeQuery(sql)) {
            while (rset.next()) {
                Grupo grupo = getGrupo(rset);
                
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
    
    
    @Override
    public Grupo getById(int id) {
        String sql = "SELECT id, id_curso, codigo, num_alumnos, activo, descripcion FROM grupo WHERE id=?";
        Grupo grupo = null;
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            
            try (ResultSet rset = stmt.executeQuery()) {
                if (rset.next()) {
                    grupo = getGrupo(rset);
                }
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        }

        return grupo;
    }
    
    
    @Override
    public boolean update(Grupo grupo) {
        String sql = null;
        boolean result = false;
        
        if (grupo.getId() > 0) {
            sql = "UPDATE grupo SET id_curso=?, codigo=?, num_alumnos=?, activo=?, descripcion=? WHERE id=?";
        } else {
           sql = "INSERT INTO grupo (id_curso, codigo, num_alumnos, activo, descripcion) VALUES (?, ?, ?, ?, ?, ?)";
        }
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, grupo.getIdCurso());
            stmt.setString(2, grupo.getCodigo());
            stmt.setInt(3, grupo.getNumAlumnos());
            stmt.setBoolean(4, grupo.isActivo());
            stmt.setString(5, grupo.getDescripcion());
            stmt.setInt(6, grupo.getId());
            
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
    public boolean delete(Grupo grupo) {
        String sql = "DELETE FROM grupo WHERE id=?";
        boolean result = false;
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, grupo.getId());
            
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

    
    private Grupo getGrupo(ResultSet rset) throws SQLException {
        return new Grupo(rset.getInt("id"), rset.getInt("id_curso"), rset.getString("codigo"), rset.getInt("num_alumnos"), rset.getBoolean("activo"), rset.getString("descripcion"));
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

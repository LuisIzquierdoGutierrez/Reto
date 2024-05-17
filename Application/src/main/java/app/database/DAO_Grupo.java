package app.database;

import app.objects.Obj_Grupo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DAO_Grupo implements DAO_Interface<Obj_Grupo> {

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

    
    private Obj_Grupo newGrupo(final ResultSet rset) throws SQLException {
        return new Obj_Grupo(rset.getInt("id"), rset.getInt("id_curso"), rset.getString("codigo"), rset.getInt("num_alumnos"), rset.getBoolean("activo"));
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

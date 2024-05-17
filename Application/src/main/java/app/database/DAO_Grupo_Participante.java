package app.database;

import app.objects.Obj_Grupo_Participante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DAO_Grupo_Participante implements DAO_Interface<Obj_Grupo_Participante> {

    @Override
    public List<Obj_Grupo_Participante> getAll() {
        String sql = "SELECT id, id_grupo, id_actividad, num_alumnos FROM grupo_participante";
        List<Obj_Grupo_Participante> grupos = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement(); ResultSet rset = stmt.executeQuery(sql)) {
            while (rset.next()) {
                Obj_Grupo_Participante grupo = newGrupo(rset);
                
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
    public Obj_Grupo_Participante getById(int id) {
        String sql = "SELECT id, id_grupo, id_actividad, num_alumnos FROM grupo_participante WHERE id=?";
        Obj_Grupo_Participante grupo = null;
        
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
    public boolean update(Obj_Grupo_Participante grupo) {
        String sql = null;
        boolean result = false;
        
        if (grupo.getId() > 0) {
            sql = "UPDATE grupo_participante SET id_grupo=?, id_actividad=?, num_alumnos=? WHERE id=?";
        } else {
           sql = "INSERT INTO grupo_participante (id_grupo, id_actividad, num_alumnos) VALUES (?, ?, ?)";
        }
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            if (grupo.getId() > 0) {
                stmt.setInt(4, grupo.getId());
            }
            stmt.setInt(1, grupo.getGrupo().getId());
            stmt.setInt(2, grupo.getActividad().getId());
            stmt.setInt(3, grupo.getNumAlumnos());
            
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
        String sql = "DELETE FROM grupo_participante WHERE id=?";
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
    

    private Obj_Grupo_Participante newGrupo(final ResultSet rset) throws SQLException {
        return new Obj_Grupo_Participante(rset.getInt("id"), rset.getInt("id_grupo"), rset.getInt("id_actividad"), rset.getInt("num_alumnos"));
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

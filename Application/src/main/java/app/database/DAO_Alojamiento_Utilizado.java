package app.database;

import app.objects.Obj_Alojamiento_Utilizado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DAO_Alojamiento_Utilizado implements DAO_Interface<Obj_Alojamiento_Utilizado> {
    
    @Override
    public List<Obj_Alojamiento_Utilizado> getAll() {
        String sql = "SELECT id, id_alojamiento, id_actividad FROM alojamiento_utilizado";
        List<Obj_Alojamiento_Utilizado> alojamientos = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement(); ResultSet rset = stmt.executeQuery(sql)) {
            while (rset.next()) {
                Obj_Alojamiento_Utilizado alojamiento = newAlojamiento(rset);
                
                if (!alojamientos.add(alojamiento)) {
                    throw new Exception("[ERROR] No se ha podido obtener el objecto.");
                }
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return alojamientos;
    }

    
    @Override
    public Obj_Alojamiento_Utilizado getById(int id) {
        String sql = "SELECT id, id_alojamiento, id_actividad FROM alojamiento_utilizado WHERE id=?";
        Obj_Alojamiento_Utilizado alojamiento = null;
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            
            try (ResultSet rset = stmt.executeQuery()) {
                if (rset.next()) {
                    alojamiento = newAlojamiento(rset);
                }
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        }

        return alojamiento;
    }

    
    @Override
    public boolean update(Obj_Alojamiento_Utilizado alojamiento) {
        String sql = null;
        boolean result = false;
        
        if (alojamiento.getId() > 0) {
            sql = "UPDATE alojamiento_utilizado SET id_alojamiento=?, id_actividad=? WHERE id=?";
        } else {
           sql = "INSERT INTO alojamiento_utilizado (id_alojamiento, id_actividad) VALUES (?, ?)";
        }
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            if (alojamiento.getId() > 0) {
                stmt.setInt(3, alojamiento.getId());
            }
            stmt.setInt(1, alojamiento.getAlojamiento().getId());
            stmt.setInt(2, alojamiento.getActividad().getId());
            
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
        String sql = "DELETE FROM alojamiento_utilizado WHERE id=?";
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
    

    private Obj_Alojamiento_Utilizado newAlojamiento(final ResultSet rset) throws SQLException {
        return new Obj_Alojamiento_Utilizado(rset.getInt("id"), rset.getInt("id_alojamiento"), rset.getInt("id_actividad"));
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

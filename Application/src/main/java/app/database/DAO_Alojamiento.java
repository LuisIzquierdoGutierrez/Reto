package app.database;

import app.objects.Obj_Alojamiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DAO_Alojamiento implements DAO_Interface<Obj_Alojamiento> {

    @Override
    public List<Obj_Alojamiento> getAll() {
        String sql = "SELECT id, nombre FROM alojamiento";
        List<Obj_Alojamiento> alojamientos = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement(); ResultSet rset = stmt.executeQuery(sql)) {
            while (rset.next()) {
                Obj_Alojamiento alojamiento = newAlojamiento(rset);
                
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
    public Obj_Alojamiento getById(int id) {
        String sql = "SELECT id, nombre FROM alojamiento WHERE id=?";
        Obj_Alojamiento alojamiento = null;
        
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
    public boolean update(Obj_Alojamiento alojamiento) {
        String sql = null;
        boolean result = false;
        
        if (alojamiento.getId() > 0) {
            sql = "UPDATE alojamiento SET nombre=? WHERE id=?";
        } else {
           sql = "INSERT INTO alojamiento (nombre) VALUES (?)";
        }
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            if (alojamiento.getId() > 0) {
                stmt.setInt(2, alojamiento.getId());
            }
            stmt.setString(1, alojamiento.getNombre());
            
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
        String sql = "DELETE FROM alojamiento WHERE id=?";
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
    
    
    private Obj_Alojamiento newAlojamiento(final ResultSet rset) throws SQLException {
        return new Obj_Alojamiento(rset.getInt("id"), rset.getString("nombre"));
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

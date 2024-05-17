package app.database;

import app.objects.Obj_Transporte;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DAO_Transporte implements DAO_Interface<Obj_Transporte> {

    @Override
    public List<Obj_Transporte> getAll() {
        String sql = "SELECT id, nombre FROM transporte";
        List<Obj_Transporte> transportes = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement(); ResultSet rset = stmt.executeQuery(sql)) {
            while (rset.next()) {
                Obj_Transporte transporte = newTransporte(rset);
                
                if (!transportes.add(transporte)) {
                    throw new Exception("[ERROR] No se ha podido obtener el objecto.");
                }
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return transportes;
    }

    
    @Override
    public Obj_Transporte getById(int id) {
        String sql = "SELECT id, nombre FROM transporte WHERE id=?";
        Obj_Transporte transporte = null;
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            
            try (ResultSet rset = stmt.executeQuery()) {
                if (rset.next()) {
                    transporte = newTransporte(rset);
                }
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        }

        return transporte;
    }

    
    @Override
    public boolean update(Obj_Transporte transporte) {
        String sql = null;
        boolean result = false;
        
        if (transporte.getId() > 0) {
            sql = "UPDATE transporte SET nombre=? WHERE id=?";
        } else {
           sql = "INSERT INTO transporte (nombre) VALUES (?)";
        }
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            if (transporte.getId() > 0) {
                stmt.setInt(2, transporte.getId());
            }
            stmt.setString(1, transporte.getNombre());
            
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
        String sql = "DELETE FROM transporte WHERE id=?";
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
    

    private Obj_Transporte newTransporte(final ResultSet rset) throws SQLException {
        return new Obj_Transporte(rset.getInt("id"), rset.getString("nombre"));
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

package app.database;

import app.objects.Obj_Transporte_Utilizado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DAO_Transporte_Utilizado implements DAO_Interface<Obj_Transporte_Utilizado> {

    @Override
    public List<Obj_Transporte_Utilizado> getAll() {
        String sql = "SELECT id, id_transporte, id_actividad FROM transporte_utilizado";
        List<Obj_Transporte_Utilizado> transportes = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement(); ResultSet rset = stmt.executeQuery(sql)) {
            while (rset.next()) {
                Obj_Transporte_Utilizado transporte = newTransporte(rset);
                
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
    public Obj_Transporte_Utilizado getById(int id) {
        String sql = "SELECT id, id_transporte, id_actividad FROM transporte_utilizado WHERE id=?";
        Obj_Transporte_Utilizado transporte = null;
        
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
    public boolean update(Obj_Transporte_Utilizado transporte) {
        String sql = null;
        boolean result = false;
        
        if (transporte.getId() > 0) {
            sql = "UPDATE transporte_utilizado SET id_transporte=?, id_actividad=? WHERE id=?";
        } else {
           sql = "INSERT INTO transporte_utilizado (id_transporte, id_actividad) VALUES (?, ?)";
        }
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            if (transporte.getId() > 0) {
                stmt.setInt(3, transporte.getId());
            }
            stmt.setInt(1, transporte.getTransporte().getId());
            stmt.setInt(2, transporte.getActividad().getId());
            
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
        String sql = "DELETE FROM transporte_utilizado WHERE id=?";
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
    
    
    private Obj_Transporte_Utilizado newTransporte(final ResultSet rset) throws SQLException {
        return new Obj_Transporte_Utilizado(rset.getInt("id"), rset.getInt("id_transporte"), rset.getInt("id_actividad"));
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

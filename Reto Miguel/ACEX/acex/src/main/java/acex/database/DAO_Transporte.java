package acex.database;

import acex.enums.T_Tipo;
import acex.objects.Transporte;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DAO_Transporte implements DAO_Interface<Transporte> {
    
    @Override
    public List<Transporte> getAll() {
        String sql = "SELECT id, id_actividad, tipo, importe, comentario FROM transporte";
        List<Transporte> transportes = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement(); ResultSet rset = stmt.executeQuery(sql)) {
            while (rset.next()) {
                Transporte transporte = getTransporte(rset);
                
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
    public Transporte getById(int id) {
        String sql = "SELECT id, id_actividad, tipo, importe, comentario FROM transporte WHERE id=?";
        Transporte transporte = null;
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            
            try (ResultSet rset = stmt.executeQuery()) {
                if (rset.next()) {
                    transporte = getTransporte(rset);
                }
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        }

        return transporte;
    }
    
    
    @Override
    public boolean update(Transporte transporte) {
        String sql = null;
        boolean result = false;
        
        if (transporte.getId() > 0) {
            sql = "UPDATE transporte SET id_actividad=?, tipo=?, importe=?, comentario=? WHERE id=?";
        } else {
           sql = "INSERT INTO transporte (id_actividad, tipo, importe, comentario) VALUES (?, ?, ?, ?)";
        }
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, transporte.getIdActividad());
            stmt.setString(2, String.valueOf(transporte.getTipo()));
            stmt.setDouble(3, transporte.getImporte());
            stmt.setString(4, transporte.getComentario());
            stmt.setInt(5, transporte.getId());
            
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
    public boolean delete(Transporte transporte) {
        String sql = "DELETE FROM transporte WHERE id=?";
        boolean result = false;
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, transporte.getId());
            
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

    
    private Transporte getTransporte(ResultSet rset) throws SQLException {
        return new Transporte(rset.getInt("id"), rset.getInt("id_actividad"), T_Tipo.valueOf(rset.getString("tipo")), rset.getDouble("importe"), rset.getString("comentario"));
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

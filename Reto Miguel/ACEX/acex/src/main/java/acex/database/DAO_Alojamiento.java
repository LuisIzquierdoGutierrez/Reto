package acex.database;

import acex.objects.Alojamiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DAO_Alojamiento implements DAO_Interface<Alojamiento> {
    
    @Override
    public List<Alojamiento> getAll() {
        String sql = "SELECT id, id_actividad, nombre, importe, comentario FROM alojamiento";
        List<Alojamiento> alojamientos = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement(); ResultSet rset = stmt.executeQuery(sql)) {
            while (rset.next()) {
                Alojamiento alojamiento = getAlojamiento(rset);
                
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
    public Alojamiento getById(int id) {
        String sql = "SELECT id, id_actividad, nombre, importe, comentario FROM alojamiento WHERE id=?";
        Alojamiento alojamiento = null;
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            
            try (ResultSet rset = stmt.executeQuery()) {
                if (rset.next()) {
                    alojamiento = getAlojamiento(rset);
                }
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        }

        return alojamiento;
    }
    
    
    @Override
    public boolean update(Alojamiento alojamiento) {
        String sql = null;
        boolean result = false;
        
        if (alojamiento.getId() > 0) {
            sql = "UPDATE alojamiento SET id_actividad=?, nombre=?, importe=?, comentario=? WHERE id=?";
        } else {
           sql = "INSERT INTO alojamiento (id_actividad, nombre, importe, comentario) VALUES (?, ?, ?, ?)";
        }
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, alojamiento.getIdActividad());
            stmt.setString(2, alojamiento.getNombre());
            stmt.setDouble(3, alojamiento.getImporte());
            stmt.setString(4, alojamiento.getComentario());
            stmt.setInt(5, alojamiento.getId());
            
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
    public boolean delete(Alojamiento alojamiento) {
        String sql = "DELETE FROM alojamiento WHERE id=?";
        boolean result = false;
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, alojamiento.getId());
            
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
    
    
    private Alojamiento getAlojamiento(ResultSet rset) throws SQLException {
        return new Alojamiento(rset.getInt("id"), rset.getInt("id_actividad"), rset.getString("nombre"), rset.getDouble("importe"), rset.getString("comentario"));
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

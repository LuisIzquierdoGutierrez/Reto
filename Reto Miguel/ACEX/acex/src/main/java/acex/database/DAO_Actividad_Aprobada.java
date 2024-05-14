package acex.database;

import acex.enums.A_Estado;
import acex.enums.A_Tipo;
import acex.objects.Actividad_Aprobada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class DAO_Actividad_Aprobada implements DAO_Interface<Actividad_Aprobada> {

    @Override
    public List<Actividad_Aprobada> getAll() {
        String sql = "SELECT id, id_solicitante, titulo, comentario_actividad, tipo, prevista, estado, comentario_estado, transporte, alojamiento, inicio, fin FROM actividad_aprobada";
        List<Actividad_Aprobada> actividades = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement(); ResultSet rset = stmt.executeQuery(sql)) {
            while (rset.next()) {
                Actividad_Aprobada actividad = getActividad(rset);
                
                if (!actividades.add(actividad)) {
                    throw new Exception("[ERROR] No se ha podido obtener el objecto.");
                }
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return actividades;
    }
    
    
    @Override
    public Actividad_Aprobada getById(int id) {
        String sql = "SELECT id, id_solicitante, titulo, comentario_actividad, tipo, prevista, estado, comentario_estado, transporte, alojamiento, inicio, fin FROM actividad_aprobada WHERE id=?";
        Actividad_Aprobada actividad = null;
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            
            try (ResultSet rset = stmt.executeQuery()) {
                if (rset.next()) {
                    actividad = getActividad(rset);
                }
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        }

        return actividad;
    }
    
    
    @Override
    public boolean update(Actividad_Aprobada actividad) {
        String sql = null;
        boolean result = false;
        
        if (actividad.getId() > 0) {
            sql = "UPDATE actividad_aprobada SET id_solicitante=?, titulo=?, comentario_actividad=?, tipo=?, prevista=?, estado=?, comentario_estado=?, transporte=?, alojamiento=?, inicio=?, fin=? WHERE id=?";
        } else {
            sql = "INSERT INTO actividad_aprobada (id_solicitante, titulo, comentario_actividad, tipo, prevista, estado, comentario_estado, transporte, alojamiento, inicio, fin) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        }
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, actividad.getIdSolicitante());
            stmt.setString(2, actividad.getTitulo());
            stmt.setString(3, actividad.getComentarioActividad());
            stmt.setString(4, String.valueOf(actividad.getTipo()));
            stmt.setBoolean(5, actividad.isPrevista());
            stmt.setString(6, String.valueOf(actividad.getEstado()));
            stmt.setString(7, actividad.getComentarioEstado());
            stmt.setBoolean(8, actividad.isTransporte());
            stmt.setBoolean(9, actividad.isAlojamiento());
            stmt.setTimestamp(10, Timestamp.valueOf(actividad.getInicio()));
            stmt.setTimestamp(11, Timestamp.valueOf(actividad.getFin()));
            stmt.setInt(12, actividad.getId());
            
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
    public boolean delete(Actividad_Aprobada actividad) {
        String sql = "DELETE FROM actividad_aprobada WHERE id=?";
        boolean result = false;
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, actividad.getId());
            
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
    
    
    private Actividad_Aprobada getActividad(ResultSet rset) throws SQLException {
        return new Actividad_Aprobada(rset.getInt("id"), rset.getInt("id_solicitante"), rset.getString("titulo"), rset.getString("comentario_actividad"), A_Tipo.valueOf(rset.getString("tipo")), rset.getBoolean("prevista"), A_Estado.valueOf(rset.getString("estado")), rset.getString("comentario_estado"), rset.getBoolean("transporte"), rset.getBoolean("alojamiento"), rset.getTimestamp("inicio").toLocalDateTime(), rset.getTimestamp("fin").toLocalDateTime());
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

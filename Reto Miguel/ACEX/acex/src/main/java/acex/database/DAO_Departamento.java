package acex.database;

import acex.objects.Departamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DAO_Departamento implements DAO_Interface<Departamento> {
    
    @Override
    public List<Departamento> getAll() {
        String sql = "SELECT id, id_jefe, codigo, nombre FROM departamento";
        List<Departamento> departamentos = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement(); ResultSet rset = stmt.executeQuery(sql)) {
            while (rset.next()) {
                Departamento departamento = getDepartamento(rset);
                
                if (!departamentos.add(departamento)) {
                    throw new Exception("[ERROR] No se ha podido obtener el objecto.");
                }
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return departamentos;
    }
    
    
    @Override
    public Departamento getById(int id) {
        String sql = "SELECT id, id_jefe, codigo, nombre FROM departamento WHERE id=?";
        Departamento departamento = null;
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            
            try (ResultSet rset = stmt.executeQuery()) {
                if (rset.next()) {
                    departamento = getDepartamento(rset);
                }
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        }

        return departamento;
    }
    
    
    @Override
    public boolean update(Departamento departamento) {
        String sql = null;
        boolean result = false;
        
        if (departamento.getId() > 0) {
            sql = "UPDATE departamento SET id_jefe=?, codigo=?, nombre=? WHERE id=?";
        } else {
           sql = "INSERT INTO departamento (id_jefe, codigo, nombre) VALUES (?, ?, ?)";
        }
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, departamento.getIdJefe());
            stmt.setString(2, departamento.getCodigo());
            stmt.setString(3, departamento.getNombre());
            stmt.setInt(4, departamento.getId());
            
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
    public boolean delete(Departamento departamento) {
        String sql = "DELETE FROM departamento WHERE id=?";
        boolean result = false;
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, departamento.getId());
            
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
    
    
    private Departamento getDepartamento(ResultSet rset) throws SQLException {
        return new Departamento(rset.getInt("id"), rset.getInt("id_jefe"), rset.getString("codigo"), rset.getString("nombre"));
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

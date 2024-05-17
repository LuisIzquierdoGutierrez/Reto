package app.database;

import app.objects.Obj_Departamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DAO_Departamento implements DAO_Interface<Obj_Departamento> {

    @Override
    public List<Obj_Departamento> getAll() {
        String sql = "SELECT id, id_jefe, codigo, nombre FROM departamento";
        List<Obj_Departamento> departamentos = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement(); ResultSet rset = stmt.executeQuery(sql)) {
            while (rset.next()) {
                Obj_Departamento departamento = newDepartamento(rset);
                
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
    public Obj_Departamento getById(int id) {
        String sql = "SELECT id, id_jefe, codigo, nombre FROM departamento WHERE id=?";
        Obj_Departamento departamento = null;
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            
            try (ResultSet rset = stmt.executeQuery()) {
                if (rset.next()) {
                    departamento = newDepartamento(rset);
                }
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        }

        return departamento;
    }

    
    @Override
    public boolean update(Obj_Departamento departamento) {
        String sql = null;
        boolean result = false;
        
        if (departamento.getId() > 0) {
            sql = "UPDATE departamento SET id_jefe=?, codigo=?, nombre=? WHERE id=?";
        } else {
           sql = "INSERT INTO departamento (id_jefe, codigo, nombre) VALUES (?, ?, ?)";
        }
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            if (departamento.getId() > 0) {
                stmt.setInt(4, departamento.getId());
            }
            stmt.setInt(1, departamento.getJefe().getId());
            stmt.setString(2, departamento.getCodigo());
            stmt.setString(3, departamento.getNombre());
            
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
        String sql = "DELETE FROM departamento WHERE id=?";
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
    

    private Obj_Departamento newDepartamento(final ResultSet rset) throws SQLException {
        return new Obj_Departamento(rset.getInt("id"), rset.getInt("id_jefe"), rset.getString("codigo"), rset.getString("nombre"));
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

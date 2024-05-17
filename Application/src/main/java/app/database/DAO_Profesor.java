package app.database;

import app.enums.Enum_Perfil;
import app.objects.Obj_Profesor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DAO_Profesor implements DAO_Interface<Obj_Profesor> {
    
    @Override
    public List<Obj_Profesor> getAll() {
        String sql = "SELECT id, id_departamento, dni, nombre, apellidos, email, password, perfil, activo FROM profesor";
        List<Obj_Profesor> profesores = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement(); ResultSet rset = stmt.executeQuery(sql)) {
            while (rset.next()) {
                Obj_Profesor profesor = newProfesor(rset);
                
                if (!profesores.add(profesor)) {
                    throw new Exception("[ERROR] No se ha podido obtener el objecto.");
                }
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return profesores;
    }

    
    @Override
    public Obj_Profesor getById(int id) {
        String sql = "SELECT id, id_departamento, dni, nombre, apellidos, email, password, perfil, activo FROM profesor WHERE id=?";
        Obj_Profesor profesor = null;
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            
            try (ResultSet rset = stmt.executeQuery()) {
                if (rset.next()) {
                    profesor = newProfesor(rset);
                }
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        }

        return profesor;
    }

    
    @Override
    public boolean update(Obj_Profesor profesor) {
        String sql = null;
        boolean result = false;
        
        if (profesor.getId() > 0) {
            sql = "UPDATE profesor SET id_departamento=?, dni=?, nombre=?, apellidos=?, email=?, password=?, perfil=?, activo=? WHERE id=?";
        } else {
           sql = "INSERT INTO profesor (id_departamento, dni, nombre, apellidos, email, password, perfil, activo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        }
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            if (profesor.getId() > 0) {
                stmt.setInt(9, profesor.getId());
            }
            stmt.setInt(1, profesor.getDepartamento().getId());
            stmt.setString(2, profesor.getDni());
            stmt.setString(3, profesor.getNombre());
            stmt.setString(4, profesor.getApellidos());
            stmt.setString(5, profesor.getEmail());
            stmt.setString(6, profesor.getPassword());
            stmt.setString(7, String.valueOf(profesor.getPerfil()));
            stmt.setBoolean(8, profesor.isActivo());
            
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
        String sql = "DELETE FROM profesor WHERE id=?";
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
    

    private Obj_Profesor newProfesor(final ResultSet rset) throws SQLException {
        return new Obj_Profesor(rset.getInt("id"), rset.getInt("id_departamento"), rset.getString("dni"), rset.getString("nombre"), rset.getString("apellidos"), rset.getString("email"), rset.getString("password"), Enum_Perfil.valueOf(rset.getString("perfil")), rset.getBoolean("activo"));
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
package acex.database;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import acex.enums.P_Perfil;
import acex.objects.Profesor;


public class DAO_Profesor implements DAO_Interface<Profesor> {

    @Override
    public List<Profesor> getAll() {
        String sql = "SELECT id, id_departamento, dni, nombre, apellidos, email, password, perfil, activo FROM profesor";
        List<Profesor> profesores = new ArrayList<>();
        
        try {
            Statement stmt = getConnection().createStatement();
            ResultSet rset = stmt.executeQuery(sql);
            
            while (rset.next()) {
                Profesor profesor = getProfesor(rset);
                if (!profesores.add(profesor)) {
                    throw new Exception("[ERROR] No se ha podido insertar el objecto.");
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
    public Profesor getById(int id) {
        String sql = "SELECT id, id_departamento, dni, nombre, apellidos, email, password, perfil, activo FROM profesor WHERE id=?";
        Profesor profesor = null;
        
        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rset = stmt.executeQuery();
            
            if (rset.next()) {
                profesor = getProfesor(rset);
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        }
        
        return profesor;
    }

    
    @Override
    public boolean update(Profesor profesor) {
        String sql = null;
        boolean result = false;
        
        if (profesor.getId()> 0) {
            sql = "UPDATE profesor SET id_departamento=?, dni=?, nombre=?, apellidos=?, email=?, password=?, perfil=?, activo=? WHERE id=?";
        } else {
            sql = "INSERT INTO profesor (id, id_departamento, dni, nombre, apellidos, email, password, perfil, activo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        }
        
        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            stmt.setInt(1, profesor.getIdDepartamento());
            stmt.setString(2, profesor.getDni());
            stmt.setString(3, profesor.getNombre());
            stmt.setString(4, profesor.getApellidos());
            stmt.setString(5, profesor.getEmail());
            stmt.setString(6, profesor.getPassword());
            stmt.setString(7, String.valueOf(profesor.getPerfil()));
            stmt.setBoolean(8, profesor.isActivo());
            stmt.setInt(9, profesor.getId());
            
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
        System.out.println("[ERROR] No se ha podido eliminar el objecto.");
        return false;
    }
    

    private Profesor getProfesor(ResultSet rset) throws SQLException {
        return new Profesor(rset.getInt("id"), rset.getInt("id_departamento"), rset.getString("dni"), rset.getString("nombre"), rset.getString("apellidos"), rset.getString("email"), rset.getString("password"), P_Perfil.valueOf(rset.getString("perfil")), rset.getBoolean("activo"));
    }

    
    private Connection getConnection() {
        return Access.getInstance().getConnection();
    }
    
    
    private void handleSQLException(SQLException ex) {
        System.out.println("Error Code: " + ex.getErrorCode());
        System.out.println("Error Message: " + ex.getMessage());
        System.out.println("SQL State: " + ex.getSQLState());
    }
}

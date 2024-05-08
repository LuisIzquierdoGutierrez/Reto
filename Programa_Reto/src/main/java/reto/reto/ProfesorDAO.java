/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto.reto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DAM126
 */
public class ProfesorDAO implements Repositorio<Profesor> {

    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    @Override
    public List<Profesor> consultar() {
        List<Profesor> solicitudes = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement(); ResultSet rs = stmt.executeQuery("SELECT id,id_departamento,dni,nombre,apellidos,email,password,perfil,activo  FROM profesor");) {
            while (rs.next()) {
                Profesor solicitud = crearProfesor(rs);
                if (!solicitudes.add(solicitud)) {
                    throw new Exception("error no se ha insertado el objeto en la colección");
                }
            }
        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return solicitudes;
    }

    @Override
    public boolean guardar(Profesor profesor) {
        String sql = null;
        boolean resultado = false;
        if (profesor.getId_profesor() > 0) {
            sql = "UPDATE profesor SET id_departamento=?,dni=?,nombre=?,apellidos=?,email=?,password=?,perfil=?,activo=?WHERE id=?";
        } // son 12 ?
        else {
            sql = "INSERT INTO profesor(id_departamento,dni,nombre,apellidos,email,password,perfil,activo,id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        }
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            stmt.setInt(9, profesor.getId_profesor());

            stmt.setInt(1, profesor.getId_departamento());
            stmt.setString(2, profesor.getDNI());
            stmt.setString(3, profesor.getNombreProfesor());
            stmt.setString(4, profesor.getApellidos());
            stmt.setString(5, profesor.getCorreo());
            stmt.setString(6, profesor.getPassword());
            stmt.setString(7, String.valueOf(profesor.getTipo_perfil()));
            stmt.setBoolean(8, profesor.isProfesorActivo());

            int salida = stmt.executeUpdate();
            if (salida != 1) {
                throw new Exception(" No se ha insertado/modificado un solo registro");
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }

    @Override
    public Profesor porId(int id) {
        Profesor profesor = null;
        String sql = "SELECT id,id_departamento,dni,nombre,apellidos,email,password,perfil,activo FROM profesor WHERE id=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    profesor = crearProfesor(rs);
                }
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        }
        return profesor;
    }

    @Override
    public boolean eliminar(int id) {
        boolean resultado = false;
        String sql = "DELETE FROM profesor WHERE id=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id);
            int salida = stmt.executeUpdate();
            if (salida != 1) {
                throw new Exception(" No se ha borrado un solo registro");
            }
        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }

    private Profesor crearProfesor(ResultSet rs) throws SQLException {
        return new Profesor(rs.getInt("id"), rs.getInt("id_departamento"), rs.getString("dni"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("email"), rs.getString("password"), Perfil.valueOf(rs.getString("perfil")), rs.getBoolean("activo"));
    }
}

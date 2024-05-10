/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acex.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import acex.enums.Tipo_Perfil;
import acex.objects.Profesor;

/**
 * Esta clase implementa la interfaz Patron_DAO y proporciona métodos para acceder a la tabla "profesor" en la base de datos.
 * @author Luis
 * @param <Profesor> el tipo de objeto Profesor que se va a manejar en la base de datos.
 * @see Patron_DAO
 */
public class DAO_Profesor implements Patron_DAO<Profesor> {
     /**
     * Obtiene la conexión a la base de datos.
     * 
     * @return la conexión a la base de datos.
     */

    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }
     /**
     * Consulta todos los registros de la tabla "profesor" en la base de datos.
     * 
     * @return una lista de objetos Profesor que representan los registros de la tabla "profesor".
     * @throws SQLException si ocurre un error al ejecutar la consulta SQL.
     * @throws Exception si ocurre un error al insertar el objeto en la colección.
     */

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
    /**
     * Guarda un objeto Profesor en la base de datos.
     * 
     * @param profesor el objeto Profesor que se va a save.
     * @return true si el objeto se guarda correctamente, false de lo contrario.
     * @throws SQLException si ocurre un error al ejecutar la consulta SQL.
     * @throws Exception si ocurre un error al insertar/modificar el registro en la base de datos.
     */

    @Override
    public boolean save(Profesor profesor) {
        String sql = null;
        boolean resultado = true;
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
                resultado = false;
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
     /**
     * Obtiene un objeto Profesor de la base de datos por su ID.
     * 
     * @param id el ID del profesor.
     * @return el objeto Profesor correspondiente al ID especificado, o null si no se encuentra ningún registro.
     * @throws SQLException si ocurre un error al ejecutar la consulta SQL.
     */

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
     /**
     * Elimina un registro de la base de datos por su ID.
     * 
     * @param id el ID del profesor que se va a eliminar.
     * @return true si el registro se elimina correctamente, false de lo contrario.
     * @throws SQLException si ocurre un error al ejecutar la consulta SQL.
     * @throws Exception si ocurre un error al eliminar el registro de la base de datos.
     */

    @Override
    public boolean eliminar(int id) {
        boolean resultado = true;
        String sql = "DELETE FROM profesor WHERE id=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id);
            int salida = stmt.executeUpdate();
            if (salida != 1) {
                resultado = false;
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
    /**
     * Crea un objeto Profesor a partir de un ResultSet.
     * 
     * @param rs el ResultSet que contiene los datos del profesor.
     * @return el objeto Profesor creado.
     * @throws SQLException si ocurre un error al acceder a los datos del ResultSet.
     */

    private Profesor crearProfesor(ResultSet rs) throws SQLException {
        return new Profesor(rs.getInt("id"), rs.getInt("id_departamento"), rs.getString("dni"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("email"), rs.getString("password"), Tipo_Perfil.valueOf(rs.getString("perfil")), rs.getBoolean("activo"));
    }
}

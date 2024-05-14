/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acex.database;

import acex.database.AccesoBaseDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import acex.objects.Transporte;

/**
 * Esta clase implementa la interfaz DAO_Patron y proporciona métodos para acceder a la base de datos y realizar operaciones CRUD en la tabla "transporte_utilizado".
 * @author Luis
 * @see DAO_Patron
 */
public class DAO_Transporte implements DAO_Patron<Transporte> {
    
     /**
     * Obtiene la conexión a la base de datos.
     * 
     * @return La conexión a la base de datos.
     */

    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }
    
     /**
     * Consulta todos los registros de la tabla "transporte_utilizado".
     * 
     * @return Una lista de objetos Transporte que representan los registros de la tabla.
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
     */
    
    

    @Override
    public List<Transporte> consultar() {
        List<Transporte> Transportes = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement(); ResultSet rs = stmt.executeQuery("SELECT id,tipo,importe,comentario FROM transporte_utilizado");) {
            while (rs.next()) {
                Transporte transporte = crearTransporte(rs);
                if (!Transportes.add(transporte)) {
                    throw new Exception("error no se ha insertado el objeto en la colección");
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return Transportes;
    }
    /**
     * Guarda un objeto Transporte en la tabla "transporte_utilizado".
     * Si el objeto ya tiene un ID asignado, se realiza una actualización en la base de datos.
     * Si el objeto no tiene un ID asignado, se realiza una inserción en la base de datos.
     * 
     * @param transporte El objeto Transporte a save.
     * @return true si la operación de guardado fue exitosa, false de lo contrario.
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
     * @throws Exception Si ocurre un error al insertar o actualizar el objeto en la base de datos.
     */

    @Override
    public boolean save(Transporte transporte) {
        String sql = null;
        boolean resultado = true;
        if (transporte.getIdTransporte() > 0) {
            sql = "UPDATE transporte_utilizado SET id_actividad=?, id_transporte=?, importe=? WHERE id=?";
        } else {
            String query = "INSERT INTO transporte_utilizado (id_actividad,id_transporte,importe, id) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = getConnection().prepareStatement(query)) {
                if (transporte.getIdTransporte() > 0) {
                    stmt.setInt(4, transporte.getIdTransporte());
                }
                stmt.setInt(1, transporte.getActividad().getIdSolicitudes());
                stmt.setInt(2, transporte.getTransporte().getId_tipo_transporte());
                stmt.setDouble(3, transporte.getImporte());
                int salida = stmt.executeUpdate();
                if (salida != 1) {
                    resultado = false;
                    throw new Exception(" No se ha borrado un solo registro");
                }
            } catch (SQLException e) {
                System.out.println("SQLException: " + e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return resultado;
    }
    /**
     * Obtiene un objeto Transporte de la tabla "transporte_utilizado" por su ID.
     * 
     * @param id El ID del objeto Transporte a obtener.
     * @return El objeto Transporte correspondiente al ID especificado, o null si no se encuentra.
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
     */

    @Override
    public Transporte porId(int id) {
        Transporte transporte = null;
        String sql = "SELECT id,id_actividad,id_transporte,importe FROM transporte_utilizado WHERE id=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    transporte = crearTransporte(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return transporte;
    }
     /**
     * Elimina un objeto Transporte de la tabla "transporte_utilizado" por su ID.
     * 
     * @param id El ID del objeto Transporte a eliminar.
     * @return true si la operación de eliminación fue exitosa, false de lo contrario.
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
     * @throws Exception Si ocurre un error al eliminar el objeto de la base de datos.
     */

    @Override
    public boolean eliminar(int id) {
        boolean resultado = true;
        String sql = "DELETE FROM transporte_utilizado WHERE id=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            int salida = stmt.executeUpdate();
            if (salida != 1) {
                resultado = false;
                throw new Exception(" No se ha borrado un solo registro");
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }
    /**
     * Crea un objeto Transporte a partir de un ResultSet.
     * 
     * @param rs El ResultSet que contiene los datos del objeto Transporte.
     * @return El objeto Transporte creado.
     * @throws SQLException Si ocurre un error al acceder a los datos del ResultSet.
     */

    private Transporte crearTransporte(ResultSet rs) throws SQLException {
        return new Transporte(rs.getInt("id"), rs.getInt("id_actividad"), rs.getInt("id_transporte"), rs.getDouble("importe"));
    }
}

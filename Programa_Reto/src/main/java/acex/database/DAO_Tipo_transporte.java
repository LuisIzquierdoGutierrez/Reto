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
import acex.enums.Tipo_Transporte;

/**
 * Esta clase implementa la interfaz Patron_DAO y se encarga de realizar operaciones en la tabla "transporte" de la base de datos.
 * @author Saul
 * @param <Tipo_transporte> El tipo de objeto que se va a almacenar en la base de datos.
 * @see Patron_DAO
 */
public class DAO_Tipo_transporte implements Patron_DAO<Tipo_Transporte> {
    
      /**
     * Obtiene la conexión a la base de datos.
     * @return La conexión a la base de datos.
     */

    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }
   
    
     /**
     * Consulta todos los registros de la tabla "transporte" y los devuelve como una lista de objetos Tipo_Transporte.
     * @return Una lista de objetos Tipo_Transporte.
     */

    @Override
    public List<Tipo_Transporte> consultar() {
        List<Tipo_Transporte> Transportes = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement(); ResultSet rs = stmt.executeQuery("SELECT id,tipo,importe,comentario FROM transporte");) {
            while (rs.next()) {
                Tipo_Transporte transporte = crearTipo_transporte(rs);
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
     * Guarda un objeto Tipo_Transporte en la base de datos.
     * @param transporte El objeto Tipo_Transporte que se va a save.
     * @return true si el objeto se guarda correctamente, false en caso contrario.
     * @throws Exception Si ocurre un error al save el objeto.
     */

    @Override
    public boolean save(Tipo_Transporte transporte) {
        String sql = null;
        boolean resultado = true;
        if (transporte.getId_tipo_transporte() > 0) {
            sql = "UPDATE transporte SET nombre=?, comentario=? WHERE id=?";
        } else {
            String query = "INSERT INTO transporte (nombre, comentario, id) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = getConnection().prepareStatement(query)) {
                if (transporte.getId_tipo_transporte() > 0) {
                    stmt.setInt(3, transporte.getId_tipo_transporte());
                }
                stmt.setString(1, transporte.getTipo());
                stmt.setString(2, transporte.getComentario());
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
     * Obtiene un objeto Tipo_Transporte de la base de datos por su ID.
     * @param id El ID del objeto Tipo_Transporte.
     * @return El objeto Tipo_Transporte correspondiente al ID especificado, o null si no se encuentra.
     */

    @Override
    public Tipo_Transporte porId(int id) {
        Tipo_Transporte transporte = null;
        String sql = "SELECT id,nombre,comentario FROM transporte WHERE id=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    transporte = crearTipo_transporte(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return transporte;
    }
     /**
     * Elimina un objeto Tipo_Transporte de la base de datos por su ID.
     * @param id El ID del objeto Tipo_Transporte que se va a eliminar.
     * @return true si el objeto se elimina correctamente, false en caso contrario.
     * @throws Exception Si ocurre un error al eliminar el objeto.
     */

    @Override
    public boolean eliminar(int id) {
        boolean resultado = true;
        String sql = "DELETE FROM transporte WHERE id=?";
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
     * Crea un objeto Tipo_Transporte a partir de un ResultSet.
     * @param rs El ResultSet que contiene los datos del objeto Tipo_Transporte.
     * @return El objeto Tipo_Transporte creado.
     * @throws SQLException Si ocurre un error al acceder a los datos del ResultSet.
     */

    private Tipo_Transporte crearTipo_transporte(ResultSet rs) throws SQLException {
        return new Tipo_Transporte(rs.getInt("id_Transporte"), rs.getString("nombre"), rs.getString("comentario"));
    }
}

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
 * Esta clase implementa la interfaz Repositorio y se encarga de realizar operaciones en la tabla "transporte" de la base de datos.
 * @author Saul
 * @param <Tipo_transporte> El tipo de objeto que se va a almacenar en la base de datos.
 * @see Repositorio
 */
public class Tipo_transporteDAO implements Repositorio<Tipo_transporte> {
    
      /**
     * Obtiene la conexión a la base de datos.
     * @return La conexión a la base de datos.
     */

    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }
   
    
     /**
     * Consulta todos los registros de la tabla "transporte" y los devuelve como una lista de objetos Tipo_transporte.
     * @return Una lista de objetos Tipo_transporte.
     */

    @Override
    public List<Tipo_transporte> consultar() {
        List<Tipo_transporte> Transportes = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement(); ResultSet rs = stmt.executeQuery("SELECT id,tipo,importe,comentario FROM transporte");) {
            while (rs.next()) {
                Tipo_transporte transporte = crearTipo_transporte(rs);
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
     * Guarda un objeto Tipo_transporte en la base de datos.
     * @param transporte El objeto Tipo_transporte que se va a guardar.
     * @return true si el objeto se guarda correctamente, false en caso contrario.
     * @throws Exception Si ocurre un error al guardar el objeto.
     */

    @Override
    public boolean guardar(Tipo_transporte transporte) {
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
     * Obtiene un objeto Tipo_transporte de la base de datos por su ID.
     * @param id El ID del objeto Tipo_transporte.
     * @return El objeto Tipo_transporte correspondiente al ID especificado, o null si no se encuentra.
     */

    @Override
    public Tipo_transporte porId(int id) {
        Tipo_transporte transporte = null;
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
     * Elimina un objeto Tipo_transporte de la base de datos por su ID.
     * @param id El ID del objeto Tipo_transporte que se va a eliminar.
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
     * Crea un objeto Tipo_transporte a partir de un ResultSet.
     * @param rs El ResultSet que contiene los datos del objeto Tipo_transporte.
     * @return El objeto Tipo_transporte creado.
     * @throws SQLException Si ocurre un error al acceder a los datos del ResultSet.
     */

    private Tipo_transporte crearTipo_transporte(ResultSet rs) throws SQLException {
        return new Tipo_transporte(rs.getInt("id_Transporte"), rs.getString("nombre"), rs.getString("comentario"));
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acex.database;

import acex.database.AccesoBaseDatos;
import acex.objects.ACEX_Aprobadas;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import acex.enums.Tipo_Actividad;
import acex.enums.Tipo_Estado;

/**
 *Esta clase implementa la interfaz Patron_DAO y se encarga de realizar operaciones CRUD en la tabla actividad_aprobada de la base de datos.
 * @author Adrian
 * @param <ACEX_Aprobadas> El tipo de objeto ACEX_Aprobadas que se va a manejar en el repositorio.
 * @see Patron_DAO
 */
public class DAO_ACEXAprobadas implements Patron_DAO<ACEX_Aprobadas> {

    
     /**
     * Obtiene la conexión a la base de datos.
     * @return La conexión a la base de datos.
     */
    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }
    
    /**
     * Consulta todas las actividades aprobadas.
     * @return Una lista de objetos ACEX_Aprobadas que representan las actividades aprobadas.
     * @throws SQLException Si ocurre un error al consultar las actividades.
     */

    @Override
    public List<ACEX_Aprobadas> consultar() {
        List<ACEX_Aprobadas> aprobadas = new ArrayList<>();
        String query = "SELECT * FROM actividad_aprobada";
        try (PreparedStatement stmt = getConnection().prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                aprobadas.add(creaACEX(rs));
            }
        } catch (SQLException ex) {
            System.out.println("Error al consultar actividades: " + ex.getMessage());
        }
        return aprobadas;
    }
    /**
     * Guarda una actividad aprobada en la base de datos.
     * @param aprobada La actividad aprobada que se va a save.
     * @return true si la operación de guardado fue exitosa, false de lo contrario.
     * @throws SQLException Si ocurre un error al save la actividad.
     * @throws Exception Si no se ha insertado/modificado un solo registro.
     */

    @Override
    public boolean save(ACEX_Aprobadas aprobada) {
        String sql = null;
        boolean resultado = true;
        if (aprobada.getIdAprobadas()> 0) {
            sql = "UPDATE actividad_aprobada SET id_solicitante=?,titulo=?,comentario_actividad=?,tipo=?,prevista=?,,estado=?,comentario_estado=?,transporte=?,alojamiento=?,hora_inicio=?,hora_fin=?,fecha_inicio=?,fecha_fin=? WHERE id=?";
        } else {
            sql = "INSERT INTO actividad_aprobada (id_solicitante, titulo, comentario_actividad, tipo, prevista, estado, comentario_estado, transporte, alojamiento, hora_inicio, hora_fin, fecha_inicio, fecha_fin) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        }
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            if (aprobada.getIdAprobadas() > 0) {
                stmt.setInt(14, aprobada.getSolicitante().getId_profesor());
            }

            stmt.setInt(1, aprobada.getSolicitante().getId_profesor());
            stmt.setString(2, aprobada.getTitulo());
            stmt.setString(3, aprobada.getComentario_actividad());
            stmt.setString(4, aprobada.getTipo().toString());
            stmt.setBoolean(5, aprobada.isProgramada());
            stmt.setString(6, aprobada.getEstado().toString());
            stmt.setString(7, aprobada.getComentario_estado());
            stmt.setBoolean(8, aprobada.isTransporte());
            stmt.setBoolean(9, aprobada.isAlojamiento());
            stmt.setTime(10, Time.valueOf(aprobada.getHora_inicio()));
            stmt.setTime(11, Time.valueOf(aprobada.getHora_fin()));
            stmt.setDate(12, Date.valueOf(aprobada.getFecha_inicio()));
            stmt.setDate(13, Date.valueOf(aprobada.getFecha_fin()));
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
     * Obtiene una actividad aprobada por su ID.
     * @param id El ID de la actividad aprobada.
     * @return La actividad aprobada correspondiente al ID especificado, o null si no se encuentra.
     * @throws SQLException Si ocurre un error al obtener la actividad.
     */

    @Override
    public ACEX_Aprobadas porId(int id
    ) {
        ACEX_Aprobadas aprobada = null;
        String sql = "SELECT id,id_solicitante,tipo,prevista,alojamiento,titulo,hora_inicio,hora_fin,fecha_inicio,fecha_fin,transporte,comentario_estado,comentario_actividad FROM actividad_aprobada WHERE id=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    aprobada = creaACEX(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return aprobada;
    }
    /**
     * Elimina una actividad aprobada por su ID.
     * @param id El ID de la actividad aprobada que se va a eliminar.
     * @return true si la operación de eliminación fue exitosa, false de lo contrario.
     * @throws SQLException Si ocurre un error al eliminar la actividad.
     * @throws Exception Si no se ha borrado un solo registro.
     */

    @Override
    public boolean eliminar(int id
    ) {
        boolean resultado = true;
        String sql = "DELETE FROM actividad_aprobada WHERE id=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id);
            int salida = stmt.executeUpdate();
            if (salida != 1) {
                resultado = false;
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

    private ACEX_Aprobadas creaACEX(final ResultSet rs) throws SQLException {
        return new ACEX_Aprobadas(rs.getInt("id"), rs.getInt("id_solicitante"), rs.getString("titulo"), rs.getString("comenatario_actividad"), Tipo_Actividad.valueOf(rs.getString("tipo")), rs.getBoolean("prevista"), Tipo_Estado.valueOf(rs.getString("estado")), rs.getString("comentario_estado"), rs.getBoolean("transporte"), rs.getBoolean("alojamiento"), rs.getTime("hora_inicio").toLocalTime(), rs.getTime("hora_fin").toLocalTime(), rs.getDate("fecha_inicio").toLocalDate(), rs.getDate("fecha_fin").toLocalDate());
    }
}

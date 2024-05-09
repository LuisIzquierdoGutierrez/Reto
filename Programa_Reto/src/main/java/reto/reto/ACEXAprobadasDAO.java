/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto.reto;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DAM103
 */
public class ACEXAprobadasDAO implements Repositorio<ACEX_Aprobadas> {

    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConnection();
    }

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

    @Override
    public boolean guardar(ACEX_Aprobadas aprobada) {
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
        return new ACEX_Aprobadas(rs.getInt("id"), rs.getInt("id_solicitante"), rs.getString("titulo"), rs.getString("comenatario_actividad"), TipoActividad.valueOf(rs.getString("tipo")), rs.getBoolean("prevista"), TipoEstado.valueOf(rs.getString("estado")), rs.getString("comentario_estado"), rs.getBoolean("transporte"), rs.getBoolean("alojamiento"), rs.getTime("hora_inicio").toLocalTime(), rs.getTime("hora_fin").toLocalTime(), rs.getDate("fecha_inicio").toLocalDate(), rs.getDate("fecha_fin").toLocalDate());
    }
}

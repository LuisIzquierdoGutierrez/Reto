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
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DAM103
 */
public class ACEXAprobadasDAO implements Repositorio<ACEX_aprobadas> {

    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConnection();
    }

    @Override
    public List<ACEX_aprobadas> consultar() {
        List<ACEX_aprobadas> aprobadas = new ArrayList<>();
        String query = "SELECT * FROM aprobadas";
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
    public boolean guardar(ACEX_aprobadas t) {
        String query = "INSERT INTO aprobadas (id_actividad,titulo, comentario_actividad, tipo, programada, estado, comentario_estado, transporte, alojamiento, fecha_inicio, fecha_fin, hora_inicio, hora_fin) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = getConnection().prepareStatement(query)) {
            stmt.setInt(1, t.getId_actividad());
            stmt.setString(3, t.getTitulo()); 
            
            stmt.setString(4, t.getTipo().toString());
            stmt.setBoolean(5, t.isProgramada());
            stmt.setString(6, t.getEstado().toString());
            stmt.setString(7, t.getComentario_estado());
            stmt.setBoolean(8, t.isTransporte());
            stmt.setBoolean(9, t.isAlojamiento());           
            stmt.setTime(8, Time.valueOf(t.getHora_inicio()));
            stmt.setTime(9, Time.valueOf(t.getHora_fin()));
            stmt.setDate(10, Date.valueOf(t.getFecha_inicio()));
            stmt.setDate(11, Date.valueOf(t.getFecha_fin()));
            
            stmt.setString(13, t.getComentario_alojamiento());
            stmt.setString(4, t.getComentario_actividad());

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ACEX_aprobadas porId(int id) {
        ACEX_aprobadas aprobada = null;
        String query = "SELECT * FROM aprobadas WHERE idActividad = ?";
        try (PreparedStatement stmt = getConnection().prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    aprobada = creaACEX(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aprobada;
    }

    @Override
    public boolean eliminar(int id) {
        String query = "DELETE FROM aprobadas WHERE idActividad = ?";
        try (PreparedStatement stmt = getConnection().prepareStatement(query)) {
            stmt.setInt(1, id);
            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException ex) {
            System.out.println("Error al eliminar la actividad: " + ex.getMessage());
            return false;
        }
    }

    private ACEX_aprobadas creaACEX(final ResultSet rs) throws SQLException {
        return new ACEX_aprobadas(rs.getInt("idActividad"), TipoActividad.valueOf(rs.getString("tipo")), rs.getBoolean("prevision"), rs.getBoolean("alojamiento"), rs.getString("titulo"), rs.getString("empresa_transporte"), rs.getDouble("precio"), rs.getTime("horaInicio").toLocalTime(), rs.getTime("horaFin").toLocalTime(), rs.getDate("fechaInicio").toLocalDate(), rs.getDate("fechaFin").toLocalDate(), rs.getString("comentario_estado"), rs.getString("comentario_alojamiento"), rs.getString("comenatario_adi"));
    }

}

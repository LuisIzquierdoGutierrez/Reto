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
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DAM126
 */
public class Solicitudes_ACEX_DAO implements Repositorio<Solicitudes_ACEX> {

    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    @Override
    public List<Solicitudes_ACEX> consultar() {
        List<Solicitudes_ACEX> solicitudes = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement(); ResultSet rs = stmt.executeQuery("SELECT id,id_solicitante,tipo,prevista,alojamiento,titulo,hora_inicio,hora_fin,fecha_inicio,fecha_fin,transporte,comentario_estado,comentario_actividad,estado FROM actividad_solicitada");) {
            while (rs.next()) {
                Solicitudes_ACEX solicitud = crearSolicitud(rs);
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
    public boolean guardar(Solicitudes_ACEX solicitud) {
        String sql = null;
        boolean resultado = false;
        if (solicitud.getIdSolicitudes() > 0) {
            sql = "UPDATE actividad_solicitada SET id_solicitante=?,tipo=?,prevista=?,alojamiento=?,titulo=?,hora_inicio=?,hora_fin=?,fecha_inicio=?,fecha_fin=?,transporte=?,comentario_estado=?,comentario_actividad=? WHERE id=?";
        } // son 12 ?
        else {
            sql = "INSERT INTO actividad_solicitada(id_solicitante,tipo,prevista,alojamiento,titulo,hora_inicio,hora_fin,fecha_inicio,fecha_fin,transporte,comentario_estado,comentario_actividad FROM actividad_solicitada) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        }
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            if (solicitud.getIdSolicitudes() > 0) {
                stmt.setInt(14, solicitud.getIdSolicitudes());
            }
            stmt.setInt(1, solicitud.getIdSolicitante());
            stmt.setString(2, String.valueOf(solicitud.getTipo()));
            stmt.setBoolean(3, solicitud.isPrevision());
            stmt.setBoolean(4, solicitud.isAlojamiento());
            stmt.setString(5, solicitud.getTitulo());
            stmt.setTime(6, Time.valueOf(solicitud.getHoraInicio()));
            stmt.setTime(7, Time.valueOf(solicitud.getHoraFin()));
            stmt.setDate(8, Date.valueOf(solicitud.getFechaInicio()));
            stmt.setDate(9, Date.valueOf(solicitud.getFechaFin()));
            stmt.setBoolean(10, solicitud.isTransporte());
            stmt.setString(11, solicitud.getComentario_estado());
            stmt.setString(12, solicitud.getComentario_adi());
            stmt.setString(13, String.valueOf(solicitud.getEstado()));
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
    public Solicitudes_ACEX porId(int id) {
        Solicitudes_ACEX producto = null;
        String sql = "SELECT id,id_solicitante,tipo,prevista,alojamiento,titulo,hora_inicio,hora_fin,fecha_inicio,fecha_fin,transporte,comentario_estado,comentario_actividad FROM actividad_solicitada WHERE id=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    producto = crearSolicitud(rs);
                }
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        }
        return producto;
    }

    //falta conseguir el boolean
    @Override
    public boolean eliminar(int id) {
        boolean resultado = false;
        String sql = "DELETE FROM actividad_solicitada WHERE id=?";
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

    private Solicitudes_ACEX crearSolicitud(ResultSet rs) throws SQLException {
        return new Solicitudes_ACEX(rs.getInt("id"), rs.getInt("id_solicitante"), TipoActividad.valueOf(rs.getString("tipo")), rs.getBoolean("prevista"), rs.getBoolean("alojamiento"), rs.getString("titulo"), rs.getTime("hora_inicio").toLocalTime(), rs.getTime("hora_fin").toLocalTime(), rs.getDate("fecha_inicio").toLocalDate(), rs.getDate("fecha_fin").toLocalDate(), rs.getBoolean("transporte"), rs.getString("comentario_estado"), rs.getString("comentario_actividad"), Estado.valueOf(rs.getString("estado")));
    }
}

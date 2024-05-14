/* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acex.database;

import acex.database.AccesoBaseDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import acex.objects.Solicitudes_ACEX;
import acex.enums.Tipo_Actividad;
import acex.enums.Tipo_Estado;

/**
 * Esta clase implementa la interfaz Patron_DAO y se encarga de manejar las operaciones de acceso a la base de datos para la entidad Solicitudes_ACEX.
 * @author Luis
 * @param <Solicitudes_ACEX> El tipo de entidad que se va a manejar en el repositorio.
 * @see Patron_DAO
 */
public class DAO_Solicitudes_ACEX implements Patron_DAO<Solicitudes_ACEX> {
    
    /**
     * Obtiene la conexión a la base de datos.
     * 
     * @return La conexión a la base de datos.
     */

    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }
    
    /**
     * Consulta todas las solicitudes de actividad almacenadas en la base de datos.
     * 
     * @return Una lista de objetos Solicitudes_ACEX que representan las solicitudes de actividad almacenadas en la base de datos.
     * 
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
     * @throws Exception Si ocurre un error al insertar el objeto en la colección.
     */

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
    
     /**
     * Guarda una solicitud de actividad en la base de datos.
     * 
     * @param solicitud La solicitud de actividad a save.
     * @return true si la solicitud se guarda correctamente, false de lo contrario.
     * 
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
     * @throws Exception Si ocurre un error al insertar/modificar el registro en la base de datos.
     */

    @Override
    public boolean save(Solicitudes_ACEX solicitud) {
        String sql = null;
        boolean resultado = true;
        if (solicitud.getIdSolicitudes() > 0) {
            sql = "UPDATE actividad_solicitada SET id_solicitante=?,tipo=?,prevista=?,alojamiento=?,titulo=?,hora_inicio=?,hora_fin=?,fecha_inicio=?,fecha_fin=?,transporte=?,comentario_estado=?,comentario_actividad=? WHERE id=?";
        } 
        else {
            sql = "INSERT INTO actividad_solicitada(id_solicitante,tipo,prevista,alojamiento,titulo,hora_inicio,hora_fin,fecha_inicio,fecha_fin,transporte,comentario_estado,comentario_actividad FROM actividad_solicitada) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        }
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            if (solicitud.getIdSolicitudes() > 0) {
                stmt.setInt(14, solicitud.getIdSolicitudes());
            }
            stmt.setInt(1, solicitud.getSolicitante().getId_profesor());
            stmt.setString(2,String.valueOf(solicitud.getTipo()));
            stmt.setBoolean(3, solicitud.isProgramada());
            stmt.setBoolean(4, solicitud.isAlojamiento());
            stmt.setString(5, solicitud.getTitulo());
            stmt.setTime(6, Time.valueOf(solicitud.getHoraInicio()));
            stmt.setTime(7, Time.valueOf(solicitud.getHoraFin()));
            stmt.setDate(8, Date.valueOf(solicitud.getFechaInicio()));
            stmt.setDate(9, Date.valueOf(solicitud.getFechaFin()));
            stmt.setBoolean(10, solicitud.isTransporte());
            stmt.setString(11, solicitud.getComentario_estado());
            stmt.setString(12, solicitud.getComentario_actividad());
            stmt.setString(13, String.valueOf(solicitud.getEstado()));
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
     * Obtiene una solicitud de actividad por su ID.
     * 
     * @param id El ID de la solicitud de actividad.
     * @return La solicitud de actividad correspondiente al ID especificado, o null si no se encuentra ninguna solicitud con ese ID.
     * 
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
     */

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

   /**
     * Elimina una solicitud de actividad de la base de datos.
     * 
     * @param id El ID de la solicitud de actividad a eliminar.
     * @return true si la solicitud se elimina correctamente, false de lo contrario.
     * 
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
     * @throws Exception Si ocurre un error al borrar el registro de la base de datos.
     */
    @Override
    public boolean eliminar(int id) {
        boolean resultado = true;
        String sql = "DELETE FROM actividad_solicitada WHERE id=?";
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
    /**
     * Crea un objeto Solicitudes_ACEX a partir de un ResultSet.
     * 
     * @param rs El ResultSet que contiene los datos de la solicitud de actividad.
     * @return Un objeto Solicitudes_ACEX creado a partir de los datos del ResultSet.
     * 
     * @throws SQLException Si ocurre un error al obtener los datos del ResultSet.
     */

    private Solicitudes_ACEX crearSolicitud(ResultSet rs) throws SQLException {

        return new Solicitudes_ACEX(rs.getInt("id"), rs.getInt("id_solicitante"), rs.getString("titulo"), rs.getString("comenatario_actividad"), Tipo_Actividad.valueOf(rs.getString("tipo")), rs.getBoolean("prevista"), Tipo_Estado.valueOf(rs.getString("estado")), rs.getString("comentario_estado"), rs.getBoolean("transporte"), rs.getBoolean("alojamiento"), rs.getTime("hora_inicio").toLocalTime(), rs.getTime("hora_fin").toLocalTime(), rs.getDate("fecha_inicio").toLocalDate(), rs.getDate("fecha_fin").toLocalDate());

    }
}

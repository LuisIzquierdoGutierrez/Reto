/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acex.database;

import acex.objects.*;
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
public class DAO_Grupos_Participantes implements DAO_Patron<Grupo_Participante> {

    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    @Override
    public List<Grupo_Participante> consultar() {

        List<Grupo_Participante> cursos = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement(); ResultSet rs = stmt.executeQuery("SELECT id,id_grupo,id_actividad,num_alumnos FROM curso_participante");) {
            while (rs.next()) {
                Grupo_Participante solicitud = crearGrupo(rs);
                if (!cursos.add(solicitud)) {
                    throw new Exception("error no se ha insertado el objeto en la colección");
                }
            }
        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return cursos;
    }

    @Override
    public boolean save(Grupo_Participante grupo) {

        String sql = null;
        boolean resultado = false;
        if (grupo.getId() > 0) {
            sql = "UPDATE grupo_participante SET id_grupo=?,id_actividad=?,num_alumno=? WHERE id=?";
        } else {
            sql = "INSERT INTO grupo_participante(id_grupo,id_actividad,num_alumnos FROM curso_participante) VALUES (?,?,?)";
        }
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            if (grupo.getId() > 0) {
                stmt.setInt(4, grupo.getId());
            }
            stmt.setInt(1, grupo.getActividad().getIdSolicitudes());
            stmt.setInt(2, grupo.getGrupo().getId_grupo());
            stmt.setInt(3, grupo.getNum_alumnos());

            int salida = stmt.executeUpdate();
            if (salida != 1) {
                throw new Exception(" No se ha insertado/modificado un solo registro");
            }
            resultado = true;
        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }

    @Override
    public Grupo_Participante porId(int id) {
        Grupo_Participante grupo = null;
        String sql = "SELECT id,id_grupo,id_actividad,num_alumnos FROM grupo_participante WHERE id=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    grupo = crearGrupo(rs);
                }
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        }
        return grupo;
    }

    @Override
    public boolean eliminar(int id) {
        boolean resultado = false;
        String sql = "DELETE FROM curso_participante WHERE id=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id);
            int salida = stmt.executeUpdate();
            if (salida != 1) {
                throw new Exception(" No se ha borrado un solo registro");
            }
            resultado = true;
        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }

    private Grupo_Participante crearGrupo(ResultSet rs) throws SQLException {
        return new Grupo_Participante(rs.getInt("id"), rs.getInt("id_grupo"), rs.getInt("id_actividad"), rs.getInt("num_alumnos"));
    }
}

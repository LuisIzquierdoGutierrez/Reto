/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acex.database;

import acex.enums.Tipo_Etapa;
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
public class DAO_Cursos_Participantes implements DAO_Patron<Curso_Participante> {

    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    @Override
    public List<Curso_Participante> consultar() {

        List<Curso_Participante> cursos = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement(); ResultSet rs = stmt.executeQuery("SELECT id,id_curso,id_actividad,num_alumnos FROM curso_participante");) {
            while (rs.next()) {
                Curso_Participante solicitud = crearCurso(rs);
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
    public boolean save(Curso_Participante curso) {

        String sql = null;
        boolean resultado = false;
        if (curso.getId() > 0) {
            sql = "UPDATE curso_participante SET id_curso=?,id_actividad=?,num_alumno=? WHERE id=?";
        } else {
            sql = "INSERT INTO curso_participante(id_curso,id_actividad,num_alumnos FROM curso_participante) VALUES (?,?,?)";
        }
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            if (curso.getId() > 0) {
                stmt.setInt(4, curso.getId());
            }
            stmt.setInt(1, curso.getActividad().getIdSolicitudes());
            stmt.setInt(2, curso.getCurso().getId_curso());
            stmt.setInt(3, curso.getNum_alumnos());

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
    public Curso_Participante porId(int id) {
        Curso_Participante curso = null;
        String sql = "SELECT id,id_curso,id_actividad,num_alumnos FROM curso_participante WHERE id=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    curso = crearCurso(rs);
                }
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        }
        return curso;
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

    private Curso_Participante crearCurso(ResultSet rs) throws SQLException {
        return new Curso_Participante(rs.getInt("id"),rs.getInt("id_curso"),rs.getInt("id_actividad"),rs.getInt("num_alumnos"));
    }
}

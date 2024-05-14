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
import acex.objects.Cursos;
import acex.enums.Tipo_Etapa;

/**
 * Esta clase implementa la interfaz DAO_Patron y se encarga de realizar
 operaciones CRUD en la tabla "Cursos" de la base de datos.
 *
 * @author Naiara
 * @param <Cursos> El tipo de objeto que se va a manejar en la base de datos.
 * @see DAO_Patron
 */
public class DAO_Cursos implements DAO_Patron<Cursos> {

    /**
     * Obtiene la conexión a la base de datos.
     *
     * @return La conexión a la base de datos.
     */
    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    /**
     * Consulta todos los cursos en la base de datos.
     *
     * @return Una lista de objetos Cursos que representan los cursos en la base
     * de datos.
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
     */
    @Override
    public List<Cursos> consultar() {

        List<Cursos> cursos = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement(); ResultSet rs = stmt.executeQuery("SELECT id,codigo,etapa,activo,descripcion FROM curso");) {
            while (rs.next()) {
                Cursos solicitud = crearCurso(rs);
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

    /**
     * Guarda un curso en la base de datos.
     *
     * @param curso El objeto Cursos que se va a save.
     * @return true si el curso se guarda correctamente, false de lo contrario.
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
     */
    @Override
    public boolean save(Cursos curso) {

        String sql = null;
        boolean resultado = false;
        if (curso.getId_curso() > 0) {
            sql = "UPDATE curso SET codigo=?,etapa=?,activo=?,descripcion=? WHERE id=?";
        } else {
            sql = "INSERT INTO curso(codigo,etapa,activo,descripcion FROM curso) VALUES (?,?,?,?)";
        }
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            if (curso.getId_curso() > 0) {
                stmt.setInt(5, curso.getId_curso());
            }
            stmt.setString(1, String.valueOf(curso.getCodigo()));
            stmt.setString(2, String.valueOf(curso.getEtapa()));
            stmt.setBoolean(3, curso.isCursoActivo());
            stmt.setString(4, curso.getDescripcion());

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

    /**
     * Obtiene un curso por su ID.
     *
     * @param id El ID del curso.
     * @return El objeto Cursos que representa el curso con el ID especificado,
     * o null si no se encuentra.
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
     */
    @Override
    public Cursos porId(int id) {
        Cursos curso = null;
        String sql = "SELECT id,codigo,etapa,activo,descripcion FROM curso WHERE id=?";
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

    /**
     * Elimina un curso de la base de datos.
     *
     * @param id El ID del curso que se va a eliminar.
     * @return true si el curso se elimina correctamente, false de lo contrario.
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
     */
    @Override
    public boolean eliminar(int id) {
        boolean resultado = true;
        String sql = "DELETE FROM curso WHERE id=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id);
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
     * Crea un objeto Cursos a partir de un ResultSet.
     *
     * @param rs El ResultSet que contiene los datos del curso.
     * @return El objeto Cursos creado.
     * @throws SQLException Si ocurre un error al acceder a los datos del
     * ResultSet.
     */
    private Cursos crearCurso(ResultSet rs) throws SQLException {
        return new Cursos(rs.getInt("id"), rs.getString("codigo"), Tipo_Etapa.valueOf(rs.getString("etapa")), rs.getBoolean("activo"), rs.getString("descripcion"));
    }

}

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
import acex.objects.Grupo;

/**
 * Esta clase implementa la interfaz DAO_Patron y proporciona métodos para
 acceder a la base de datos y realizar operaciones en la tabla "grupo".
 *
 * @author Luis, Adrian
 * @see DAO_Patron
 */
public class DAO_Grupo implements DAO_Patron<Grupo> {

    /**
     * Obtiene la conexión a la base de datos.
     *
     * @return La conexión a la base de datos.
     */
    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    /**
     * Consulta todos los grupos en la tabla "grupo".
     *
     * @return Una lista de objetos Grupo que representan los grupos
     * consultados.
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
     */
    @Override
    public List<Grupo> consultar() {
        List<Grupo> grupos = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement(); ResultSet rs = stmt.executeQuery("SELECT id,id_curso,codigo,activo.descripcion  FROM grupo");) {
            while (rs.next()) {
                Grupo grupo = crearGrupo(rs);
                if (!grupos.add(grupo)) {
                    throw new Exception("error no se ha insertado el objeto en la colección");
                }
            }
        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return grupos;
    }

    /**
     * Guarda un grupo en la tabla "grupo".
     *
     * @param grupo El grupo a save.
     * @return true si el grupo se guarda correctamente, false de lo contrario.
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
     */
    @Override
    public boolean save(Grupo grupo) {
        String sql = null;
        boolean resultado = false;
        if (grupo.getId_grupo() > 0) {
            sql = "UPDATE grupo SET id_curso=?,codigo=?,activo=?,descripcion=? WHERE id=?";
        } else {
            sql = "INSERT INTO grupo(id_curso,codigo,activo,descripcion) VALUES (?,?,?,?)";
        }
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            if (grupo.getId_grupo() > 0) {
                stmt.setInt(5, grupo.getId_grupo());
            }
            stmt.setInt(1, grupo.getCurso().getId_curso());
            stmt.setString(2, grupo.getCod_grupo());
            stmt.setBoolean(3, grupo.isActivo());
            stmt.setString(4, grupo.getDescripcion_grupo());

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

    /**
     * Consulta un grupo por su ID en la tabla "grupo".
     *
     * @param id El ID del grupo a consultar.
     * @return El objeto Grupo que representa el grupo consultado, o null si no
     * se encuentra.
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
     */
    @Override
    public Grupo porId(int id) {
        Grupo grupo = null;
        String sql = "SELECT id,id_curso,codigo,num_alumnos,activo,descripcion FROM grupo  WHERE id=?";
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

    /**
     * Elimina un grupo de la tabla "grupo" por su ID.
     *
     * @param id El ID del grupo a eliminar.
     * @return true si el grupo se elimina correctamente, false de lo contrario.
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
     */
    @Override
    public boolean eliminar(int id) {
        boolean resultado = false;
        String sql = "DELETE FROM grupo WHERE id=?";
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

    /**
     * Crea un objeto Grupo a partir de un ResultSet.
     *
     * @param rs El ResultSet que contiene los datos del grupo.
     * @return El objeto Grupo creado.
     * @throws SQLException Si ocurre un error al acceder a los datos del
     * ResultSet.
     */
    private Grupo crearGrupo(ResultSet rs) throws SQLException {
        return new Grupo(rs.getInt("id"), rs.getString("codigo"), rs.getBoolean("activo"), rs.getString("descripcion"), rs.getInt("id_curso"));
    }
}

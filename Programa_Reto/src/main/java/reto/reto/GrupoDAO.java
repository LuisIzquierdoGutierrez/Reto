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
 *
 * @author DAM126
 */
public class GrupoDAO implements Repositorio<Grupo> {

    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    @Override
    public List<Grupo> consultar() {
        List<Grupo> grupos = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement(); ResultSet rs = stmt.executeQuery("SELECT id,id_curso,codigo,num_alumnos,activo.descripcion  FROM grupo");) {
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

    @Override
    public boolean guardar(Grupo grupo) {
        String sql = null;
        boolean resultado = false;
        if (grupo.getId_grupo() > 0) {
            sql = "UPDATE grupo SET id_curso=?,codigo=?,num_alumnos=?,activo=?,descripcion=? WHERE id=?";
        } else {
            sql = "INSERT INTO grupo(id,id_curso,codigo,num_alumnos,activo,descripcion) VALUES (?,?,?,?,?,?)";
        }
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            if (grupo.getId_grupo() > 0) {
                stmt.setInt(6, grupo.getId_grupo());
            }
            stmt.setInt(1, grupo.getCurso().getId_curso());
            stmt.setString(2, grupo.getCod_grupo());
            stmt.setInt(3, grupo.getNumAlumnos());
            stmt.setBoolean(4, grupo.isActivo());
            stmt.setString(5, grupo.getDescripcion_grupo());

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

    private Grupo crearGrupo(ResultSet rs) throws SQLException {
        return new Grupo(rs.getInt("id"),rs.getString("codigo"),rs.getInt("num_alumnos"),rs.getBoolean("activo"),rs.getString("descripcion"),rs.getInt("id_curso"));
    }
}

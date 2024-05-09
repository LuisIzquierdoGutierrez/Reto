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
 * @author DAM106
 */
public class Tipo_transporteDAO implements Repositorio<Tipo_transporte> {

    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    @Override
    public List<Tipo_transporte> consultar() {
        List<Tipo_transporte> Transportes = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement(); ResultSet rs = stmt.executeQuery("SELECT id,tipo,importe,comentario FROM transporte");) {
            while (rs.next()) {
                Tipo_transporte transporte = crearTipo_transporte(rs);
                if (!Transportes.add(transporte)) {
                    throw new Exception("error no se ha insertado el objeto en la colección");
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return Transportes;
    }

    @Override
    public boolean guardar(Tipo_transporte transporte) {
        String sql = null;
        boolean resultado = true;
        if (transporte.getId_tipo_transporte() > 0) {
            sql = "UPDATE transporte SET nombre=?, comentario=? WHERE id=?";
        } else {
            String query = "INSERT INTO transporte (nombre, comentario, id) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = getConnection().prepareStatement(query)) {
                if (transporte.getId_tipo_transporte() > 0) {
                    stmt.setInt(3, transporte.getId_tipo_transporte());
                }
                stmt.setString(1, transporte.getTipo());
                stmt.setString(2, transporte.getComentario());
                int salida = stmt.executeUpdate();
                if (salida != 1) {
                    resultado = false;
                    throw new Exception(" No se ha borrado un solo registro");
                }
            } catch (SQLException e) {
                System.out.println("SQLException: " + e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return resultado;
    }

    @Override
    public Tipo_transporte porId(int id) {
        Tipo_transporte transporte = null;
        String sql = "SELECT id,nombre,comentario FROM transporte WHERE id=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    transporte = crearTipo_transporte(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return transporte;
    }

    @Override
    public boolean eliminar(int id) {
        boolean resultado = true;
        String sql = "DELETE FROM transporte WHERE id=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            int salida = stmt.executeUpdate();
            if (salida != 1) {
                resultado = false;
                throw new Exception(" No se ha borrado un solo registro");
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }

    private Tipo_transporte crearTipo_transporte(ResultSet rs) throws SQLException {
        return new Tipo_transporte(rs.getInt("id_Transporte"), rs.getString("nombre"), rs.getString("comentario"));
    }
}

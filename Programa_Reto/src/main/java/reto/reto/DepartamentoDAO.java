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
 * @author adry1
 */
public class DepartamentoDAO implements Repositorio<Departamento> {

    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConnection();
    }

    @Override
    public List<Departamento> consultar() {
        List<Departamento> departamentos = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement(); ResultSet rs = stmt.executeQuery("SELECT id,id_jefe,codigo,nombre FROM departamento");) {
            while (rs.next()) {
                Departamento departamento = crearDepartamento(rs);
                if (!departamentos.add(departamento)) {
                    throw new Exception("error no se ha insertado el objeto en la colección");
                }
            }
        } catch (SQLException e) {
            // errores
            System.out.println("SQLException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return departamentos;
    }

    @Override
    public boolean guardar(Departamento departamento) {
        String sql = null;
        boolean resultado = true;
        if (departamento.getIdDepartamento() > 0) {
            sql = "UPDATE departamento SET id_jefe=?, codigo=?, nombre=? WHERE id=?";
        } else {
            String query = "INSERT INTO departamento (id_jefe, codigo, nombre) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = getConnection().prepareStatement(query)) {
                if (departamento.getIdDepartamento() > 0) {
                    stmt.setInt(4, departamento.getIdDepartamento());
                }
                stmt.setInt(1, departamento.getJefe().getId_profesor());
                stmt.setString(2, departamento.getCodigo());
                stmt.setString(3, departamento.getNombre());

                int salida = stmt.executeUpdate();
                if (salida != 1) {
                    resultado = false;
                    throw new Exception(" No se ha insertado/modificado un solo registro");
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
    public Departamento porId(int id) {
        Departamento departamento = null;
        String sql = "SELECT id,id_jefe,codigo,nombre FROM departamento WHERE id=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    departamento = crearDepartamento(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return departamento;
    }

    @Override
    public boolean eliminar(int id) {
        boolean resultado = true;
        String sql = "DELETE FROM departamento WHERE id=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            int salida = stmt.executeUpdate();
            if (salida != 1) {
                resultado = false;
                throw new Exception(" No se ha borrado un solo registro");
            }
        } catch (SQLException e) {
            // errores
            System.out.println("SQLException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }

    private Departamento crearDepartamento(ResultSet rs) throws SQLException {

        return new Departamento(rs.getInt("id"), rs.getInt("id_jefe"), rs.getString("codigo"), rs.getString("nombre"));

    }
}

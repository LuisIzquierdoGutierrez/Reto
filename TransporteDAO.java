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
public class TransporteDAO implements Repositorio<Transporte>{
  private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }
    @Override
    public List<Transporte> consultar() {
           List<Transporte> Transportes = new ArrayList<>();
         try (Statement stmt = getConnection().createStatement(); ResultSet rs = stmt.executeQuery("SELECT id,tipo,importe,comentario FROM transporte");) {
            while (rs.next()) {
                Transporte transporte = crearTransporte(rs);
                if (!Transportes.add(transporte)) {
                    throw new Exception("error no se ha insertado el objeto en la colección");
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return Transportes;}

    @Override
    public boolean guardar(Transporte transporte) {
         String sql = null;
        boolean resultado = false;
        if (transporte.getIdTransporte() > 0) {
            sql = "UPDATE transporte SET id=?, tipo=?, importe=?, comentario=? WHERE id=?";
        } else {
            String query = "INSERT INTO transporte (id, codigo, nombre) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = getConnection().prepareStatement(query)) {
                if (transporte.getIdTransporte() > 0) {
                    stmt.setInt(4, transporte.getIdTransporte());
                }
                stmt.setInt(1, transporte.getIdTransporte());
                stmt.executeUpdate();
                return true;
            } catch (SQLException e) {
                System.out.println("SQLException: " + e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }
    @Override
    public Transporte porId(int id) {
       Transporte transporte = null;
        String sql = "SELECT id,tipo,importe,comentario FROM transporte WHERE id=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    transporte = crearTransporte(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return transporte;
    }

    @Override
    public boolean eliminar(int id) {
         boolean resultado = false;
        String sql = "DELETE FROM transporte WHERE id=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            int salida = stmt.executeUpdate();
            if (salida != 1) {
                throw new Exception(" No se ha borrado un solo registro");
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }
     private Transporte crearTransporte(ResultSet rs) throws SQLException{
        return new Transporte(rs.getInt("id_Transporte"), (Tipo_transporte) (List<Tipo_transporte>) rs);
    }
}

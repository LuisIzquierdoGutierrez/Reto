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
 * @author Adrian
 */
public class DAO_Profesor_Responsables implements Patron_DAO<Profesor_Responsable>{

    
     private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }
    @Override
    public List<Profesor_Responsable> consultar() {
         List<Profesor_Responsable> responsables = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement(); ResultSet rs = stmt.executeQuery("SELECT id,id_profesor,id_actividad FROM profesor_responsable");) {
            while (rs.next()) {
                Profesor_Responsable responsable = crearResponsable(rs);
                if (!responsables.add(responsable)) {
                    throw new Exception("error no se ha insertado el objeto en la colección");
                }
            }
        } catch (SQLException e) {
            // errores
            System.out.println("SQLException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return responsables;
    }

    @Override
    public boolean save(Profesor_Responsable responsable) {
    String sql= null;
    boolean resultado= true;
    if(responsable.getId()>0){
        sql="UPDATE Profesor_Responsable SET id=?,id_profesor=?,id_actvidad=?";
    } else {
            String query = "INSERT INTO departamento (id, id_profesor, id_actividad) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = getConnection().prepareStatement(query)) {
                if (responsable.getId() > 0) {
                    stmt.setInt(1, responsable.getId());
                }
                stmt.setInt(2, responsable.getResponsable().getId_profesor());
                stmt.setInt(3, responsable.getIdActividad().getIdSolicitudes());
               

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
    public Profesor_Responsable porId(int id) {
       Profesor_Responsable responsable = null;
        String sql = "SELECT id,id_profesor,id_actividad FROM rofesor_responsable WHERE id=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    responsable = crearResponsable(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return responsable;
    }
     @Override
    public boolean eliminar(int id) {
        boolean resultado = true;
        String sql = "DELETE FROM profesor_responsable WHERE id=?";
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

    private Profesor_Responsable crearResponsable(ResultSet rs) throws SQLException {

        return new Profesor_Responsable(rs.getInt("id"), rs.getInt("idResponsable"), rs.getInt("idActividad"));
    }
   
}

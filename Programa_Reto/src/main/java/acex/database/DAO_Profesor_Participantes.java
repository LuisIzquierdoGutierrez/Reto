/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acex.database;

import acex.objects.Profesor_Participante;
import acex.objects.Profesor_Responsable;
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
public class DAO_Profesor_Participantes implements Patron_DAO<Profesor_Participante> {

     private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }
    @Override
    public List<Profesor_Participante> consultar() {
         List<Profesor_Participante> participantes = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement(); ResultSet rs = stmt.executeQuery("SELECT id,id_profesor,id_actividad FROM profesor_responsable");) {
            while (rs.next()) {
                Profesor_Participante participante = crearParticipante(rs);
                if (!participantes.add(participante)) {
                    throw new Exception("error no se ha insertado el objeto en la colección");
                }
            }
        } catch (SQLException e) {
            // errores
            System.out.println("SQLException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return participantes;
    }

    @Override
    public boolean save(Profesor_Participante participante) {
    String sql= null;
    boolean resultado= true;
    if(participante.getId()>0){
        sql="UPDATE profesor_participante SET id=?,id_profesor=?,id_actvidad=?";
    } else {
            String query = "INSERT INTO profesor_participante (id, id_profesor, id_actividad) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = getConnection().prepareStatement(query)) {
                if (participante.getId() > 0) {
                    stmt.setInt(1, participante.getId());
                }
                stmt.setInt(2, participante.getParticipante().getId_profesor());
                stmt.setInt(3, participante.getIdActividad().getIdSolicitudes());
               

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
    public Profesor_Participante porId(int id) {
       Profesor_Participante participante = null;
        String sql = "SELECT id,id_profesor,id_actividad FROM rofesor_responsable WHERE id=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    participante = crearParticipante(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return participante;
    }
     @Override
    public boolean eliminar(int id) {
        boolean resultado = true;
        String sql = "DELETE FROM profesor_participante WHERE id=?";
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

    private Profesor_Participante crearParticipante(ResultSet rs) throws SQLException {

        return new Profesor_Participante(rs.getInt("id"), rs.getInt("idResponsable"), rs.getInt("idActividad"));
    }
    
}

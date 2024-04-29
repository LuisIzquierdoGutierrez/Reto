/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto.reto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DAM103
 */
public class ACEXAprobadasDAO implements Repositorio<ACEX_aprobadas> {
    
      private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConnection();
    }
    
    
    

//    @Override
//    public List<ACEX_aprobadas> consultar() {
//        
//         List<ACEX_aprobadas> acex_aprobadas = new ArrayList<>();
//        try ( Statement stmt = getConnection().createStatement(); 
//              ResultSet rs = stmt.executeQuery("SELECT id,username,password,email FROM usuarios");) {
//            while (rs.next()) {
//                ACEX_aprobadas acex_aprobadas = creaUsuario(rs);
//                if (!usuarios.add(usuario)) {
//                    throw new Exception("error no se ha insertado el objeto en la colección");
//                }
//            }
//        } catch (SQLException ex) {
//            System.out.println("SQLException: " + ex.getMessage());
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//        return usuarios;
//    }   
//    }

    @Override
    public boolean guardar(ACEX_aprobadas t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ACEX_aprobadas porId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 private ACEX_aprobadas creaACEX(final ResultSet rs) throws SQLException {
        return new ACEX_aprobadas(rs.getInt("idActividad"),TipoActividad.valueOf(rs.getString("tipo")),rs.getBoolean("prevision"),rs.getBoolean("alojamiento"),rs.getString("titulo"),rs.getString("empresa_transporte"),rs.getDouble("precio"),rs.getTime("horaInicio")),rs.getTime("horaFin"),rs.getDate("fechaInicio"),rs.getDate("fechaFin"),rs.getString("comentario_estado"),rs.getString("comentario_alojamiento"),rs.getString("comenatario_adi"));
    } 
    
}

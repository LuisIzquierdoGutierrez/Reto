/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto.reto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Esta clase proporciona acceso a la base de datos.
 * @author Adrian
 * 
 */
public class AccesoBaseDatos {
    private Connection conn = null; //atributo conexión
    // constantes a definir
    private static final String BD = "acex";
    private static final String USUARIO = "developer";
    private static final String CLAVE = "";
    private static final String URL = "jdbc:mysql://10.0.16.50:3306/" + BD;
 /**
     * Constructor privado para evitar la creación de instancias directamente.
     * Utilice el método estático getInstance() para obtener una instancia de AccesoBaseDatos.
     */
    private AccesoBaseDatos() {
        
        try {
            Properties properties = new Properties();
            properties.setProperty("user", USUARIO);
            properties.setProperty("password", CLAVE);
            properties.setProperty("useSSL", "false");
            properties.setProperty("autoReconnect", "true");
            conn = (Connection) DriverManager.getConnection(URL, properties);
            if (conn == null) {
                System.out.println("Error en conexion");
            } else {
                System.out.println("Conexion correcta a: " + URL);
            }
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
    /**
     * Devuelve una instancia única de AccesoBaseDatos.
     *
     * @return una instancia de AccesoBaseDatos
     */

    public static AccesoBaseDatos getInstance() {
        return AccesoBaseDatosHolder.INSTANCE;
    }
    /**
     * Obtiene la conexión a la base de datos.
     *
     * @return la conexión a la base de datos
     */

    Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   

    private static class AccesoBaseDatosHolder {

        private static final AccesoBaseDatos INSTANCE = new AccesoBaseDatos();
    }
/**
     * Obtiene la conexión a la base de datos.
     *
     * @return la conexión a la base de datos
     * 
     * @see #getConnection()
     */
    public Connection getConn() {
        return conn;
    }
    
    /**
     * Cierra la conexión a la base de datos.
     *
     * @return true si la conexión se cerró correctamente, false en caso contrario
     * @throws SQLException si se produce un error al cerrar la conexión
     */
    public boolean cerrar() {
        boolean siCerrada = false;
        try {
            conn.close();
            if (conn.isClosed()) {
                siCerrada = true;
            }
        } catch (SQLException sqe) {
            System.out.println("Se produjo un error en el cierre");
        }
        return siCerrada;
    }
    
}

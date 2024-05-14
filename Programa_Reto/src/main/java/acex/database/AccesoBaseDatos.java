package acex.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Esta clase proporciona acceso a la base de datos de Acex.
 * 
 * @author Luis,Adrian,Miguel
 */

public class AccesoBaseDatos {
    private Connection conn = null;
    private static final String USER = "developer";
    private static final String PASSWORD = "";
    private static final String DATABASE_URL = "jdbc:mysql://10.0.16.35:3306/acex?useSSL=false&autoReconnect=true";
    
    /**
     * Crea una nueva instancia de AccesoBaseDatos y establece la conexión con la base de datos.
     */

    public AccesoBaseDatos() {
        try {
            conn = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        } catch (SQLException ex) {
            handleSQLException(ex);
        }
    }
    /**
     * Devuelve la conexión a la base de datos.
     * 
     * @return La conexión a la base de datos.
     */
    
    public Connection getConn() {
        return conn;
    }
      /**
     * Cierra la conexión a la base de datos.
     */
    public void closeConnection() {
        try {
            conn.close();
            System.out.println("Conexión cerrada.");
        } catch (SQLException ex) {
            handleSQLException(ex);
        } catch (NullPointerException ex) {}
    }
    
     /**
     * Maneja una excepción de SQL e imprime información relevante sobre la excepción.
     * 
     * @param ex La excepción de SQL a manejar.
     */
    
    private void handleSQLException(SQLException ex) {
        System.out.println("[ERROR] Código: " + ex.getErrorCode());
        System.out.println("[ERROR] Mensaje: " + ex.getMessage());
        System.out.println("[ERROR] Estado SQL: " + ex.getSQLState());
    }
     /**
     * Devuelve la instancia singleton de AccesoBaseDatos.
     * 
     * @return La instancia singleton de AccesoBaseDatos.
     */
    
    public static AccesoBaseDatos getInstance() {
        return InstanceHolder.INSTANCE;
    }
    
    private static class InstanceHolder {
        private static final AccesoBaseDatos INSTANCE = new AccesoBaseDatos();
    }
}

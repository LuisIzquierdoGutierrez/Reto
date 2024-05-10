package acex.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class AccesoBaseDatos {
    private Connection conn = null;
    private static final String USER = "developer";
    private static final String PASSWORD = "";
    private static final String DATABASE_URL = "jdbc:mysql://10.0.16.35:3306/acex?useSSL=false&autoReconnect=true";

    public AccesoBaseDatos() {
        try {
            conn = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        } catch (SQLException ex) {
            handleSQLException(ex);
        }
    }
    
    public Connection getConn() {
        return conn;
    }
    
    public void closeConnection() {
        try {
            conn.close();
            System.out.println("Conexión cerrada.");
        } catch (SQLException ex) {
            handleSQLException(ex);
        } catch (NullPointerException ex) {}
    }
    
    private void handleSQLException(SQLException ex) {
        System.out.println("[ERROR] Código: " + ex.getErrorCode());
        System.out.println("[ERROR] Mensaje: " + ex.getMessage());
        System.out.println("[ERROR] Estado SQL: " + ex.getSQLState());
    }
    
    public static AccesoBaseDatos getInstance() {
        return InstanceHolder.INSTANCE;
    }
    
    private static class InstanceHolder {
        private static final AccesoBaseDatos INSTANCE = new AccesoBaseDatos();
    }
}

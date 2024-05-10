package acex.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Access {
    private Connection conn = null;
    private static final String USER = "root";
    private static final String PASSWORD = "mysql";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/acex?useSSL=false&autoReconnect=true";

    public Access() {
        try {
            conn = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        } catch (SQLException ex) {
            handleSQLException(ex);
        }
    }
    
    public Connection getConnection() {
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
    
    public static Access getInstance() {
        return InstanceHolder.INSTANCE;
    }
    
    private static class InstanceHolder {
        private static final Access INSTANCE = new Access();
    }
}

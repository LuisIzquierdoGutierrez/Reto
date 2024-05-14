package acex.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Access {
    private Connection conn = null;
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/acex?useSSL=false&autoReconnect=true";
    
    private Access() {
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
            System.out.println("Connection closed.");
        } catch (SQLException ex) {
            handleSQLException(ex);
        } catch (NullPointerException ex) {}
    }
    
    public static Access getInstance() {
        return InstanceHolder.INSTANCE;
    }
    
    private static class InstanceHolder {
        private static final Access INSTANCE = new Access();
    }
    
    private void handleSQLException(SQLException ex) {
        System.out.println("[ERROR] Code: " + ex.getErrorCode());
        System.out.println("[ERROR] Message: " + ex.getMessage());
        System.out.println("[ERROR] SQL State: " + ex.getSQLState());
    }
}

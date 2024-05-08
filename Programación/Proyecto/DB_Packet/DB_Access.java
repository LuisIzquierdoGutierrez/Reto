package acex.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DB_Access {
    private Connection conn = null;
    private static final String USER = "root";
    private static final String PASSWORD = "mysql";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/acex?useSSL=false&autoReconnect=true";

    private DB_Access() {
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
      
    private void handleSQLException(SQLException ex) {
        System.out.println("Error Code: " + ex.getErrorCode());
        System.out.println("Error Message: " + ex.getMessage());
        System.out.println("SQL State: " + ex.getSQLState());
    }
    
    public static DB_Access getInstance() {
        return InstanceHolder.INSTANCE;
    }
    
    private static class InstanceHolder {
        private static final DB_Access INSTANCE = new DB_Access();
    }
}

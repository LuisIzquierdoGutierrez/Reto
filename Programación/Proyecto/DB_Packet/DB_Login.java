package acex.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DB_Login {
    
    public static boolean isUserPassword(String email, String password) {
        String sql = "SELECT password FROM profesor WHERE email=?";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
    
        try {
            conn = DB_Access.getInstance().getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            rset = stmt.executeQuery();
            
            if (rset.next()) {
                String hashedPassword = rset.getString("password");
                return password.equals(hashedPassword);
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        } finally {
            closeResources(stmt, rset);
        }
        
        return false;
    }
    
    
    public static boolean isUserActive(String email) {
        String sql = "SELECT activo FROM profesor WHERE email=?";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        
        try {
            conn = DB_Access.getInstance().getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            rset = stmt.executeQuery();
            
            if (rset.next()) {
                return rset.getBoolean("activo");
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        } finally {
            closeResources(stmt, rset);
        }
        
        return false;
    }
    
    
    public static String getUserPerfil(String email) {
        String sql = "SELECT perfil FROM profesor WHERE email=?";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        
        try {
            conn = DB_Access.getInstance().getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            rset = stmt.executeQuery();
            
            if (rset.next()) {
                return rset.getString("perfil");
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        } finally {
            closeResources(stmt, rset);
        }
        
        return null;
    }
    
    
    private static void closeResources(PreparedStatement stmt, ResultSet rset) {
        try {
            if (rset != null) {
                rset.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        }
    }
    
    
    private static void handleSQLException(SQLException ex) {
        System.out.println("Error Code: " + ex.getErrorCode());
        System.out.println("Error Message: " + ex.getMessage());
        System.out.println("SQL State: " + ex.getSQLState());
    }
}

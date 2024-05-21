package app.database;

/* @author  Miguel*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Esta clase proporciona acceso a la base de datos utilizando el patrón
 * Singleton.
 */
public class Access {

    private Connection conn = null;
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/acex?useSSL=false&autoReconnect=true";

    /**
     * Constructor privado para evitar la creación de instancias directamente.
     * Se establece la conexión a la base de datos.
     */
    private Access() {
        try {
            conn = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        } catch (SQLException ex) {
            handleSQLException(ex);
        }
    }

    /**
     * Obtiene la conexión a la base de datos.
     *
     * @return La conexión a la base de datos.
     */
    public Connection getConnection() {
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
        } catch (NullPointerException ex) {
        }
    }

    /**
     * Obtiene la instancia única de la clase Access.
     *
     * @return La instancia única de la clase Access.
     */
    public static Access getInstance() {
        return InstanceHolder.INSTANCE;
    }

    /**
     * Clase interna que contiene la instancia única de Access.
     */
    private static class InstanceHolder {

        private static final Access INSTANCE = new Access();
    }

    /**
     * Maneja las excepciones de SQL y muestra información detallada del error.
     *
     * @param ex La excepción de SQL.
     */
    private void handleSQLException(SQLException ex) {
        System.out.println("[ERROR] Código: " + ex.getErrorCode());
        System.out.println("[ERROR] Mensaje: " + ex.getMessage());
        System.out.println("[ERROR] Estado SQL: " + ex.getSQLState());
    }
}

package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL = "jdbc:postgresql://ep-winter-paper-aqrrijk8y-pooler.us-east-1.aws.neon.tech/neondb?user=neondb_owner&password=npq-yqEp8djS6UML&sslmode=require";

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}
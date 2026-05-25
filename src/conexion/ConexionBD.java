package conexion;
//AQUI ES DONDE YO CONECTO MI INTELLLIJ CON MI NEON EN MI BASE DE DATOS
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL = "jdbc:postgresql://ep-winter-paper-aqrrjk8y-pooler.c-8.us-east-1.aws.neon.tech:5432/neondb?sslmode=require";
    private static final String USUARIO = "neondb_owner";
    private static final String CONTRASEÑA = "npq_ygEp0dj56UML"; // TU CONTRASEÑA

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
    }
}
package dao.impl;

import dao.PlanetaDAO;
import modelo.Planeta;
import conexion.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlanetaDAOImpl implements PlanetaDAO {

    @Override
    public Planeta consultarPorId(int id) {
        String sql = "SELECT * FROM planetas WHERE id = ?";
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setInt(1, id);
            ResultSet resultado = sentencia.executeQuery();

            if (resultado.next()) {
                return extraerPlaneta(resultado);
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar por ID: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Planeta> consultarTodos() {
        List<Planeta> lista = new ArrayList<>();
        String sql = "SELECT * FROM planetas ORDER BY id";

        try (Connection conexion = ConexionBD.obtenerConexion();
             Statement sentencia = conexion.createStatement();
             ResultSet resultado = sentencia.executeQuery(sql)) {

            while (resultado.next()) {
                Planeta planeta = extraerPlaneta(resultado);
                lista.add(planeta);
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar todos: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public boolean agregar(Planeta planeta) {
        String sql = "INSERT INTO planetas (nombre, fecha_descubrimiento, tipo, numero_satelites, tiene_anillos, galaxia, posible_vida, temperatura_media, periodo_orbital, distancia_anios_luz) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, planeta.getNombre());
            sentencia.setString(2, planeta.getFechaDescubrimiento());
            sentencia.setString(3, planeta.getTipo());
            sentencia.setInt(4, planeta.getNumeroSatelites());
            sentencia.setBoolean(5, planeta.isTieneAnillos());
            sentencia.setString(6, planeta.getGalaxia());
            sentencia.setBoolean(7, planeta.isPosibleVida());
            sentencia.setDouble(8, planeta.getTemperaturaMedia());
            sentencia.setDouble(9, planeta.getPeriodoOrbital());
            sentencia.setDouble(10, planeta.getDistanciaAniosLuz());

            int filasAfectadas = sentencia.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("Error al agregar planeta: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Planeta> filtrarPorGalaxia(String galaxia) {
        List<Planeta> lista = new ArrayList<>();
        String sql = "SELECT * FROM planetas WHERE galaxia = ?";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, galaxia);
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {
                lista.add(extraerPlaneta(resultado));
            }

        } catch (SQLException e) {
            System.out.println("Error al filtrar por galaxia: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public List<Planeta> filtrarPorPosibleVida(boolean tieneVida) {
        List<Planeta> lista = new ArrayList<>();
        String sql = "SELECT * FROM planetas WHERE posible_vida = ?";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setBoolean(1, tieneVida);
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {
                lista.add(extraerPlaneta(resultado));
            }

        } catch (SQLException e) {
            System.out.println("Error al filtrar por posible vida: " + e.getMessage());
        }
        return lista;
    }

    // Método para obtener los datos de la base y convertirlos en objeto Planeta
    private Planeta extraerPlaneta(ResultSet resultado) throws SQLException {
        return new Planeta(
                resultado.getInt("id"),
                resultado.getString("nombre"),
                resultado.getString("fecha_descubrimiento"),
                resultado.getString("tipo"),
                resultado.getInt("numero_satelites"),
                resultado.getBoolean("tiene_anillos"),
                resultado.getString("galaxia"),
                resultado.getBoolean("posible_vida"),
                resultado.getDouble("temperatura_media"),
                resultado.getDouble("periodo_orbital"),
                resultado.getDouble("distancia_anios_luz")
        );
    }
}

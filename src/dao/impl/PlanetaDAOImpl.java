package dao.impl;

import dao.PlanetaDAO;
import modelo.Planeta;
import conexion.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlanetaDAOImpl implements PlanetaDAO {


    @Override
    public List<Planeta> consultarTodos() {
        String sql = "SELECT * FROM planetas";
        List<Planeta> lista = new ArrayList<>();

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Planeta p = new Planeta();
                cargarDatosPlaneta(rs, p);
                lista.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al consultar todos: " + e.getMessage());
        }
        return lista;
    }


    @Override
    public Planeta consultarPorId(int id) {
        String sql = "SELECT * FROM planetas WHERE id = ?";
        Planeta p = null;

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                p = new Planeta();
                cargarDatosPlaneta(rs, p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }


    @Override
    public boolean agregar(Planeta planeta) {
        String sql = "INSERT INTO planetas (\"NOMBRE\", id, \"FECHA DE DESCUBIERTO\", \"TIPO PLANETA\", \"numero de satelites naturales\", \"Sistema de anillos\", galaxia, \"Podria contener vida\", \"Temperatura media\", \"periodo orbital\", \"años luz de la tierra\") " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, planeta.getNombre());
            pst.setInt(2, planeta.getId());
            pst.setString(3, planeta.getFechaDeDescubierto());
            pst.setString(4, planeta.getTipoPlaneta());
            pst.setInt(5, planeta.getNumeroDeSatelitesNaturales());
            pst.setBoolean(6, planeta.isSistemaDeAnillos());
            pst.setString(7, planeta.getGalaxia());
            pst.setBoolean(8, planeta.isPodriaContenerVida());
            pst.setInt(9, planeta.getTemperaturaMedia());
            pst.setDouble(10, planeta.getPeriodoOrbital());
            pst.setDouble(11, planeta.getAnosLuzDeLaTierra());

            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("❌ Error al agregar: " + e.getMessage());
            return false;
        }
    }


    @Override
    public List<Planeta> filtrarPorGalaxia(String nombreGalaxia) {
        String sql = "SELECT * FROM planetas WHERE galaxia ILIKE ?";
        List<Planeta> lista = new ArrayList<>();

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, "%" + nombreGalaxia + "%");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Planeta p = new Planeta();
                cargarDatosPlaneta(rs, p);
                lista.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }


    @Override
    public List<Planeta> filtrarPorPosibleVida(boolean tienePosibilidad) {
        String sql = "SELECT * FROM planetas WHERE \"Podria contener vida\" = ?";
        List<Planeta> lista = new ArrayList<>();

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setBoolean(1, tienePosibilidad);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Planeta p = new Planeta();
                cargarDatosPlaneta(rs, p);
                lista.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }


    private void cargarDatosPlaneta(ResultSet rs, Planeta p) throws SQLException {
        p.setNombre(rs.getString("\"NOMBRE\""));
        p.setId(rs.getInt("id"));
        p.setFechaDeDescubierto(rs.getString("\"FECHA DE DESCUBIERTO\""));
        p.setTipoPlaneta(rs.getString("\"TIPO PLANETA\""));
        p.setNumeroDeSatelitesNaturales(rs.getInt("\"numero de satelites naturales\""));
        p.setSistemaDeAnillos(rs.getBoolean("\"Sistema de anillos\""));
        p.setGalaxia(rs.getString("galaxia"));
        p.setPodriaContenerVida(rs.getBoolean("\"Podria contener vida\""));
        p.setTemperaturaMedia(rs.getInt("\"Temperatura media\""));
        p.setPeriodoOrbital(rs.getDouble("\"periodo orbital\""));
        p.setAnosLuzDeLaTierra(rs.getDouble("\"años luz de la tierra\""));
    }
}
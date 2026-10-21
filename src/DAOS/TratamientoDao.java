/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import Entidades.Tratamiento;
import basedatos.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import servicio.ICrudDao;

public class TratamientoDao implements ICrudDao<Tratamiento> {
    
    private Connection getConnection() throws SQLException {
        return new conexion().conectar();
    }
    
    @Override
    public void create(Tratamiento o) throws Exception {
        String sql = "INSERT INTO tratamientos (nombre, descripcion, costo, duracion_dias, tipo) VALUES (?, ?, ?, ?, ?)";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setString(1, o.getNombre());
            ps.setString(2, o.getDescripcion());
            ps.setDouble(3, o.getCosto());
            ps.setInt(4, o.getDuracionDias());
            ps.setString(5, o.getTipo());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new Exception("Error al crear tratamiento: " + e.getMessage(), e);
        }
    }

    @Override
    public void update(Tratamiento o) throws Exception {
        String sql = "UPDATE tratamientos SET nombre=?, descripcion=?, costo=?, duracion_dias=?, tipo=? WHERE id=?";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setString(1, o.getNombre());
            ps.setString(2, o.getDescripcion());
            ps.setDouble(3, o.getCosto());
            ps.setInt(4, o.getDuracionDias());
            ps.setString(5, o.getTipo());
            ps.setInt(6, o.getId());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new Exception("Error al actualizar tratamiento: " + e.getMessage(), e);
        }
    }

    @Override
    public void delete(Tratamiento o) throws Exception {
        String sql = "DELETE FROM tratamientos WHERE id=?";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setInt(1, o.getId());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new Exception("Error al eliminar tratamiento: " + e.getMessage(), e);
        }
    }

    @Override
    public Tratamiento find(Object o) throws Exception {
        String sql = "SELECT * FROM tratamientos WHERE id=?";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setInt(1, (Integer) o);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToTratamiento(rs);
                }
            }
        } catch (SQLException e) {
            throw new Exception("Error al buscar tratamiento: " + e.getMessage(), e);
        }
        return null;
    }

    @Override
    public List<Tratamiento> readAll() throws Exception {
        String sql = "SELECT * FROM tratamientos";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            return mapResultSetToList(rs);
            
        } catch (SQLException e) {
            throw new Exception("Error al listar tratamientos: " + e.getMessage(), e);
        }
    }

    public List<Tratamiento> findByTipo(String tipo) throws Exception {
        String sql = "SELECT * FROM tratamientos WHERE tipo=?";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setString(1, tipo);
            try (ResultSet rs = ps.executeQuery()) {
                return mapResultSetToList(rs);
            }
        } catch (SQLException e) {
            throw new Exception("Error al buscar tratamientos por tipo: " + e.getMessage(), e);
        }
    }

    public List<Tratamiento> findByCostoRange(double minCosto, double maxCosto) throws Exception {
        String sql = "SELECT * FROM tratamientos WHERE costo BETWEEN ? AND ?";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setDouble(1, minCosto);
            ps.setDouble(2, maxCosto);
            try (ResultSet rs = ps.executeQuery()) {
                return mapResultSetToList(rs);
            }
        } catch (SQLException e) {
            throw new Exception("Error al buscar tratamientos por rango de costo: " + e.getMessage(), e);
        }
    }

    private Tratamiento mapResultSetToTratamiento(ResultSet rs) throws SQLException {
        Tratamiento trat = new Tratamiento();
        trat.setId(rs.getInt("id"));
        trat.setNombre(rs.getString("nombre"));
        trat.setDescripcion(rs.getString("descripcion"));
        trat.setCosto(rs.getDouble("costo"));
        trat.setDuracionDias(rs.getInt("duracion_dias"));
        trat.setTipo(rs.getString("tipo"));
        return trat;
    }

    private List<Tratamiento> mapResultSetToList(ResultSet rs) throws SQLException {
        List<Tratamiento> lista = new ArrayList<>();
        while (rs.next()) {
            lista.add(mapResultSetToTratamiento(rs));
        }
        return lista;
    }
}
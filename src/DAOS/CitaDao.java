/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import Entidades.Cita;
import Entidades.Mascota;
import basedatos.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import servicio.ICrudDao;

public class CitaDao implements ICrudDao<Cita> {
    
    private Connection getConnection() throws SQLException {
        return new conexion().conectar();
    }
    
    @Override
    public void create(Cita o) throws Exception {
        String sql = "INSERT INTO citas (motivo, estado, fecha, hora, mascota_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setString(1, o.getMotivo());
            ps.setString(2, o.getEstado());
            ps.setString(3, o.getFecha());
            ps.setString(4, o.getHora());
            ps.setInt(5, o.getMascota().getIdmascota());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new Exception("Error al crear cita: " + e.getMessage(), e);
        }
    }

    @Override
    public void update(Cita o) throws Exception {
        String sql = "UPDATE citas SET motivo=?, estado=?, fecha=?, hora=?, mascota_id=? WHERE id=?";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setString(1, o.getMotivo());
            ps.setString(2, o.getEstado());
            ps.setString(3, o.getFecha());
            ps.setString(4, o.getHora());
            ps.setInt(5, o.getMascota().getIdmascota());
            ps.setInt(6, o.getId());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new Exception("Error al actualizar cita: " + e.getMessage(), e);
        }
    }

    @Override
    public void delete(Cita o) throws Exception {
        String sql = "DELETE FROM citas WHERE id=?";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setInt(1, o.getId());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new Exception("Error al eliminar cita: " + e.getMessage(), e);
        }
    }

    @Override
    public Cita find(Object o) throws Exception {
        String sql = "SELECT c.*, m.nombre as mascota_nombre FROM citas c " +
                    "LEFT JOIN mascotas m ON c.mascota_id = m.id WHERE c.id=?";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setInt(1, (Integer) o);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToCita(rs);
                }
            }
        } catch (SQLException e) {
            throw new Exception("Error al buscar cita: " + e.getMessage(), e);
        }
        return null;
    }

    @Override
    public List<Cita> readAll() throws Exception {
        String sql = "SELECT c.*, m.nombre as mascota_nombre FROM citas c " +
                    "LEFT JOIN mascotas m ON c.mascota_id = m.id";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            return mapResultSetToList(rs);
            
        } catch (SQLException e) {
            throw new Exception("Error al listar citas: " + e.getMessage(), e);
        }
    }

    public List<Cita> findByMascota(int mascotaId) throws Exception {
        String sql = "SELECT c.*, m.nombre as mascota_nombre FROM citas c " +
                    "LEFT JOIN mascotas m ON c.mascota_id = m.id WHERE c.mascota_id=?";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setInt(1, mascotaId);
            try (ResultSet rs = ps.executeQuery()) {
                return mapResultSetToList(rs);
            }
        } catch (SQLException e) {
            throw new Exception("Error al buscar citas por mascota: " + e.getMessage(), e);
        }
    }

    public List<Cita> findByFecha(String fecha) throws Exception {
        String sql = "SELECT c.*, m.nombre as mascota_nombre FROM citas c " +
                    "LEFT JOIN mascotas m ON c.mascota_id = m.id WHERE c.fecha=?";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setString(1, fecha);
            try (ResultSet rs = ps.executeQuery()) {
                return mapResultSetToList(rs);
            }
        } catch (SQLException e) {
            throw new Exception("Error al buscar citas por fecha: " + e.getMessage(), e);
        }
    }

    public List<Cita> findByEstado(String estado) throws Exception {
        String sql = "SELECT c.*, m.nombre as mascota_nombre FROM citas c " +
                    "LEFT JOIN mascotas m ON c.mascota_id = m.id WHERE c.estado=?";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setString(1, estado);
            try (ResultSet rs = ps.executeQuery()) {
                return mapResultSetToList(rs);
            }
        } catch (SQLException e) {
            throw new Exception("Error al buscar citas por estado: " + e.getMessage(), e);
        }
    }

    private Cita mapResultSetToCita(ResultSet rs) throws SQLException {
        Cita cita = new Cita();
        cita.setId(rs.getInt("id"));
        cita.setMotivo(rs.getString("motivo"));
        cita.setEstado(rs.getString("estado"));
        cita.setFecha(rs.getString("fecha"));
        cita.setHora(rs.getString("hora"));
        
        // Mapear mascota
        Mascota mascota = new Mascota();
        mascota.setIdmascota(rs.getInt("mascota_id"));
        mascota.setNombre(rs.getString("mascota_nombre"));
        cita.setMascota(mascota);
        
        return cita;
    }

    private List<Cita> mapResultSetToList(ResultSet rs) throws SQLException {
        List<Cita> lista = new ArrayList<>();
        while (rs.next()) {
            lista.add(mapResultSetToCita(rs));
        }
        return lista;
    }
}
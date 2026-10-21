/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import Entidades.Diagnostico;
import Entidades.Mascota;
import basedatos.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import servicio.ICrudDao;

public class DiagnosticoDao implements ICrudDao<Diagnostico> {
    
    private Connection getConnection() throws SQLException {
        return new conexion().conectar();
    }
    
    @Override
    public void create(Diagnostico o) throws Exception {
        String sql = "INSERT INTO diagnosticos (descripcion, fecha, observaciones, mascota_id, veterinario_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setString(1, o.getDescripcion());
            ps.setString(2, o.getFecha());
            ps.setString(3, o.getObservaciones());
            ps.setInt(4, o.getMascota().getIdmascota());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new Exception("Error al crear diagnóstico: " + e.getMessage(), e);
        }
    }

    @Override
    public void update(Diagnostico o) throws Exception {
        String sql = "UPDATE diagnosticos SET descripcion=?, observaciones=?, fecha=? WHERE id=?";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setString(1, o.getDescripcion());
            ps.setString(2, o.getObservaciones());
            ps.setString(3, o.getFecha());
            ps.setInt(4, o.getId());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new Exception("Error al actualizar diagnóstico: " + e.getMessage(), e);
        }
    }

    @Override
    public void delete(Diagnostico o) throws Exception {
        String sql = "DELETE FROM diagnosticos WHERE id=?";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setInt(1, o.getId());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new Exception("Error al eliminar diagnóstico: " + e.getMessage(), e);
        }
    }

    @Override
    public Diagnostico find(Object o) throws Exception {
        String sql = "SELECT d.*, m.nombre as mascota_nombre, v.nombre as vet_nombre, v.apellido as vet_apellido " +
                    "FROM diagnosticos d " +
                    "LEFT JOIN mascotas m ON d.mascota_id = m.id " +
                    "LEFT JOIN veterinarios v ON d.veterinario_id = v.id " +
                    "WHERE d.id=?";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setInt(1, (Integer) o);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToDiagnostico(rs);
                }
            }
        } catch (SQLException e) {
            throw new Exception("Error al buscar diagnóstico: " + e.getMessage(), e);
        }
        return null;
    }

    @Override
    public List<Diagnostico> readAll() throws Exception {
        String sql = "SELECT d.*, m.nombre as mascota_nombre, v.nombre as vet_nombre, v.apellido as vet_apellido " +
                    "FROM diagnosticos d " +
                    "LEFT JOIN mascotas m ON d.mascota_id = m.id " +
                    "LEFT JOIN veterinarios v ON d.veterinario_id = v.id";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            return mapResultSetToList(rs);
            
        } catch (SQLException e) {
            throw new Exception("Error al listar diagnósticos: " + e.getMessage(), e);
        }
    }

    public List<Diagnostico> findByMascota(int mascotaId) throws Exception {
        String sql = "SELECT d.*, m.nombre as mascota_nombre, v.nombre as vet_nombre, v.apellido as vet_apellido " +
                    "FROM diagnosticos d " +
                    "LEFT JOIN mascotas m ON d.mascota_id = m.id " +
                    "LEFT JOIN veterinarios v ON d.veterinario_id = v.id " +
                    "WHERE d.mascota_id=?";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setInt(1, mascotaId);
            try (ResultSet rs = ps.executeQuery()) {
                return mapResultSetToList(rs);
            }
        } catch (SQLException e) {
            throw new Exception("Error al buscar diagnósticos por mascota: " + e.getMessage(), e);
        }
    }

    private Diagnostico mapResultSetToDiagnostico(ResultSet rs) throws SQLException {
        Diagnostico diag = new Diagnostico();
        diag.setId(rs.getInt("id"));
        diag.setDescripcion(rs.getString("descripcion"));
        diag.setFecha(rs.getString("fecha"));
        diag.setObservaciones(rs.getString("observaciones"));
        
        // Mapear mascota
        Mascota mascota = new Mascota();
        mascota.setIdmascota(rs.getInt("mascota_id"));
        mascota.setNombre(rs.getString("mascota_nombre"));
        diag.setMascota(mascota);
        
        
        return diag;
    }

    private List<Diagnostico> mapResultSetToList(ResultSet rs) throws SQLException {
        List<Diagnostico> lista = new ArrayList<>();
        while (rs.next()) {
            lista.add(mapResultSetToDiagnostico(rs));
        }
        return lista;
    }
}
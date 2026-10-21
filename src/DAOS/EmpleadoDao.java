/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import Entidades.Empleado;
import basedatos.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import servicio.ICrudDao;

public class EmpleadoDao implements ICrudDao<Empleado> {
    
    private Connection getConnection() throws SQLException {
        return new conexion().conectar();
    }
    
    @Override
    public void create(Empleado o) throws Exception {
        // USANDO PROCEDIMIENTO ALMACENADO
        String sql = "CALL sp_InsertarEmpleado(?, ?, ?, ?, ?, ?, ?)";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            // Parámetros para el procedimiento almacenado
            ps.setString(1, o.getUsername());
            ps.setString(2, o.getPassword());
            ps.setString(3, "ASISTENTE"); // Rol por defecto, puedes cambiarlo según necesites
            ps.setString(4, o.getEmail());
            ps.setString(5, o.getNombres());
            ps.setString(6, o.getApellidos());
            ps.setString(7, o.getTelefono());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new Exception("Error al crear empleado: " + e.getMessage(), e);
        }
    }

    @Override
    public void update(Empleado o) throws Exception {
        // USANDO PROCEDIMIENTO ALMACENADO
        String sql = "CALL sp_ActualizarEmpleado(?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            // Convertir el id de String a int para el procedimiento
            int id = Integer.parseInt(o.getidempleado());
            
            ps.setInt(1, id);
            ps.setString(2, o.getUsername());
            ps.setString(3, o.getPassword());
            ps.setString(4, "ASISTENTE"); // Rol por defecto
            ps.setString(5, o.getEmail());
            ps.setString(6, o.getNombres());
            ps.setString(7, o.getApellidos());
            ps.setString(8, o.getTelefono());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new Exception("Error al actualizar empleado: " + e.getMessage(), e);
        } catch (NumberFormatException e) {
            throw new Exception("Error: ID de empleado no válido", e);
        }
    }

    @Override
    public void delete(Empleado o) throws Exception {
        // USANDO PROCEDIMIENTO ALMACENADO (eliminación lógica)
        String sql = "CALL sp_EliminarEmpleado(?)";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            // Convertir el id de String a int para el procedimiento
            int id = Integer.parseInt(o.getidempleado());
            
            ps.setInt(1, id);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new Exception("Error al eliminar empleado: " + e.getMessage(), e);
        } catch (NumberFormatException e) {
            throw new Exception("Error: ID de empleado no válido", e);
        }
    }

    @Override
    public Empleado find(Object o) throws Exception {
        // USANDO PROCEDIMIENTO ALMACENADO
        String sql = "CALL sp_BuscarEmpleadoPorId(?)";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            // Convertir el id de String a int para el procedimiento
            int id = Integer.parseInt(o.toString());
            
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToEmpleado(rs);
                }
            }
        } catch (SQLException e) {
            throw new Exception("Error al buscar empleado: " + e.getMessage(), e);
        } catch (NumberFormatException e) {
            throw new Exception("Error: ID de empleado no válido", e);
        }
        return null;
    }

    @Override
    public List<Empleado> readAll() throws Exception {
        // USANDO PROCEDIMIENTO ALMACENADO
        String sql = "CALL sp_ListarEmpleados()";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            return mapResultSetToList(rs);
            
        } catch (SQLException e) {
            throw new Exception("Error al listar empleados: " + e.getMessage(), e);
        }
    }

    public Empleado autenticar(String username, String password) throws Exception {
        // USANDO PROCEDIMIENTO ALMACENADO
        String sql = "CALL sp_AutenticarEmpleado(?, ?)";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setString(1, username);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToEmpleado(rs);
                }
            }
        } catch (SQLException e) {
            throw new Exception("Error en autenticación: " + e.getMessage(), e);
        }
        return null;
    }

    public boolean existeUsername(String username) throws Exception {
        // USANDO PROCEDIMIENTO ALMACENADO (crearemos uno específico)
        String sql = "CALL sp_VerificarUsername(?)";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("existe") > 0;
                }
            }
        } catch (SQLException e) {
            throw new Exception("Error al verificar username: " + e.getMessage(), e);
        }
        return false;
    }

    // Método adicional para buscar empleados por rol
    public List<Empleado> findByRol(String rol) throws Exception {
        String sql = "SELECT * FROM empleados WHERE rol = ? AND activo = true";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setString(1, rol);
            try (ResultSet rs = ps.executeQuery()) {
                return mapResultSetToList(rs);
            }
        } catch (SQLException e) {
            throw new Exception("Error al buscar empleados por rol: " + e.getMessage(), e);
        }
    }

    // Método para activar/desactivar empleado
    public void cambiarEstadoEmpleado(int id, boolean activo) throws Exception {
        String sql = "UPDATE empleados SET activo = ? WHERE id = ?";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setBoolean(1, activo);
            ps.setInt(2, id);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new Exception("Error al cambiar estado del empleado: " + e.getMessage(), e);
        }
    }

    private Empleado mapResultSetToEmpleado(ResultSet rs) throws SQLException {
        Empleado empleado = new Empleado();
        empleado.setidempleado(rs.getString("id"));
        empleado.setUsername(rs.getString("username"));
        empleado.setPassword(rs.getString("password"));
        empleado.setEmail(rs.getString("email"));
        empleado.setNombres(rs.getString("nombres"));
        empleado.setApellidos(rs.getString("apellidos"));
        empleado.setTelefono(rs.getString("telefono"));
        return empleado;
    }

    private List<Empleado> mapResultSetToList(ResultSet rs) throws SQLException {
        List<Empleado> lista = new ArrayList<>();
        while (rs.next()) {
            lista.add(mapResultSetToEmpleado(rs));
        }
        return lista;
    }
}
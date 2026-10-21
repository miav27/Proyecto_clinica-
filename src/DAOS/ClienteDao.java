/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import Entidades.Cliente;
import basedatos.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import servicio.ICrudDao;

public class ClienteDao implements ICrudDao<Cliente> {
    
    private Connection getConnection() throws SQLException {
        return new conexion().conectar();
    }
    
    @Override
    public void create(Cliente o) throws Exception {
        // USANDO PROCEDIMIENTO ALMACENADO
        String sql = "CALL sp_InsertarCliente(?, ?, ?, ?, ?, ?, ?)";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setString(1, o.getNombre());
            ps.setString(2, o.getApellido());
            ps.setString(3, o.getTelefono());
            ps.setString(4, o.getEmail());
            ps.setString(5, o.getDireccion());
            ps.setString(6, o.getNumeroDocumento());
            ps.setString(7, o.getTipoDocumento());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new Exception("Error al crear cliente: " + e.getMessage(), e);
        }
    }

    @Override
    public void update(Cliente o) throws Exception {
        // USANDO PROCEDIMIENTO ALMACENADO
        String sql = "CALL sp_ActualizarCliente(?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setInt(1, o.getId());
            ps.setString(2, o.getNombre());
            ps.setString(3, o.getApellido());
            ps.setString(4, o.getTelefono());
            ps.setString(5, o.getEmail());
            ps.setString(6, o.getDireccion());
            ps.setString(7, o.getNumeroDocumento());
            ps.setString(8, o.getTipoDocumento());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new Exception("Error al actualizar cliente: " + e.getMessage(), e);
        }
    }

    @Override
    public void delete(Cliente o) throws Exception {
        // USANDO PROCEDIMIENTO ALMACENADO
        String sql = "CALL sp_EliminarCliente(?)";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setInt(1, o.getId());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new Exception("Error al eliminar cliente: " + e.getMessage(), e);
        }
    }

    @Override
    public Cliente find(Object o) throws Exception {
        // USANDO PROCEDIMIENTO ALMACENADO
        String sql = "CALL sp_BuscarClientePorId(?)";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setInt(1, (Integer) o);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToCliente(rs);
                }
            }
        } catch (SQLException e) {
            throw new Exception("Error al buscar cliente: " + e.getMessage(), e);
        }
        return null;
    }

    @Override
    public List<Cliente> readAll() throws Exception {
        // USANDO PROCEDIMIENTO ALMACENADO
        String sql = "CALL sp_ListarClientes()";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            return mapResultSetToList(rs);
            
        } catch (SQLException e) {
            throw new Exception("Error al listar clientes: " + e.getMessage(), e);
        }
    }

    public Cliente findByDocumento(String numeroDocumento) throws Exception {
        // USANDO PROCEDIMIENTO ALMACENADO
        String sql = "CALL sp_BuscarClientePorDocumento(?)";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setString(1, numeroDocumento);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToCliente(rs);
                }
            }
        } catch (SQLException e) {
            throw new Exception("Error al buscar cliente por documento: " + e.getMessage(), e);
        }
        return null;
    }

    private Cliente mapResultSetToCliente(ResultSet rs) throws SQLException {
        Cliente cli = new Cliente();
        cli.setId(rs.getInt("id"));
        cli.setNombre(rs.getString("nombre"));
        cli.setApellido(rs.getString("apellido"));
        cli.setTelefono(rs.getString("telefono"));
        cli.setEmail(rs.getString("email"));
        cli.setDireccion(rs.getString("direccion"));
        cli.setNumeroDocumento(rs.getString("numero_documento"));
        cli.setTipoDocumento(rs.getString("tipo_documento"));
        return cli;
    }

    private List<Cliente> mapResultSetToList(ResultSet rs) throws SQLException {
        List<Cliente> lista = new ArrayList<>();
        while (rs.next()) {
            lista.add(mapResultSetToCliente(rs));
        }
        return lista;
    }
}
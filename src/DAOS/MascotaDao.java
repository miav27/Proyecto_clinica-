package DAOS;

import Entidades.Mascota;
import basedatos.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import servicio.ICrudDao;

public class MascotaDao implements ICrudDao<Mascota> {
    
    private Connection getConnection() throws SQLException {
        return new conexion().conectar();
    }
    
    @Override
    public void create(Mascota o) throws Exception {
        String sql = "INSERT INTO mascotas (nombre, especie, raza, peso, sexo, cliente_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setString(1, o.getNombre());
            ps.setString(2, o.getEspecie());
            ps.setString(3, o.getRaza());
            ps.setDouble(4, o.getPeso());
            ps.setString(5, o.getSexo());
            ps.setInt(6, 1); // Valor temporal para cliente_id
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new Exception("Error al crear mascota: " + e.getMessage(), e);
        }
    }

    @Override
    public void update(Mascota o) throws Exception {
        String sql = "UPDATE mascotas SET nombre=?, especie=?, raza=?, peso=?, sexo=? WHERE id=?";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setString(1, o.getNombre());
            ps.setString(2, o.getEspecie());
            ps.setString(3, o.getRaza());
            ps.setDouble(4, o.getPeso());
            ps.setString(5, o.getSexo());
            ps.setInt(6, o.getIdmascota());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new Exception("Error al actualizar mascota: " + e.getMessage(), e);
        }
    }

    @Override
    public void delete(Mascota o) throws Exception {
        String sql = "DELETE FROM mascotas WHERE id=?";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setInt(1, o.getIdmascota());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new Exception("Error al eliminar mascota: " + e.getMessage(), e);
        }
    }

    @Override
    public Mascota find(Object o) throws Exception {
        String sql = "SELECT * FROM mascotas WHERE id=?";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setInt(1, (Integer) o);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToMascota(rs);
                }
            }
        } catch (SQLException e) {
            throw new Exception("Error al buscar mascota: " + e.getMessage(), e);
        }
        return null;
    }

    @Override
    public List<Mascota> readAll() throws Exception {
        String sql = "SELECT * FROM mascotas";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            return mapResultSetToList(rs);
            
        } catch (SQLException e) {
            throw new Exception("Error al listar mascotas: " + e.getMessage(), e);
        }
    }

    public List<Mascota> findByCliente(int clienteId) throws Exception {
        String sql = "SELECT * FROM mascotas WHERE cliente_id=?";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setInt(1, clienteId);
            try (ResultSet rs = ps.executeQuery()) {
                return mapResultSetToList(rs);
            }
        } catch (SQLException e) {
            throw new Exception("Error al buscar mascotas por cliente: " + e.getMessage(), e);
        }
    }

    public List<Mascota> findByEspecie(String especie) throws Exception {
        String sql = "SELECT * FROM mascotas WHERE especie=?";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setString(1, especie);
            try (ResultSet rs = ps.executeQuery()) {
                return mapResultSetToList(rs);
            }
        } catch (SQLException e) {
            throw new Exception("Error al buscar mascotas por especie: " + e.getMessage(), e);
        }
    }

    public List<Mascota> findByNombre(String nombre) throws Exception {
        String sql = "SELECT * FROM mascotas WHERE nombre LIKE ?";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setString(1, "%" + nombre + "%");
            try (ResultSet rs = ps.executeQuery()) {
                return mapResultSetToList(rs);
            }
        } catch (SQLException e) {
            throw new Exception("Error al buscar mascotas por nombre: " + e.getMessage(), e);
        }
    }

    private Mascota mapResultSetToMascota(ResultSet rs) throws SQLException {
        Mascota mascota = new Mascota();
        mascota.setIdmascota(rs.getInt("id"));
        mascota.setNombre(rs.getString("nombre"));
        mascota.setEspecie(rs.getString("especie"));
        mascota.setRaza(rs.getString("raza"));
        mascota.setPeso(rs.getDouble("peso"));
        mascota.setSexo(rs.getString("sexo"));
        return mascota;
    }

    private List<Mascota> mapResultSetToList(ResultSet rs) throws SQLException {
        List<Mascota> lista = new ArrayList<>();
        while (rs.next()) {
            lista.add(mapResultSetToMascota(rs));
        }
        return lista;
    }
}
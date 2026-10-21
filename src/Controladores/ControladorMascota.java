package Controladores;

import DAOS.MascotaDao;
import Entidades.Mascota;
import java.util.List;

public class ControladorMascota {
    private MascotaDao mascotaDao;

    public ControladorMascota() {
        this.mascotaDao = new MascotaDao();
    }

    public void registrarMascota(Mascota mascota) {
        try {
            mascotaDao.create(mascota);
            System.out.println("Mascota registrada: " + mascota.getNombre());
        } catch (Exception e) {
            System.err.println("Error al registrar mascota: " + e.getMessage());
        }
    }

    public Mascota buscarMascotaPorId(int id) {
        try {
            return mascotaDao.find(id);
        } catch (Exception e) {
            System.err.println("Error al buscar mascota: " + e.getMessage());
            return null;
        }
    }

    public List<Mascota> buscarMascotasPorNombre(String nombre) {
        try {
            return mascotaDao.findByNombre(nombre);
        } catch (Exception e) {
            System.err.println("Error al buscar mascotas por nombre: " + e.getMessage());
            return null;
        }
    }

    public List<Mascota> buscarMascotasPorEspecie(String especie) {
        try {
            return mascotaDao.findByEspecie(especie);
        } catch (Exception e) {
            System.err.println("Error al buscar mascotas por especie: " + e.getMessage());
            return null;
        }
    }

    public List<Mascota> buscarMascotasPorCliente(int clienteId) {
        try {
            return mascotaDao.findByCliente(clienteId);
        } catch (Exception e) {
            System.err.println("Error al buscar mascotas por cliente: " + e.getMessage());
            return null;
        }
    }

    public void actualizarMascota(Mascota mascota) {
        try {
            mascotaDao.update(mascota);
            System.out.println("Mascota actualizada: " + mascota.getNombre());
        } catch (Exception e) {
            System.err.println("Error al actualizar mascota: " + e.getMessage());
        }
    }

    public void eliminarMascota(Mascota mascota) {
        try {
            mascotaDao.delete(mascota);
            System.out.println("Mascota eliminada: " + mascota.getNombre());
        } catch (Exception e) {
            System.err.println("Error al eliminar mascota: " + e.getMessage());
        }
    }

    public List<Mascota> listarTodasMascotas() {
        try {
            return mascotaDao.readAll();
        } catch (Exception e) {
            System.err.println("Error al obtener lista de mascotas: " + e.getMessage());
            return null;
        }
    }

    public void listarMascotas() {
        try {
            List<Mascota> mascotas = mascotaDao.readAll();
            for (Mascota mascota : mascotas) {
                System.out.println("ID: " + mascota.getIdmascota()+ 
                                 " | Nombre: " + mascota.getNombre() + 
                                 " | Especie: " + mascota.getEspecie() + 
                                 " | Raza: " + mascota.getRaza() + 
                                 " | Peso: " + mascota.getPeso() + " kg" + 
                                 " | Sexo: " + mascota.getSexo());
            }
        } catch (Exception e) {
            System.err.println("Error al listar mascotas: " + e.getMessage());
        }
    }
}
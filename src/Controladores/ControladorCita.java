package Controladores;

import DAOS.CitaDao;
import Entidades.Cita;
import Entidades.Mascota;
import java.util.List;

public class ControladorCita {
    private CitaDao citaDao;

    public ControladorCita() {
        this.citaDao = new CitaDao();
    }

    public void registrarCita(Cita cita) {
        try {
            citaDao.create(cita);
            System.out.println("Cita registrada para mascota: " + cita.getMascota().getNombre());
        } catch (Exception e) {
            System.err.println("Error al registrar cita: " + e.getMessage());
        }
    }

    public Cita buscarCitaPorId(int id) {
        try {
            return citaDao.find(id);
        } catch (Exception e) {
            System.err.println("Error al buscar cita: " + e.getMessage());
            return null;
        }
    }

    public void actualizarCita(Cita cita) {
        try {
            citaDao.update(cita);
            System.out.println("Cita actualizada: ID " + cita.getId());
        } catch (Exception e) {
            System.err.println("Error al actualizar cita: " + e.getMessage());
        }
    }

    public void eliminarCita(Cita cita) {
        try {
            citaDao.delete(cita);
            System.out.println("Cita eliminada: ID " + cita.getId());
        } catch (Exception e) {
            System.err.println("Error al eliminar cita: " + e.getMessage());
        }
    }

    public List<Cita> listarTodasCitas() {
        try {
            return citaDao.readAll();
        } catch (Exception e) {
            System.err.println("Error al obtener lista de citas: " + e.getMessage());
            return null;
        }
    }

    public List<Cita> buscarCitasPorMascota(Mascota mascota) {
        try {
            return citaDao.findByMascota(mascota.getIdmascota());
        } catch (Exception e) {
            System.err.println("Error al buscar citas por mascota: " + e.getMessage());
            return null;
        }
    }

    public List<Cita> buscarCitasPorFecha(String fecha) {
        try {
            return citaDao.findByFecha(fecha);
        } catch (Exception e) {
            System.err.println("Error al buscar citas por fecha: " + e.getMessage());
            return null;
        }
    }

    public List<Cita> buscarCitasPorEstado(String estado) {
        try {
            return citaDao.findByEstado(estado);
        } catch (Exception e) {
            System.err.println("Error al buscar citas por estado: " + e.getMessage());
            return null;
        }
    }

    public void cambiarEstadoCita(int idCita, String nuevoEstado) {
        try {
            Cita cita = citaDao.find(idCita);
            if (cita != null) {
                cita.setEstado(nuevoEstado);
                citaDao.update(cita);
                System.out.println("Estado de cita actualizado a: " + nuevoEstado);
            }
        } catch (Exception e) {
            System.err.println("Error al cambiar estado de cita: " + e.getMessage());
        }
    }

    public void listarCitas() {
        try {
            List<Cita> citas = citaDao.readAll();
            for (Cita cita : citas) {
                System.out.println("ID: " + cita.getId() + 
                                 " | Fecha: " + cita.getFecha() + 
                                 " | Hora: " + cita.getHora() + 
                                 " | Mascota: " + cita.getMascota().getNombre() + 
                                 " | Estado: " + cita.getEstado() + 
                                 " | Motivo: " + cita.getMotivo());
            }
        } catch (Exception e) {
            System.err.println("Error al listar citas: " + e.getMessage());
        }
    }
}
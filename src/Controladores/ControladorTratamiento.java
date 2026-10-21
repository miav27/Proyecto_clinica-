package Controladores;

import DAOS.TratamientoDao;
import Entidades.Tratamiento;
import java.util.List;

public class ControladorTratamiento {
    private TratamientoDao tratamientoDao;

    public ControladorTratamiento() {
        this.tratamientoDao = new TratamientoDao();
    }

    public void registrarTratamiento(Tratamiento tratamiento) {
        try {
            tratamientoDao.create(tratamiento);
            System.out.println("Tratamiento registrado: " + tratamiento.getNombre());
        } catch (Exception e) {
            System.err.println("Error al registrar tratamiento: " + e.getMessage());
        }
    }

    public Tratamiento buscarTratamientoPorId(int id) {
        try {
            return tratamientoDao.find(id);
        } catch (Exception e) {
            System.err.println("Error al buscar tratamiento: " + e.getMessage());
            return null;
        }
    }

    public void actualizarTratamiento(Tratamiento tratamiento) {
        try {
            tratamientoDao.update(tratamiento);
            System.out.println("Tratamiento actualizado: " + tratamiento.getNombre());
        } catch (Exception e) {
            System.err.println("Error al actualizar tratamiento: " + e.getMessage());
        }
    }

    public void eliminarTratamiento(Tratamiento tratamiento) {
        try {
            tratamientoDao.delete(tratamiento);
            System.out.println("Tratamiento eliminado: " + tratamiento.getNombre());
        } catch (Exception e) {
            System.err.println("Error al eliminar tratamiento: " + e.getMessage());
        }
    }

    public List<Tratamiento> listarTodosTratamientos() {
        try {
            return tratamientoDao.readAll();
        } catch (Exception e) {
            System.err.println("Error al obtener lista de tratamientos: " + e.getMessage());
            return null;
        }
    }

    public List<Tratamiento> buscarTratamientosPorTipo(String tipo) {
        try {
            return tratamientoDao.findByTipo(tipo);
        } catch (Exception e) {
            System.err.println("Error al buscar tratamientos por tipo: " + e.getMessage());
            return null;
        }
    }


    public void listarTratamientos() {
        try {
            List<Tratamiento> tratamientos = tratamientoDao.readAll();
            for (Tratamiento tratamiento : tratamientos) {
                System.out.println("ID: " + tratamiento.getId() + 
                                 " | Nombre: " + tratamiento.getNombre() + 
                                 " | Tipo: " + tratamiento.getTipo() + 
                                 " | Costo: $" + tratamiento.getCosto() + 
                                 " | Duración: " + tratamiento.getDuracionDias() + " días");
            }
        } catch (Exception e) {
            System.err.println("Error al listar tratamientos: " + e.getMessage());
        }
    }
}
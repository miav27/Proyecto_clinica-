package Controladores;

import DAOS.DiagnosticoDao;
import Entidades.Diagnostico;
import Entidades.Mascota;
import java.util.List;

public class ControladorDiagnostico {
    private DiagnosticoDao diagnosticoDao;

    public ControladorDiagnostico() {
        this.diagnosticoDao = new DiagnosticoDao();
    }

    public void registrarDiagnostico(Diagnostico diagnostico) {
        try {
            diagnosticoDao.create(diagnostico);
            System.out.println("Diagnóstico registrado para mascota: " + diagnostico.getMascota().getNombre());
        } catch (Exception e) {
            System.err.println("Error al registrar diagnóstico: " + e.getMessage());
        }
    }

    public Diagnostico buscarDiagnosticoPorId(int id) {
        try {
            return diagnosticoDao.find(id);
        } catch (Exception e) {
            System.err.println("Error al buscar diagnóstico: " + e.getMessage());
            return null;
        }
    }

    public void actualizarDiagnostico(Diagnostico diagnostico) {
        try {
            diagnosticoDao.update(diagnostico);
            System.out.println("Diagnóstico actualizado: ID " + diagnostico.getId());
        } catch (Exception e) {
            System.err.println("Error al actualizar diagnóstico: " + e.getMessage());
        }
    }

    public void eliminarDiagnostico(Diagnostico diagnostico) {
        try {
            diagnosticoDao.delete(diagnostico);
            System.out.println("Diagnóstico eliminado: ID " + diagnostico.getId());
        } catch (Exception e) {
            System.err.println("Error al eliminar diagnóstico: " + e.getMessage());
        }
    }

    public List<Diagnostico> listarTodosDiagnosticos() {
        try {
            return diagnosticoDao.readAll();
        } catch (Exception e) {
            System.err.println("Error al obtener lista de diagnósticos: " + e.getMessage());
            return null;
        }
    }

    public List<Diagnostico> buscarDiagnosticosPorMascota(Mascota mascota) {
        try {
            return diagnosticoDao.findByMascota(mascota.getIdmascota());
        } catch (Exception e) {
            System.err.println("Error al buscar diagnósticos por mascota: " + e.getMessage());
            return null;
        }
    }

    public List<Diagnostico> buscarDiagnosticosPorFecha(String fecha) {
        try {
            return diagnosticoDao.findByMascota(0);
        } catch (Exception e) {
            System.err.println("Error al buscar diagnósticos por fecha: " + e.getMessage());
            return null;
        }
    }

    public void listarDiagnosticos() {
        try {
            List<Diagnostico> diagnosticos = diagnosticoDao.readAll();
            for (Diagnostico diagnostico : diagnosticos) {
                System.out.println("ID: " + diagnostico.getId() + 
                                 " | Fecha: " + diagnostico.getFecha() + 
                                 " | Mascota: " + diagnostico.getMascota().getNombre() + 
                                 " | Descripción: " + diagnostico.getDescripcion());
            }
        } catch (Exception e) {
            System.err.println("Error al listar diagnósticos: " + e.getMessage());
        }
    }
}
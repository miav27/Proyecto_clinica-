package Controladores;

import DAOS.EmpleadoDao;
import Entidades.Empleado;
import java.util.List;

public class ControladorEmpleado {
    private EmpleadoDao empleadoDao;

    public ControladorEmpleado() {
        this.empleadoDao = new EmpleadoDao();
    }

    public void registrarEmpleado(Empleado empleado) throws Exception {  // Agregar throws Exception
        try {
            empleadoDao.create(empleado);
            System.out.println("Empleado registrado: " + empleado.getNombres() + " " + empleado.getApellidos());
        } catch (Exception e) {
            throw new Exception("Error al registrar empleado: " + e.getMessage()); // Propagar la excepción
        }
    }

    public Empleado buscarEmpleadoPorId(String id) {
        try {
            return empleadoDao.find(id);
        } catch (Exception e) {
            System.err.println("Error al buscar empleado: " + e.getMessage());
            return null;
        }
    }

    public Empleado buscarEmpleadoPorUsername(String username) {
        try {
            List<Empleado> empleados = empleadoDao.readAll();
            for (Empleado empleado : empleados) {
                if (empleado.getUsername().equals(username)) {
                    return empleado;
                }
            }
        } catch (Exception e) {
            System.err.println("Error al buscar empleado por username: " + e.getMessage());
        }
        return null;
    }

    public void actualizarEmpleado(Empleado empleado) {
        try {
            empleadoDao.update(empleado);
            System.out.println("Empleado actualizado: " + empleado.getNombres() + " " + empleado.getApellidos());
        } catch (Exception e) {
            System.err.println("Error al actualizar empleado: " + e.getMessage());
        }
    }

    public void eliminarEmpleado(Empleado empleado) {
        try {
            empleadoDao.delete(empleado);
            System.out.println("Empleado eliminado: " + empleado.getNombres() + " " + empleado.getApellidos());
        } catch (Exception e) {
            System.err.println("Error al eliminar empleado: " + e.getMessage());
        }
    }

    public List<Empleado> listarTodosEmpleados() {
        try {
            return empleadoDao.readAll();
        } catch (Exception e) {
            System.err.println("Error al obtener lista de empleados: " + e.getMessage());
            return null;
        }
    }

    public boolean autenticarEmpleado(String username, String password) {
        try {
            Empleado empleado = empleadoDao.autenticar(username, password);
            return empleado != null;
        } catch (Exception e) {
            System.err.println("Error en autenticación: " + e.getMessage());
            return false;
        }
    }

    public Empleado obtenerEmpleadoAutenticado(String username, String password) {
        try {
            return empleadoDao.autenticar(username, password);
        } catch (Exception e) {
            System.err.println("Error al obtener empleado autenticado: " + e.getMessage());
            return null;
        }
    }

    public boolean existeUsername(String username) {
        try {
            return empleadoDao.existeUsername(username);
        } catch (Exception e) {
            System.err.println("Error al verificar username: " + e.getMessage());
            return false;
        }
    }

    public void listarEmpleados() {
        try {
            List<Empleado> empleados = empleadoDao.readAll();
            for (Empleado empleado : empleados) {
                System.out.println("ID: " + empleado.getidempleado()+ 
                                 " | Nombre: " + empleado.getNombres() + " " + empleado.getApellidos() + 
                                 " | Usuario: " + empleado.getUsername() + 
                                 " | Email: " + empleado.getEmail());
            }
        } catch (Exception e) {
            System.err.println("Error al listar empleados: " + e.getMessage());
        }
    }
}
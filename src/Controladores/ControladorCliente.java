/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import DAOS.ClienteDao;
import Entidades.Cliente;
import java.util.List;

public class ControladorCliente {
    private ClienteDao clienteDao;

    public ControladorCliente() {
        this.clienteDao = new ClienteDao();
    }

    public void registrarCliente(Cliente cliente) {
        try {
            clienteDao.create(cliente);
            System.out.println("Cliente registrado: " + cliente.getNombre() + " " + cliente.getApellido());
        } catch (Exception e) {
            System.err.println("Error al registrar cliente: " + e.getMessage());
        }
    }

    public Cliente buscarClientePorId(int id) {
        try {
            return clienteDao.find(id);
        } catch (Exception e) {
            System.err.println("Error al buscar cliente: " + e.getMessage());
            return null;
        }
    }

    public Cliente buscarClientePorDocumento(String numeroDocumento) {
        try {
            return clienteDao.findByDocumento(numeroDocumento);
        } catch (Exception e) {
            System.err.println("Error al buscar cliente por documento: " + e.getMessage());
            return null;
        }
    }

    public void actualizarCliente(Cliente cliente) {
        try {
            clienteDao.update(cliente);
            System.out.println("Cliente actualizado: " + cliente.getNombre() + " " + cliente.getApellido());
        } catch (Exception e) {
            System.err.println("Error al actualizar cliente: " + e.getMessage());
        }
    }

    public void eliminarCliente(Cliente cliente) {
        try {
            clienteDao.delete(cliente);
            System.out.println("Cliente eliminado: " + cliente.getNombre() + " " + cliente.getApellido());
        } catch (Exception e) {
            System.err.println("Error al eliminar cliente: " + e.getMessage());
        }
    }

    public List<Cliente> listarTodosClientes() {
        try {
            return clienteDao.readAll();
        } catch (Exception e) {
            System.err.println("Error al obtener lista de clientes: " + e.getMessage());
            return null;
        }
    }

    

    public void listarClientes() {
        try {
            List<Cliente> clientes = clienteDao.readAll();
            for (Cliente cliente : clientes) {
                System.out.println("ID: " + cliente.getId() + 
                                 " | Nombre: " + cliente.getNombre() + " " + cliente.getApellido() + 
                                 " | Documento: " + cliente.getNumeroDocumento() + 
                                 " | Teléfono: " + cliente.getTelefono());
            }
        } catch (Exception e) {
            System.err.println("Error al listar clientes: " + e.getMessage());
        }
    }
}
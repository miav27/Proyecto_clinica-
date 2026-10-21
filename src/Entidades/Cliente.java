/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.List;

public class Cliente extends Persona {
    private String idcliente;
    private String nombre;
    private String numeroDocumento;
    private String tipoDocumento;
    private List<Mascota> mascotas;

    public Cliente() {}

    public Cliente(String idcliente, String nombre, String numeroDocumento, String tipoDocumento, List<Mascota> mascotas) {
        this.idcliente = idcliente;
        this.nombre = nombre;
        this.numeroDocumento = numeroDocumento;
        this.tipoDocumento = tipoDocumento;
        this.mascotas = mascotas;
    }

    public String getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(String idcliente) {
        this.idcliente = idcliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

}



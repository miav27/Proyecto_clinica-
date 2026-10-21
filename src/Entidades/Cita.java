/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Entidades;

import java.util.List;

public class Cita {
    private int id; // <- AGREGAR ESTE CAMPO
    private String motivo;
    private String estado;
    private String fecha;
    private String hora;
    private Mascota mascota;
    private List<Tratamiento> tratamientos;

    public Cita() {}

    public Cita(String motivo, String estado, String fecha, String hora, 
                 Mascota mascota) {
        this.motivo = motivo;
        this.estado = estado;
        this.fecha = fecha;
        this.hora = hora;
        this.mascota = mascota;
    }

    // AGREGAR ESTOS MÉTODOS
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public String getHora() { return hora; }
    public void setHora(String hora) { this.hora = hora; }
  
    public Mascota getMascota() { return mascota; }
    public void setMascota(Mascota mascota) { this.mascota = mascota; }
    public List<Tratamiento> getTratamientos() { return tratamientos; }
    public void setTratamientos(List<Tratamiento> tratamientos) { this.tratamientos = tratamientos; }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

public class Diagnostico {
    private int id; 
    private String descripcion;
    private String fecha;
    private String observaciones;
    private Mascota mascota;

    public Diagnostico() {}

    public Diagnostico(String descripcion, String fecha, String observaciones, 
                      Mascota mascota) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.observaciones = observaciones;
        this.mascota = mascota;
    }

    // AGREGAR ESTOS MÉTODOS
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
    public Mascota getMascota() { return mascota; }
    public void setMascota(Mascota mascota) { this.mascota = mascota; }
}
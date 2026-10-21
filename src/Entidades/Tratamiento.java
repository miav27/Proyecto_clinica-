/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

public class Tratamiento {
    private int id; // <- AGREGAR ESTE CAMPO
    private String nombre;
    private String descripcion;
    private double costo;
    private int duracionDias;
    private String tipo;

    public Tratamiento() {}

    public Tratamiento(String nombre, String descripcion, double costo, int duracionDias, String tipo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
        this.duracionDias = duracionDias;
        this.tipo = tipo;
    }

    // AGREGAR ESTOS MÉTODOS
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public double getCosto() { return costo; }
    public void setCosto(double costo) { this.costo = costo; }
    public int getDuracionDias() { return duracionDias; }
    public void setDuracionDias(int duracionDias) { this.duracionDias = duracionDias; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}
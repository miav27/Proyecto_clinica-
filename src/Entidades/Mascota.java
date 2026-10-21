/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

public class Mascota {
    private int idmascota; // <- AGREGAR ESTE CAMPO
    private String nombre;
    private String especie;
    private String raza;
    private double peso;
    private String sexo;

    public Mascota(int idmascota, String nombre, String especie, String raza, double peso, String sexo) {
        this.idmascota = idmascota;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.peso = peso;
        this.sexo = sexo;
    }

    

    public Mascota() {}

    public int getIdmascota() {
        return idmascota;
    }

    public void setIdmascota(int idmascota) {
        this.idmascota = idmascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }


}
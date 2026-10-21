/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;


public class Empleado {
    private String idempleado;
    private String username;
    private String password;
    private String email;
    private String nombres;
    private String apellidos;
    private String telefono;

    public Empleado() {}

    public Empleado(String idempleado, String username, String password, String email, String nombres, String apellidos, String telefono) {
        this.idempleado = idempleado;
        this.username = username;
        this.password = password;
        this.email = email;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
    }


    // Getters y Setters

    public String getidempleado() {
        return idempleado;
    }

    public void setidempleado(String idempleado) {
        this.idempleado = idempleado;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    }

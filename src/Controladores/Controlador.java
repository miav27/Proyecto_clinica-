package Controladores;


import Entidades.*;

public class Controlador {
    private ControladorCliente controladorCliente;
    private ControladorMascota controladorMascota;
    private ControladorCita controladorCita;
    private ControladorTratamiento controladorTratamiento;
    private ControladorDiagnostico controladorDiagnostico;

    public Controlador() {
        this.controladorCliente = new ControladorCliente();
        this.controladorMascota = new ControladorMascota();
        this.controladorCita = new ControladorCita();
        this.controladorTratamiento = new ControladorTratamiento();
        this.controladorDiagnostico = new ControladorDiagnostico();
    }

    // Métodos de acceso a los controladores
    public ControladorCliente getControladorCliente() 
    { return controladorCliente; }
    public ControladorMascota getControladorMascota() 
    { return controladorMascota; }
    public ControladorCita getControladorCita() 
    { return controladorCita; }
    public ControladorTratamiento getControladorTratamiento() 
    { return controladorTratamiento; }
    public ControladorDiagnostico getControladorDiagnostico() 
    { return controladorDiagnostico; }
}
package com.restaurante.amm.amimaneramodel.personal;

public abstract class Trabajador {
    // Atributos
    private int idTrabajador;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private CuentaUsuario cuentaUsuario;
    
    
    //CONSTRUCTOR
    public Trabajador(){
        cuentaUsuario = new CuentaUsuario();
    }
    
    public Trabajador(int idTrabajador, String nombre, String apellidoPaterno,
            String apellidoMaterno, CuentaUsuario cuentaUsuario){
        
        this.idTrabajador = idTrabajador;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.cuentaUsuario = new CuentaUsuario(cuentaUsuario);
    }
    public Trabajador(Trabajador trabajador){
        this.idTrabajador = trabajador.idTrabajador;
        this.nombre = trabajador.nombre;
        this.apellidoPaterno = trabajador.apellidoPaterno;
        this.apellidoMaterno = trabajador.apellidoMaterno;
        this.cuentaUsuario = new CuentaUsuario(trabajador.cuentaUsuario);
    }
     
    //Getters y Setters
    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public CuentaUsuario getCuentaUsuario() {
        return cuentaUsuario;
    }

    public void setCuentaUsuario(CuentaUsuario cuentaUsuario) {
        this.cuentaUsuario = cuentaUsuario;
    }
}

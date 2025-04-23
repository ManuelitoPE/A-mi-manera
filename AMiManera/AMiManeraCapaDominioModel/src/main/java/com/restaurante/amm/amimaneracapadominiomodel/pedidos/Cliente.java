package com.restaurante.amm.amimaneracapadominiomodel.pedidos;

public class Cliente {
    // Atributos
    private int idCliente;
    private String nombre;
    private int telefono;
    private String correo;

    // Constructor
    public Cliente(int idCliente, String nombre, int telefono, String correo) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    // Getters
    public int getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    // Setters
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    // Método toString para mostrar los datos
    @Override
    public String toString() {
        return "Cliente: " +'\n'
               + "idCliente= " + idCliente +'\n'
               + "nombre= " + nombre + '\n' +
               "telefono= " + telefono +
               "correo= " + correo + '\n';
    }
}

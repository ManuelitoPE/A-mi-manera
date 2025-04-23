package com.restaurante.amm.amimaneracapadominiomodel.clientes;

import java.util.ArrayList;
import com.restaurante.amm.amimaneracapadominiomodel.gestionmesas.Reserva;

public abstract class Cliente {
    // Atributos
    private int idCliente;
    private String nombre;
    private int telefono;
    private String correo;
    private ArrayList<Reserva> listaReservas;

    // Constructor
    public Cliente(){
        listaReservas = new ArrayList<>();
    }
    
    public Cliente(int idCliente, String nombre, int telefono, String correo,
            ArrayList<Reserva> listaReservas) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.listaReservas = new ArrayList<>(listaReservas);
    }
    
    public Cliente(Cliente cliente){
        this.idCliente = cliente.idCliente;
        this.nombre = cliente.nombre;
        this.telefono = cliente.telefono;
        this.correo = cliente.correo;
        this.listaReservas = new ArrayList<>(cliente.listaReservas);
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
    
    public ArrayList<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(ArrayList<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
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

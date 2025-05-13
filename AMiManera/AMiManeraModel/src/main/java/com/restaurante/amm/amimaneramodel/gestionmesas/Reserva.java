package com.restaurante.amm.amimaneramodel.gestionmesas;

import java.time.LocalDateTime;
import com.restaurante.amm.amimaneramodel.clientes.Cliente;

public class Reserva {
    // Variables (atributos)
    private int idReserva;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
    private int cantidadPersonas;
    private EstadoReserva estado;
    private double montoReserva;
    private Mesa mesa;
    private Cliente cliente;
    
    //CONSTRUCTORES
    
    public Reserva(){
        this.mesa = new Mesa();
        this.cliente = null;
    }
    
    public Reserva(int idReserva, LocalDateTime fechaHoraInicio,
            LocalDateTime fechaHoraFin, int cantidadPersonas, EstadoReserva estado, 
            double montoReserva, Mesa mesa){
        
        this.idReserva=idReserva;
        this.fechaHoraInicio=fechaHoraInicio;
        this.fechaHoraFin=fechaHoraFin;
        this.cantidadPersonas=cantidadPersonas;
        this.estado=estado;
        this.montoReserva=montoReserva;
        this.mesa = new Mesa(mesa);
    }
    
    public Reserva(Reserva reserva){
        this.idReserva=reserva.idReserva;
        this.fechaHoraInicio=reserva.fechaHoraInicio;
        this.fechaHoraFin=reserva.fechaHoraFin;
        this.cantidadPersonas=reserva.cantidadPersonas;
        this.estado=reserva.estado;
        this.montoReserva=reserva.montoReserva;
        this.mesa = new Mesa(reserva.getMesa());
    }
    
    // Getters y Setters

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public LocalDateTime getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
    }

    public double getMontoReserva() {
        return montoReserva;
    }

    public void setMontoReserva(double montoReserva) {
        this.montoReserva = montoReserva;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
}

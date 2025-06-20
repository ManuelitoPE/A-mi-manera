package com.restaurante.amm.amimaneramodel.gestionmesas;

import java.time.LocalDateTime;
import com.restaurante.amm.amimaneramodel.clientes.PersonaJuridica;
import com.restaurante.amm.amimaneramodel.clientes.PersonaNatural;

public class Reserva {
    // Variables (atributos)
    private int idReserva;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
    private int cantidadPersonas;
    private EstadoReserva estado;
    private double montoReserva;
    private Mesa mesa;
    private PersonaNatural personaNatural;
    private PersonaJuridica personaJuridica;
    
    //CONSTRUCTORES
    
    public Reserva(){
        this.mesa = null;
        this.personaNatural = null;
        this.personaJuridica = null;
    }
    
    public Reserva(int idReserva, LocalDateTime fechaHoraInicio,
            LocalDateTime fechaHoraFin, int cantidadPersonas, EstadoReserva estado, 
            double montoReserva, Mesa mesa, PersonaNatural personaNatural,
            PersonaJuridica personaJuridica){
        
        this.idReserva=idReserva;
        this.fechaHoraInicio=fechaHoraInicio;
        this.fechaHoraFin=fechaHoraFin;
        this.cantidadPersonas=cantidadPersonas;
        this.estado=estado;
        this.montoReserva=montoReserva;
        this.mesa = new Mesa(mesa);
        this.personaNatural = new PersonaNatural(personaNatural);
        this.personaJuridica = new PersonaJuridica(personaJuridica);
        
    }
    
    public Reserva(Reserva reserva){
        this.idReserva=reserva.idReserva;
        this.fechaHoraInicio=reserva.fechaHoraInicio;
        this.fechaHoraFin=reserva.fechaHoraFin;
        this.cantidadPersonas=reserva.cantidadPersonas;
        this.estado=reserva.estado;
        this.montoReserva=reserva.montoReserva;
        this.mesa = new Mesa(reserva.mesa);
        this.personaNatural = new PersonaNatural(reserva.personaNatural);
        this.personaJuridica = new PersonaJuridica(reserva.personaJuridica);
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

    public PersonaNatural getPersonaNatural() {
        return personaNatural;
    }

    public void setPersonaNatural(PersonaNatural personaNatural) {
        this.personaNatural = personaNatural;
    }

    public PersonaJuridica getPersonaJuridica() {
        return personaJuridica;
    }

    public void setPersonaJuridica(PersonaJuridica personaJuridica) {
        this.personaJuridica = personaJuridica;
    }
    
}

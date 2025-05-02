package com.restaurante.amm.amimaneramodel.gestionmesas;

import java.time.LocalDateTime;
import java.util.Date;
import com.restaurante.amm.amimaneramodel.clientes.Cliente;
public class Reserva {
    // Variables (atributos)
    private int idReserva;
    private LocalDateTime horaInicio;
    private LocalDateTime horaFin;
    private int cantidadPersonas;
    private String estado;
    private LocalDateTime horaMaximaCancelacion;
    private double montoReserva;
    private Date fecha;
    private Mesa mesa;
    private Cliente cliente;
    
    //CONSTRUCTORES
    
    public Reserva(){
        this.mesa = new Mesa();
    }
    
    
    public Reserva(int idReserva, LocalDateTime horaInicio,
            LocalDateTime horaFin, int cantidadPersonas, String estado,
            LocalDateTime horaMaximaCancelacion,double montoReserva,
            Date fecha, Mesa mesa){
        
        this.idReserva=idReserva;
        this.horaInicio=horaInicio;
        this.horaFin=horaFin;
        this.cantidadPersonas=cantidadPersonas;
        this.estado=estado;
        this.horaMaximaCancelacion=horaMaximaCancelacion;
        this.montoReserva=montoReserva;
        this.fecha=fecha;
        this.mesa = new Mesa(mesa);
        
    }
    
    
    public Reserva(Reserva reserva){
        this.idReserva=reserva.idReserva;
        this.horaInicio=reserva.horaInicio;
        this.horaFin=reserva.horaFin;
        this.cantidadPersonas=reserva.cantidadPersonas;
        this.estado=reserva.estado;
        this.horaMaximaCancelacion=reserva.horaMaximaCancelacion;
        this.montoReserva=reserva.montoReserva;
        this.fecha=reserva.fecha;
        this.mesa = new Mesa(reserva.mesa);
    }
    
    // Getters y Setters

    /**
     * @return the idReserva
     */
    public int getIdReserva() {
        return idReserva;
    }

    /**
     * @param idReserva the idReserva to set
     */
    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    /**
     * @return the horaInicio
     */
    public LocalDateTime getHoraInicio() {
        return horaInicio;
    }

    /**
     * @param horaInicio the horaInicio to set
     */
    public void setHoraInicio(LocalDateTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * @return the horaFin
     */
    public LocalDateTime getHoraFin() {
        return horaFin;
    }

    /**
     * @param horaFin the horaFin to set
     */
    public void setHoraFin(LocalDateTime horaFin) {
        this.horaFin = horaFin;
    }

    /**
     * @return the cantidadPersonas
     */
    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    /**
     * @param cantidadPersonas the cantidadPersonas to set
     */
    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the horaMaximaCancelacion
     */
    public LocalDateTime getHoraMaximaCancelacion() {
        return horaMaximaCancelacion;
    }

    /**
     * @param horaMaximaCancelacion the horaMaximaCancelacion to set
     */
    public void setHoraMaximaCancelacion(LocalDateTime horaMaximaCancelacion) {
        this.horaMaximaCancelacion = horaMaximaCancelacion;
    }

    /**
     * @return the montoReserva
     */
    public double getMontoReserva() {
        return montoReserva;
    }

    /**
     * @param montoReserva the montoReserva to set
     */
    public void setMontoReserva(double montoReserva) {
        this.montoReserva = montoReserva;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the mesa
     */
    public Mesa getMesa() {
        return mesa;
    }

    /**
     * @param mesa the mesa to set
     */
    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
}

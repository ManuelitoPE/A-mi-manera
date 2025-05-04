package com.restaurante.amm.amimaneramodel.pagos;

import com.restaurante.amm.amimaneramodel.gestionmesas.Reserva;
import com.restaurante.amm.amimaneramodel.pedidos.Pedido;
import java.util.Date;

public abstract class ComprobantePago {
    
    private int idComprobantePago;
    private Date fechaEmision;
    private MetodoPago metodoPago;
    private double montoTotal;
    private double montoPropina;
    private double montoSinIGV;
    private double montoIGV;
    private double montoReserva;
    
    private Pedido pedido;
    private Reserva reserva;

    //CONSTRUCTORES
    public ComprobantePago(){
        pedido = new Pedido();
        reserva = new Reserva();
    }
    
    public ComprobantePago(int idComprobantePago, Date fechaEmision, MetodoPago metodoPago,
            double montoTotal, double montoPropina, double montoSinIGV,
            double montoIGV, double montoReserva, Pedido pedido, Reserva reserva){
        
        this.pedido = new Pedido(pedido);
        this.reserva = new Reserva(reserva);
        this.idComprobantePago = idComprobantePago;
        this.fechaEmision = fechaEmision;
        this.metodoPago = metodoPago;
        this.montoTotal = montoTotal;
        this.montoPropina = montoPropina;
        this.montoSinIGV = montoSinIGV;
        this.montoIGV = montoIGV;
        this.montoReserva = montoReserva;
    }
    
    public ComprobantePago (ComprobantePago comprobantePago){
        this.idComprobantePago = comprobantePago.idComprobantePago;
        this.fechaEmision = comprobantePago.fechaEmision;
        this.metodoPago = comprobantePago.metodoPago;
        this.montoTotal = comprobantePago.montoTotal;
        this.montoPropina = comprobantePago.montoPropina;
        this.montoSinIGV = comprobantePago.montoSinIGV;
        this.montoIGV = comprobantePago.montoIGV;
        this.montoReserva = comprobantePago.montoReserva;
        this.pedido = new Pedido(comprobantePago.pedido);
        this.reserva = new Reserva(comprobantePago.reserva);
    }
    //GETERS Y SETERS
    /**
     * @return the idComprobantePago
     */
    public int getIdComprobantePago() {
        return idComprobantePago;
    }

    /**
     * @param idComprobantePago the idComprobantePago to set
     */
    public void setIdComprobantePago(int idComprobantePago) {
        this.idComprobantePago = idComprobantePago;
    }

    /**
     * @return the fechaEmision
     */
    public Date getFechaEmision() {
        return fechaEmision;
    }

    /**
     * @param fechaEmision the fechaEmision to set
     */
    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    /**
     * @return the metodoPago
     */
    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    /**
     * @param metodoPago the metodoPago to set
     */
    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    /**
     * @return the montoTotal
     */
    public double getMontoTotal() {
        return montoTotal;
    }

    /**
     * @param montoTotal the montoTotal to set
     */
    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    /**
     * @return the montoPropina
     */
    public double getMontoPropina() {
        return montoPropina;
    }

    /**
     * @param montoPropina the montoPropina to set
     */
    public void setMontoPropina(double montoPropina) {
        this.montoPropina = montoPropina;
    }

    /**
     * @return the montoSinIGV
     */
    public double getMontoSinIGV() {
        return montoSinIGV;
    }

    /**
     * @param montoSinIGV the montoSinIGV to set
     */
    public void setMontoSinIGV(double montoSinIGV) {
        this.montoSinIGV = montoSinIGV;
    }

    /**
     * @return the montoIGV
     */
    public double getMontoIGV() {
        return montoIGV;
    }

    /**
     * @param montoIGV the montoIGV to set
     */
    public void setMontoIGV(double montoIGV) {
        this.montoIGV = montoIGV;
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
     * @return the pedido
     */
    public Pedido getPedido() {
        return pedido;
    }

    /**
     * @param pedido the pedido to set
     */
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    /**
     * @return the reserva
     */
    public Reserva getReserva() {
        return reserva;
    }

    /**
     * @param reserva the reserva to set
     */
    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

}

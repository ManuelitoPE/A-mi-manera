package com.restaurante.amm.amimaneramodel.pagos;

import java.util.ArrayList;
import java.util.Date;
import com.restaurante.amm.amimaneramodel.gestionmesas.Reserva;
import com.restaurante.amm.amimaneramodel.pedidos.Pedido;

public class Factura extends ComprobantePago {
    
    private String RUC;
    private String razonSocial;
    private ArrayList<DetalleFactura> listaDetalleFactura;
   
    //CONSTRUCTORES
    
    public Factura(){
        super();
        listaDetalleFactura = new ArrayList<>();
    }
    
    public Factura(int idComprobantePago, Date fechaEmision, MetodoPago metodoPago,
            double montoTotal, double montoPropina, double montoSinIGV,
            double montoIGV, double montoReserva, Pedido pedido, Reserva reserva,
            String RUC, String razonSocial, 
            ArrayList<DetalleFactura> listaDetalleFactura){
        
        super(idComprobantePago, fechaEmision, metodoPago,montoTotal, montoPropina,
                montoSinIGV, montoIGV, montoReserva, pedido, reserva);
        this.RUC = RUC;
        this.razonSocial = razonSocial;
        this.listaDetalleFactura = new ArrayList<>(listaDetalleFactura);
    }
    
    public Factura(Factura factura){
        super(factura);
        this.RUC = factura.RUC;
        this.razonSocial = factura.razonSocial;
        this.listaDetalleFactura = new ArrayList<>(factura.listaDetalleFactura);
    }
    
    //GETERS Y SETERS

    /**
     * @return the RUC
     */
    public String getRUC() {
        return RUC;
    }

    /**
     * @param RUC the RUC to set
     */
    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    /**
     * @return the razonSocial
     */
    public String getRazonSocial() {
        return razonSocial;
    }

    /**
     * @param razonSocial the razonSocial to set
     */
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    /**
     * @return the listaDetalleFactura
     */
    public ArrayList<DetalleFactura> getListaDetalleFactura() {
        return listaDetalleFactura;
    }

    /**
     * @param listaDetalleFactura the listaDetalleFactura to set
     */
    public void setListaDetalleFactura(ArrayList<DetalleFactura> listaDetalleFactura) {
        this.listaDetalleFactura = listaDetalleFactura;
    }
    
    
}

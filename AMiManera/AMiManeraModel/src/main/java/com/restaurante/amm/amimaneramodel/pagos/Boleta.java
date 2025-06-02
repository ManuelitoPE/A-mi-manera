package com.restaurante.amm.amimaneramodel.pagos;

import java.util.ArrayList;
import java.util.Date;
import com.restaurante.amm.amimaneramodel.gestionmesas.Reserva;
import com.restaurante.amm.amimaneramodel.pedidos.Pedido;

public class Boleta extends ComprobantePago {
    
    private ArrayList<DetalleBoleta> listaDetalleBoleta;
    
    //CONSTRUCTORES
    public Boleta(){
        super();
        listaDetalleBoleta = new ArrayList<>();
    }
    
    public Boleta(int idComprobantePago, Date fechaEmision, MetodoPago metodoPago,
            double montoTotal, double montoPropina, double montoSinIGV,
            double montoIGV, Pedido pedido, Reserva reserva,
            ArrayList<DetalleBoleta> listaDetalleBoleta){
        super(idComprobantePago, fechaEmision, metodoPago,montoTotal, montoPropina,
                montoSinIGV, montoIGV, pedido, reserva);
        this.listaDetalleBoleta = new ArrayList<>(listaDetalleBoleta);
    }
    
    public Boleta(Boleta boleta){
        super(boleta);
        this.listaDetalleBoleta = new ArrayList<>(boleta.listaDetalleBoleta);
    }

    //GETERS Y SETERS
    /**
     * @return the listaDetalleBoleta
     */
    public ArrayList<DetalleBoleta> getListaDetalleBoleta() {
        return listaDetalleBoleta;
    }

    /**
     * @param listaDetalleBoleta the listaDetalleBoleta to set
     */
    public void setListaDetalleBoleta(ArrayList<DetalleBoleta> listaDetalleBoleta) {
        this.listaDetalleBoleta = listaDetalleBoleta;
    }
    
}

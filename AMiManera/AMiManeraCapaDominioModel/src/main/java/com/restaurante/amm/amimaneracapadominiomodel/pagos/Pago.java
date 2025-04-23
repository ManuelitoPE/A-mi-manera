package com.restaurante.amm.amimaneracapadominiomodel.pagos;

import java.util.Date;

public class Pago {
    
    private int idPago;
    private Date fechaEmision;
    
    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }
}

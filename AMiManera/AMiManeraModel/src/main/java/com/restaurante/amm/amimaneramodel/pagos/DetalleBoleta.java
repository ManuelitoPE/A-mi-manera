package com.restaurante.amm.amimaneramodel.pagos;

public class DetalleBoleta {
    private int idDetalleBoleta;
    private String nombreProducto;
    private double montoProducto;
    private int idComprobante;

    //CONSTRUCTORES
    
    public DetalleBoleta(){
    }
    
    public DetalleBoleta(int idDetalleBoleta, String nombreProducto,
            double montoProducto, int idComprobante){
        this.idDetalleBoleta = idDetalleBoleta;
        this.nombreProducto = nombreProducto;
        this.montoProducto = montoProducto;
        this.idComprobante = idComprobante;
    }
    
    public DetalleBoleta(DetalleBoleta detalleBoleta){
        this.idDetalleBoleta = detalleBoleta.idDetalleBoleta;
        this.nombreProducto = detalleBoleta.nombreProducto;
        this.montoProducto = detalleBoleta.montoProducto;
        this.idComprobante = detalleBoleta.idComprobante;
    }
    
    
    //GETERS Y SETERS
    /**
     * @return the idDetalleBoleta
     */
    public int getIdDetalleBoleta() {
        return idDetalleBoleta;
    }

    /**
     * @param idDetalleBoleta the idDetalleBoleta to set
     */
    public void setIdDetalleBoleta(int idDetalleBoleta) {
        this.idDetalleBoleta = idDetalleBoleta;
    }

    /**
     * @return the nombreProducto
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    /**
     * @param nombreProducto the nombreProducto to set
     */
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    /**
     * @return the montoProducto
     */
    public double getMontoProducto() {
        return montoProducto;
    }

    /**
     * @param montoProducto the montoProducto to set
     */
    public void setMontoProducto(double montoProducto) {
        this.montoProducto = montoProducto;
    }

    public int getIdComprobante() {
        return idComprobante;
    }

    public void setIdComprobante(int idComprobante) {
        this.idComprobante = idComprobante;
    }
    
    

}

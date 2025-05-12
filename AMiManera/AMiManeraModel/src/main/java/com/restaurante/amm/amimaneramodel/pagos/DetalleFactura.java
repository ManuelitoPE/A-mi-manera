package com.restaurante.amm.amimaneramodel.pagos;

public class DetalleFactura {
    private int idDetalleFactura;
    private String nombreProducto;
    private double subtotalIGV;
    private double subtotalSinIGV;
    private double subtotalFinal;
    private int idComprobante;
    
    //CONSTRUCTORES
    
    public DetalleFactura(){
    }
    
    public DetalleFactura(int idDetalleFactura, String nombreProducto,
            double subtotalIGV, double subtotalSinIGV, double subtotalFinal,
            int idComprobante){
        this.idDetalleFactura = idDetalleFactura;
        this.nombreProducto = nombreProducto;
        this.subtotalIGV = subtotalIGV;
        this.subtotalSinIGV = subtotalSinIGV;
        this.subtotalFinal = subtotalFinal;
        this.idComprobante = idComprobante;
    }
    
    public DetalleFactura(DetalleFactura detalleFactura){
        this.idDetalleFactura = detalleFactura.idDetalleFactura;
        this.nombreProducto = detalleFactura.nombreProducto;
        this.subtotalIGV = detalleFactura.subtotalIGV;
        this.subtotalSinIGV = detalleFactura.subtotalSinIGV;
        this.subtotalFinal = detalleFactura.subtotalFinal;
        this.idComprobante = detalleFactura.idComprobante;
    }
    
    //GETERS Y SETERS
    /**
     * @return the idDetalleFactura
     */
    public int getIdDetalleFactura() {
        return idDetalleFactura;
    }

    /**
     * @param idDetalleFactura the idDetalleFactura to set
     */
    public void setIdDetalleFactura(int idDetalleFactura) {
        this.idDetalleFactura = idDetalleFactura;
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
     * @return the subtotalIGV
     */
    public double getSubtotalIGV() {
        return subtotalIGV;
    }

    /**
     * @param subtotalIGV the subtotalIGV to set
     */
    public void setSubtotalIGV(double subtotalIGV) {
        this.subtotalIGV = subtotalIGV;
    }

    /**
     * @return the subtotalSinIGV
     */
    public double getSubtotalSinIGV() {
        return subtotalSinIGV;
    }

    /**
     * @param subtotalSinIGV the subtotalSinIGV to set
     */
    public void setSubtotalSinIGV(double subtotalSinIGV) {
        this.subtotalSinIGV = subtotalSinIGV;
    }

    /**
     * @return the subtotalFinal
     */
    public double getSubtotalFinal() {
        return subtotalFinal;
    }

    /**
     * @param subtotalFinal the subtotalFinal to set
     */
    public void setSubtotalFinal(double subtotalFinal) {
        this.subtotalFinal = subtotalFinal;
    }

    /**
     * @return the idComprobante
     */
    public int getIdComprobante() {
        return idComprobante;
    }

    /**
     * @param idComprobante the idComprobante to set
     */
    public void setIdComprobante(int idComprobante) {
        this.idComprobante = idComprobante;
    }
    
    
}

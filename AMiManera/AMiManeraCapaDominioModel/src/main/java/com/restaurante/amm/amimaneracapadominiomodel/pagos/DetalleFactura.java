package com.restaurante.amm.amimaneracapadominiomodel.pagos;

public class DetalleFactura {
    private int idDetalleFactura;
    private String nombreProducto;
    private double subtotalIGV;
    private double subtotalSinIGV;
    private double subtotalFinal;
    
    //CONSTRUCTORES
    
    public DetalleFactura(){
    }
    
    public DetalleFactura(int idDetalleFactura, String nombreProducto,
            double subtotalIGV, double subtotalSinIGV, double subtotalFinal){
        this.idDetalleFactura = idDetalleFactura;
        this.nombreProducto = nombreProducto;
        this.subtotalIGV = subtotalIGV;
        this.subtotalSinIGV = subtotalSinIGV;
        this.subtotalFinal = subtotalFinal;
    }
    
    public DetalleFactura(DetalleFactura detalleFactura){
        this.idDetalleFactura = detalleFactura.idDetalleFactura;
        this.nombreProducto = detalleFactura.nombreProducto;
        this.subtotalIGV = detalleFactura.subtotalIGV;
        this.subtotalSinIGV = detalleFactura.subtotalSinIGV;
        this.subtotalFinal = detalleFactura.subtotalFinal;
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
    
    
}

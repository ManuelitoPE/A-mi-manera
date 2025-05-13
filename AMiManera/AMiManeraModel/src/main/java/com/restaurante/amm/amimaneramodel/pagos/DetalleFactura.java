package com.restaurante.amm.amimaneramodel.pagos;

import com.restaurante.amm.amimaneramodel.pedidos.Producto;

public class DetalleFactura {
    private int idDetalleFactura;
    private int cantidadProducto;
    private double precioUnitario;
    private double subTotal;
    private Producto producto;
    private Factura factura;
    
    //CONSTRUCTORES
    
    public DetalleFactura(){
        producto = new Producto();
        factura  = new Factura();
    }
    
    public DetalleFactura(int idDetalleFactura, int cantidadProducto,
            double precioUnitario, double subTotal, Producto producto,
            Factura factura){
        this.idDetalleFactura = idDetalleFactura;
        this.cantidadProducto =  cantidadProducto;
        this.precioUnitario = precioUnitario;
        this.subTotal = subTotal;
        this.producto = producto;
        this.factura = factura;
    }
    
    public DetalleFactura(DetalleFactura detalleFactura){
        this.idDetalleFactura = detalleFactura.idDetalleFactura;
        this.cantidadProducto = detalleFactura.cantidadProducto;
        this.precioUnitario = detalleFactura.precioUnitario;
        this.subTotal = detalleFactura.subTotal;
        this.producto = detalleFactura.producto;
        this.factura = detalleFactura.factura;
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
     * @return the cantidadProducto
     */
    public int getCantidadProducto() {
        return cantidadProducto;
    }

    /**
     * @param cantidadProducto the cantidadProducto to set
     */
    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    /**
     * @return the precioUnitario
     */
    public double getPrecioUnitario() {
        return precioUnitario;
    }

    /**
     * @param precioUnitario the precioUnitario to set
     */
    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    /**
     * @return the subTotal
     */
    public double getSubTotal() {
        return subTotal;
    }

    /**
     * @param subTotal the subTotal to set
     */
    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    /**
     * @return the producto
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * @return the factura
     */
    public Factura getFactura() {
        return factura;
    }

    /**
     * @param factura the factura to set
     */
    public void setFactura(Factura factura) {
        this.factura = factura;
    }
    
}

package com.restaurante.amm.amimaneramodel.pagos;

import com.restaurante.amm.amimaneramodel.pedidos.Producto;

public class DetalleBoleta {
    private int idDetalleBoleta;
    private int cantidadProducto;
    private double precioUnitario;
    private double subTotal;
    
    
    private Producto producto;
    private Boleta boleta;
    //CONSTRUCTORES
    
    public DetalleBoleta(){
        producto = new Producto();
        boleta = new Boleta();
    }
    
    public DetalleBoleta(int idDetalleBoleta, int cantidadProducto,
            Producto producto, double precioUnitario, double subTotal){
        this.idDetalleBoleta = idDetalleBoleta;
        this.cantidadProducto = cantidadProducto;
        this.producto = new Producto(producto);
        this.boleta = new Boleta(boleta);
        this.precioUnitario = precioUnitario;
        this.subTotal = subTotal;
    }
    
    public DetalleBoleta(DetalleBoleta detalleBoleta){
        this.idDetalleBoleta = detalleBoleta.idDetalleBoleta;
        this.cantidadProducto = detalleBoleta.cantidadProducto;
        this.producto = new Producto(detalleBoleta.producto);
        this.boleta = new Boleta(detalleBoleta.boleta);
        this.precioUnitario = detalleBoleta.precioUnitario;
        this.subTotal = detalleBoleta.subTotal;
    }
    
    
    //GETERS Y SETERS

    public int getIdDetalleBoleta() {
        return idDetalleBoleta;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public Producto getProducto() {
        return producto;
    }
    
    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public Boleta getBoleta() {
        return boleta;
    }

    public void setIdDetalleBoleta(int idDetalleBoleta) {
        this.idDetalleBoleta = idDetalleBoleta;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public void setBoleta(Boleta boleta) {
        this.boleta = boleta;
    }
    
    
}

package com.restaurante.amm.amimaneramodel.pagos;

import com.restaurante.amm.amimaneramodel.pedidos.Producto;

public class DetalleFactura {
    private int idDetalleFactura;
    private int cantidadProducto;
    private double precioUnitario;
    private double subTotal;
    private Producto producto;
    private Factura factura;

    // Constructores
    public DetalleFactura() {
        producto = new Producto();
        factura = new Factura();
    }

    public DetalleFactura(int idDetalleFactura, int cantidadProducto, Producto producto, double precioUnitario, double subTotal) {
        this.idDetalleFactura = idDetalleFactura;
        this.cantidadProducto = cantidadProducto;
        this.producto = new Producto(producto);
        this.factura = new Factura();
        this.precioUnitario = precioUnitario;
        this.subTotal = subTotal;
<<<<<<< HEAD
=======
        this.producto = new Producto(producto);
        this.factura = new Factura(factura);
>>>>>>> 1a8582190c446185f911e4068490c0009715d489
    }

    public DetalleFactura(DetalleFactura detalleFactura) {
        this.idDetalleFactura = detalleFactura.idDetalleFactura;
        this.cantidadProducto = detalleFactura.cantidadProducto;
        this.producto = new Producto(detalleFactura.producto);
        this.factura = new Factura(detalleFactura.factura);
        this.precioUnitario = detalleFactura.precioUnitario;
        this.subTotal = detalleFactura.subTotal;
<<<<<<< HEAD
=======
        this.producto = new Producto(detalleFactura.producto);
        this.factura = new Factura(detalleFactura.factura);
>>>>>>> 1a8582190c446185f911e4068490c0009715d489
    }

    // Getters y Setters
    public int getIdDetalleFactura() {
        return idDetalleFactura;
    }

    public void setIdDetalleFactura(int idDetalleFactura) {
        this.idDetalleFactura = idDetalleFactura;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }
}

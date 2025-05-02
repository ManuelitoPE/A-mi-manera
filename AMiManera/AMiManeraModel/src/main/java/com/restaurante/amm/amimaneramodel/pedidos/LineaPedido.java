package com.restaurante.amm.amimaneramodel.pedidos;

public class LineaPedido {
    //Atributos
    private int idLineaPedido;
    private Producto producto;
    private int cantidad;
    private double montoParcial;
    private String descripcion;

    //Constructores
    public LineaPedido(){}
    public LineaPedido(int idLineaPedido, Producto producto,
                       int cantidad, double montoParcial){
        this.idLineaPedido = idLineaPedido;
        this.producto = new Producto(producto);
        this.cantidad = cantidad;
        this.montoParcial = montoParcial;
    }
    public LineaPedido(LineaPedido lineaPedido){
        idLineaPedido = lineaPedido.idLineaPedido;
        producto = new Producto(lineaPedido.producto);
        cantidad = lineaPedido.cantidad;
        montoParcial = lineaPedido.montoParcial;
    }
    
    //Setters
    public void setIdLineaPedido(int idLineaPedido){
        this.idLineaPedido = idLineaPedido;
    }
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    public void setMontoParcial(double montoParcial){
        this.montoParcial = montoParcial;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    //Getters
    public int getIdLineaPedido(){
        return idLineaPedido;
    }
    public int getCantidad(){
        return cantidad;
    }
    public double getMontoParcial(){
        return montoParcial;
    }
    public String getDescripcion() {
        return descripcion;
    }

    //Funciones
    public void guardarDetalle(){
        
    }
}

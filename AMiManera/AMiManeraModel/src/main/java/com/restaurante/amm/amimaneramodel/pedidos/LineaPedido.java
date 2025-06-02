package com.restaurante.amm.amimaneramodel.pedidos;

public class LineaPedido {
    //Atributos
    private int idLineaPedido;
    private int cantidadProducto;
    
    private Producto producto;
    private Pedido pedido;

    //Constructores
    public LineaPedido(){}
    public LineaPedido(int idLineaPedido, int cantidad,  Producto producto,
                       Pedido pedido){
        
        this.idLineaPedido = idLineaPedido;
        this.cantidadProducto = cantidad;
        
        this.producto = new Producto(producto);
        this.pedido = new Pedido(pedido);
    }
    public LineaPedido(LineaPedido lineaPedido){
        this.idLineaPedido = lineaPedido.idLineaPedido;
        this.cantidadProducto = lineaPedido.cantidadProducto;
        
        this.producto = new Producto(lineaPedido.producto);
        this.pedido = new Pedido(lineaPedido.pedido);
    }
    
    //Setters
    public void setIdLineaPedido(int idLineaPedido) {
        this.idLineaPedido = idLineaPedido;
    }
    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    //Getters
    public int getIdLineaPedido(){
        return idLineaPedido;   
    }
    public int getCantidadProducto() {
        return cantidadProducto;
    }
    public Producto getProducto() {
        return producto;
    }
    public Pedido getPedido() {    
        return pedido;
    }

    
    //Funciones
    public void guardarDetalle() {
    }
}

package com.restaurante.amm.amimaneracapadominiomodel.pedidos;

import java.sql.Timestamp;
import java.util.List;

public class Pedido {
    //Atributos
    private int idPedido;
    private Timestamp fecha;
    private EstadoPedido estadoPedido;
    private double montoTotal;
    private double montoDescuentoPromocion;
    private List<LineaPedido> listaLineaPedido;

    //Contructores
    public Pedido(){}
    public Pedido(int idPedido, Timestamp fecha, EstadoPedido estadoPedido,
                  double montoTotal, List<LineaPedido> listaLineaPedidos){
        this.idPedido = idPedido;
        this.fecha = fecha;
        this.estadoPedido = estadoPedido;
        this.montoTotal = montoTotal;
        this.listaLineaPedido = listaLineaPedidos;
    }
    public Pedido(Pedido pedido){
        idPedido = pedido.idPedido;
        fecha = pedido.fecha;
        estadoPedido = pedido.estadoPedido;
        montoTotal = pedido.montoTotal;
        listaLineaPedido = pedido.listaLineaPedido;
    }
    
    //Setters
    public void setIdProducto(int idPedido){
        this.idPedido = idPedido;
    }
    public void setFecha(Timestamp fecha){
        this.fecha = fecha;
    }
    public void setEstadoPedido(EstadoPedido estadoPedido){
        this.estadoPedido = estadoPedido;
    }
    public void setMontoTotal(double montoTotal){
        this.montoTotal = montoTotal;
    }
    public void setListaLineaPedidos(List<LineaPedido> listaLineaPedido){
        this.listaLineaPedido = listaLineaPedido;
    }
    public void setMontoDescuentoPromocion(double montoDescuentoPromocion) {
        this.montoDescuentoPromocion = montoDescuentoPromocion;
    }
    
    //Getters
    public int getIdProducto(){
        return idPedido;
    }
    public Timestamp getFecha(){
        return fecha;
    }
    public EstadoPedido getEstadoPedido(){
        return estadoPedido;
    }
    public double getMontoTotal(){
        return montoTotal;
    }
    public List<LineaPedido> getListLineaPedidop(){
        return listaLineaPedido;
    }
    public double getMontoDescuentoPromocion() {
        return montoDescuentoPromocion;
    }
}

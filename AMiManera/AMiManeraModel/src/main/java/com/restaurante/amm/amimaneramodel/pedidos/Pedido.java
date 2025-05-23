package com.restaurante.amm.amimaneramodel.pedidos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.restaurante.amm.amimaneramodel.gestionmesas.Mesa;
import com.restaurante.amm.amimaneramodel.personal.Mesero;

public class Pedido {
    //Atributos
    private int idPedido;
    private Date fecha;
    private EstadoPedido estadoPedido;
    private double montoTotal;
    
    private List<LineaPedido> listaLineaPedido;
    private Mesa mesa;
    private Mesero mesero;
    
    //Contructores
    public Pedido(){
        listaLineaPedido = new ArrayList<>();
        mesa = new Mesa();
        mesero = new Mesero();
    }
    public Pedido(int idPedido, Date fecha, EstadoPedido estadoPedido,
                  double montoTotal, List<LineaPedido> listaLineaPedidos,
                  Mesa mesa, Mesero mesero){
        this.idPedido = idPedido;
        this.fecha = fecha;
        this.estadoPedido = estadoPedido;
        this.montoTotal = montoTotal;
        this.listaLineaPedido = new ArrayList<>(listaLineaPedidos);
        this.mesa = new Mesa(mesa);
        this.mesero = new Mesero(mesero);
    }
    public Pedido(Pedido pedido){
        idPedido = pedido.idPedido;
        fecha = pedido.fecha;
        estadoPedido = pedido.estadoPedido;
        montoTotal = pedido.montoTotal;
        listaLineaPedido = new ArrayList<>(pedido.listaLineaPedido);
        mesa = new Mesa(pedido.mesa);
        mesero = new Mesero(pedido.mesero);
    }
    
    //Setters
    public void setIdPedido(int idPedido){
        this.idPedido = idPedido;
    }
    public void setFecha(Date fecha){
        this.fecha = fecha;
    }
    public void setEstadoPedido(EstadoPedido estadoPedido){
        this.estadoPedido = estadoPedido;
    }
    public void setMontoTotal(double montoTotal){
        this.montoTotal = montoTotal;
    }
    public void setListaLineaPedido(List<LineaPedido> listaLineaPedido){
        this.listaLineaPedido = listaLineaPedido;
    }
    
    //Getters
    public int getIdPedido(){
        return idPedido;
    }
    public Date getFecha(){
        return fecha;
    }
    public EstadoPedido getEstadoPedido(){
        return estadoPedido;
    }
    public double getMontoTotal(){
        return montoTotal;
    }
    public List<LineaPedido> getListLineaPedido(){
        return listaLineaPedido;
    }

    /**
     * @return the mesa
     */
    public Mesa getMesa() {
        return mesa;
    }

    /**
     * @param mesa the mesa to set
     */
    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    /**
     * @return the mesero
     */
    public Mesero getMesero() {
        return mesero;
    }

    /**
     * @param mesero the mesero to set
     */
    public void setMesero(Mesero mesero) {
        this.mesero = mesero;
    }
}

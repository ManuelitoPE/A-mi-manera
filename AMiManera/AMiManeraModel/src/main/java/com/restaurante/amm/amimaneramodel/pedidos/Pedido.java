package com.restaurante.amm.amimaneramodel.pedidos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.restaurante.amm.amimaneramodel.gestionmesas.Mesa;
import com.restaurante.amm.amimaneramodel.personal.Trabajador;

public class Pedido {
    //Atributos
    private int idPedido;
    private Date fecha;
    private EstadoPedido estadoPedido;
    private double montoTotal;
    private List<LineaPedido> listaLineaPedido;
    private Mesa mesa;
    private Trabajador trabajador;
    
    //Contructores
    public Pedido(){
        listaLineaPedido = new ArrayList<>();
        fecha = new Date();
        estadoPedido = EstadoPedido.EN_ORDEN;
        mesa = new Mesa();
        trabajador = new Trabajador();
        montoTotal = 0;
    }
    public Pedido(int idPedido, Date fecha, EstadoPedido estadoPedido,
                  double montoTotal, List<LineaPedido> listaLineaPedidos,
                  Mesa mesa, Trabajador trabajador){
        this.idPedido = idPedido;
        this.fecha = fecha;
        this.estadoPedido = estadoPedido;
        this.montoTotal = montoTotal;
        this.listaLineaPedido = new ArrayList<>(listaLineaPedidos);
        this.mesa = new Mesa(mesa);
        this.trabajador = new Trabajador(trabajador);
    }
    public Pedido(Pedido pedido){
        idPedido = pedido.idPedido;
        fecha = pedido.fecha;
        estadoPedido = pedido.estadoPedido;
        montoTotal = pedido.montoTotal;
        listaLineaPedido = new ArrayList<>(pedido.listaLineaPedido);
        mesa = new Mesa(pedido.mesa);
        trabajador = new Trabajador(pedido.trabajador);
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


    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }


    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }
}

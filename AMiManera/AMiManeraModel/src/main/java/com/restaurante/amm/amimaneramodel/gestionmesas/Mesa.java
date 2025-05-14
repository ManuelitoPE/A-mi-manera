package com.restaurante.amm.amimaneramodel.gestionmesas;

import com.restaurante.amm.amimaneramodel.pedidos.Pedido;
import java.util.ArrayList;

public class Mesa {
    //Atributos
    private int idMesa;
    private int cantidadAsientos;
    private EstadoMesa estado;
    
    private ArrayList<Pedido> listaPedidos;
    private ArrayList<Reserva> listaReservas;

    //Constructores
    public Mesa(){
        listaPedidos = new ArrayList<>();
        listaReservas = new ArrayList<>();
    }
    public Mesa(int idMesa,EstadoMesa estado,int cantidadAsientos,
                ArrayList<Pedido> listaPedidos, ArrayList<Reserva> listaReservas){
        this.idMesa = idMesa;
        this.estado = estado;
        this.cantidadAsientos = cantidadAsientos;
        this.listaPedidos = new ArrayList<>(listaPedidos);
        this.listaReservas = new ArrayList<>(listaReservas);
    }
    public Mesa(Mesa mesa){
        this.idMesa = mesa.idMesa;
        this.estado = mesa.estado;
        this.cantidadAsientos = mesa.cantidadAsientos;
        this.listaPedidos = new ArrayList<>(mesa.getListaPedidos());
        this.listaReservas = new ArrayList<>(mesa.getListaReservas());       
    }
    
    //Getters y setters

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public EstadoMesa getEstado() {
        return estado;
    }

    public void setEstado(EstadoMesa estado) {
        this.estado = estado;
    }

    public int getCantidadAsientos() {
        return cantidadAsientos;
    }

    public void setCantidadAsientos(int cantidadAsientos) {
        this.cantidadAsientos = cantidadAsientos;
    }

    public ArrayList<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(ArrayList<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public ArrayList<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(ArrayList<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }
    
    

    
}
